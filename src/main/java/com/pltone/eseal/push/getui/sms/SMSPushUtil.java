package com.pltone.eseal.push.getui.sms;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pltone.common.util.JSONUtil;
import com.pltone.common.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 短信推送工具类
 *
 * @author chenlong
 * @version 1.0 2019-03-28
 */
@Slf4j
public class SMSPushUtil {
    /** 鉴权url */
    public static final String AUTH_URL = "https://openapi-smsp.getui.com/v1/sps/auth_sign";
    /** 短信群推url */
    public static final String PUSH_URL = "https://openapi-smsp.getui.com/v1/sps/push_sms_list";

    private static final TypeReference<SMSResp<SMSAuthRespData>> AUTH_RESP_REF = new TypeReference<SMSResp<SMSAuthRespData>>() {};
    private static final TypeReference<SMSResp<SMSPushRespData>> PUSH_RESP_REF = new TypeReference<SMSResp<SMSPushRespData>>() {};

    private SMSPushUtil() {}

    /**
     * 鉴权请求
     *
     * @param SMSAuthReq 鉴权请求信息
     * @return 权限令牌，调用其他接口时需提供
     * @throws IOException
     */
    public static String auth(SMSAuthReq SMSAuthReq) throws IOException {
        SMSResp<SMSAuthRespData> authResp = JSONUtil.parse(req(AUTH_URL, SMSAuthReq.toString()), AUTH_RESP_REF);
        if (authResp.isSuccessful()) {
            return authResp.getData().getAuthToken();
        }
        throw new IOException("鉴权失败 " + authResp);
    }

    /**
     * 短信群推
     *
     * @param SMSPushReq 短信群推请求
     * @return 短信群推应答数据
     * @throws IOException
     */
    public static SMSPushRespData push(SMSPushReq SMSPushReq) throws IOException {
        SMSResp<SMSPushRespData> pushResp = JSONUtil.parse(req(PUSH_URL, SMSPushReq.toString()), PUSH_RESP_REF);
        if (pushResp.isSuccessful()) {
            return pushResp.getData();
        }
        throw new IOException("短信群推失败 " + pushResp);
    }

    /**
     * 发起HTTP请求
     *
     * @param url     请求URL
     * @param reqBody 请求体
     * @return 应答结果文本
     * @throws IOException
     */
    private static String req(String url, String reqBody) throws IOException {
        log.info("消息推送请求：" + reqBody);
        String respBody = OkHttpUtil.post(url, reqBody, OkHttpUtil.ContentType.JSON);
        log.info("消息推送应答：" + respBody);
        return respBody;
    }
}
