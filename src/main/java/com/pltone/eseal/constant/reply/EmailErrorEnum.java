package com.pltone.eseal.constant.reply;

/**
 * 邮件通知错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-09-03
 */
public enum EmailErrorEnum {
    /** 收件人为空 */
    RECEIVER_NULL(1, "收件人为空！"),
    /** 邮件内容为空 */
    EMAIL_CONTENT_NULL(2, "邮件内容为空！"),
    /** 用户中心不存在 */
    CENTER_NO_EXIST(3, "用户中心不存在！"),
    /** 设备不存在 */
    DEVICE_NO_EXIST(4, "设备不存在！"),
    /** 设备类型无效 */
    DEVICE_TYPE_INVALID(5, "设备类型无效！"),
    /** API版本号无效 */
    API_VERSION_INVALID(100, "API版本号无效！");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    EmailErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取邮件通知错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link EmailErrorEnum} 邮件通知错误枚举
     */
    public static EmailErrorEnum getByCode(int code) {
        for (EmailErrorEnum emailError : values()) {
            if (emailError.code == code) {
                return emailError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
