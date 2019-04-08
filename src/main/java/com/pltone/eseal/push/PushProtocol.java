package com.pltone.eseal.push;

import com.pltone.common.exception.ArgumentVerifyException;
import com.pltone.common.util.BytesUtil;
import com.pltone.common.util.JSONUtil;
import com.pltone.eseal.util.RC4Util;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息推送协议
 *
 * @author chenlong
 * @version 1.0 2019-04-02
 */
@Getter
@Setter
@ToString
public class PushProtocol implements Serializable {
    private static final long serialVersionUID = 1827714027334560662L;
    /** 客户端类型（1、用户中心、2、车台） */
    private int client_type;
    /** 客户端ID（用户中心ID或者车台ID） */
    private long client_id;
    /** 通知类型（1、报警 2、服务器通知） */
    private int notice_type;
    /** 通知对象列表（手机号或则账号） */
    private List<String> notice_targets;
    /** 通知模板ID（1、2） */
    private long template_id;
    /** 通知格式类型（1、文本、2、json） */
    private int notice_format;
    /** 通知内容（文本字符串 或者 json字符串） */
    private String notice_content;

    public PushProtocol() {}

    private PushProtocol(Builder builder) {
        this.client_type = builder.client_type;
        this.client_id = builder.client_id;
        this.notice_type = builder.notice_type;
        this.notice_targets = builder.notice_targets;
        this.template_id = builder.template_id;
        this.notice_format = builder.notice_format;
        this.notice_content = builder.notice_content;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int client_type;
        private long client_id;
        private int notice_type;
        private List<String> notice_targets = new ArrayList<>();
        private long template_id;
        private int notice_format;
        private String notice_content;

        /**
         * 客户端类型（1、用户中心、2、车台）
         */
        public Builder clientType(int client_type) {
            this.client_type = client_type;
            return this;
        }

        /**
         * 客户端类型为用户中心
         */
        public Builder center() {
            this.client_type = 1;
            return this;
        }

        /**
         * 客户端类型为设备（车台、出入库机...）
         */
        public Builder device() {
            this.client_type = 2;
            return this;
        }

        /**
         * 客户端ID（用户中心ID或者车台ID）
         */
        public Builder clientId(long client_id) {
            this.client_id = client_id;
            return this;
        }

        /**
         * 通知类型（1、报警 2、服务器通知）
         */
        public Builder noticeType(int notice_type) {
            this.notice_type = notice_type;
            return this;
        }

        /**
         * 报警通知
         */
        public Builder alarmNotice() {
            this.notice_type = 1;
            return this;
        }

        /**
         * 服务器通知
         */
        public Builder serverNotice() {
            this.notice_type = 2;
            return this;
        }

        /**
         * 添加通知对象（手机号或则账号）
         */
        public Builder noticeTarget(String notice_target) {
            this.notice_targets.add(notice_target);
            return this;
        }

        /**
         * 通知模板ID（1、2）
         */
        public Builder templateId(long template_id) {
            this.template_id = template_id;
            return this;
        }

        /**
         * 通知格式类型（1、文本、2、json）
         */
        public Builder noticeFormat(int notice_format) {
            this.notice_format = notice_format;
            return this;
        }

        /**
         * 文本格式
         */
        public Builder textFormat() {
            this.notice_format = 1;
            return this;
        }

        /**
         * JSON格式
         */
        public Builder jsonFormat() {
            this.notice_format = 2;
            return this;
        }

        /**
         * 通知内容（文本字符串 或者 json字符串）
         */
        public Builder noticeContent(String notice_content) {
            this.notice_content = notice_content;
            return this;
        }

        /**
         * 构建消息推送协议
         */
        public PushProtocol build() {
            return new PushProtocol(this);
        }
    }

    /**
     * 编码
     *
     * @return 编码的十六进制字符串
     */
    public String encode() {
        return encode(this);
    }

    /**
     * 编码
     *
     * @param protocol 消息推送协议
     * @return 编码的十六进制字符串
     */
    public static String encode(PushProtocol protocol) {
        byte[] idBytes = BytesUtil.LITTLE_ENDIAN_CODEC.getBytes((int) protocol.client_id);
        byte[] key = RC4Util.getKeyBy4Bytes(idBytes);
        String json = JSONUtil.stringify(protocol);
        String hex = RC4Util.rc4ToHexString(json, key);
        String id = BytesUtil.BASE_16.encode(idBytes);
        return id.substring(0, 4) + hex + id.substring(4);
    }

    /**
     * 解码
     *
     * @param hexString 编码的十六进制字符串
     * @return 消息推送协议
     */
    public static PushProtocol decode(String hexString) {
        if (StringUtils.isBlank(hexString)) {
            throw new ArgumentVerifyException("协议报文为空");
        }
        hexString = StringUtils.strip(hexString);
        int len = hexString.length();
        if (len < 121) {
            throw new ArgumentVerifyException("协议报文太短");
        }
        String idHex = hexString.substring(0, 4) + hexString.substring(len - 4);
        byte[] idBytes = BytesUtil.BASE_16.decode(idHex);
        int id = BytesUtil.LITTLE_ENDIAN_CODEC.getInt(idBytes);
        byte[] key = RC4Util.getKeyBy4Bytes(idBytes);
        String hex = hexString.substring(4, len - 4);
        String json = RC4Util.rc4ToHexString(hex, key);
        PushProtocol protocol = JSONUtil.parseToObject(json, PushProtocol.class);
        if (Integer.toUnsignedLong(id) != protocol.client_id) {
            throw new ArgumentVerifyException("协议ID无效");
        }
        return protocol;
    }

}
