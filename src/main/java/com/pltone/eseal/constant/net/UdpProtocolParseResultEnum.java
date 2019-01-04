package com.pltone.eseal.constant.net;

/**
 * UDP协议解析结果枚举
 *
 * @author chenlong
 * @version 1.0 2018-03-15
 */
public enum UdpProtocolParseResultEnum {
    /** 应答数据解析成功 */
    SUCCESS(0, "应答数据解析成功！"),
    /** 接收数据为空 */
    RECEIVE_NULL(1, "接收数据为空！"),
    /** 接收数据字节数不符 */
    RECEIVE_LEN_INVALID(2, "接收数据字节数不符！"),
    /** CRC校验失败 */
    CRC_INVALID(3, "CRC校验失败！"),
    /** RC4密钥版本不符 */
    RC4_VER_INCONSISTENT(4, "RC4密钥版本不符！"),
    /** 应答协议号错误 */
    PROTOCOL_ID_ERROR(5, "应答协议号错误！"),
    /** 源终端地址错误 */
    SRC_TERM_ADDR_ERROR(6, "源终端地址错误！"),
    /** 目的终端地址错误 */
    DEST_TERM_ADDR_ERROR(7, "目的终端地址错误！"),
    /** 业务ID错误 */
    BIZ_ID_INCONSISTENT(8, "业务ID错误"),
    /** 序列号错误 */
    SERIAL_NO_INCONSISTENT(9, "序列号错误"),
    /** 数据体字节数不符 */
    DATA_LEN_INVALID(10, "数据体字节数不符！"),
    /** 应答数据体回复错误 */
    DATA_REPLY_ERROR(11, "应答数据体回复错误！"),
    /** 应答数据体通用错误 */
    DATA_COMMON_ERROR(12, "应答数据体通用错误！"),
    /** 应答数据体业务错误 */
    DATA_BIZ_ERROR(13, "应答数据体业务错误！");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    UdpProtocolParseResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取UDP协议解析结果枚举
     *
     * @param code {@link int}
     * @return {@link UdpProtocolParseResultEnum}
     */
    public static UdpProtocolParseResultEnum getByCode(int code) {
        for (UdpProtocolParseResultEnum protocolParseResult : UdpProtocolParseResultEnum.values()) {
            if (protocolParseResult.code == code) {
                return protocolParseResult;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
