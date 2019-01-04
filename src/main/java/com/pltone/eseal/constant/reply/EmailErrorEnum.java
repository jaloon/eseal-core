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
    EMAIL_CONTENT_NULL(2, "邮件内容为空！");

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
