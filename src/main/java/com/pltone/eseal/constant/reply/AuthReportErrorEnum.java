package com.pltone.eseal.constant.reply;

/**
 * 授权记录上报错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-07-12
 */
public enum AuthReportErrorEnum {
    /** 车牌号为空 */
    CAR_NUMBER_NULL(1, "车牌号为空！"),
    /** 车辆不存在 */
    VEHICLE_INVALID(2, "车辆不存在！"),
    /** 授权时间为空 */
    AUTH_TIME_NULL(3, "授权时间为空！"),
    /** 时间格式不正确 */
    TIME_FORMAT_INVALID(4, "时间格式不正确！"),
    /** 授权码为空 */
    AUTH_CODE_NULL(5, "授权码为空！"),
    /** 授权密码为空 */
    AUTH_PASSWORD_NULL(6, "授权密码为空！");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    AuthReportErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取授权记录上报错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link AuthReportErrorEnum} 授权记录上报错误枚举
     */
    public static AuthReportErrorEnum getByCode(int code) {
        for (AuthReportErrorEnum authReportError : values()) {
            if (authReportError.code == code) {
                return authReportError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
