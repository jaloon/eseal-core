package com.pltone.eseal.constant.reply;

/**
 * 应急解封密钥同步错误枚举
 *
 * @author chenlong
 * @version 1.0 2019-04-11
 */
public enum UrgentKeySyncErrorEnum {
    /** 用户中心ID为空 */
    CENTER_ID_NULL(1, "用户中心ID为空！"),
    /** 用户中心ID无效 */
    CENTER_ID_INVALID(2, "用户中心ID无效！"),
    /** 应急解封密钥为空 */
    URGENT_KEY_NULL(3, "应急解封密钥为空！"),
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

    UrgentKeySyncErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取应急解封密钥同步错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link UrgentKeySyncErrorEnum} 应急解封密钥同步错误枚举
     */
    public static UrgentKeySyncErrorEnum getByCode(int code) {
        for (UrgentKeySyncErrorEnum rc4ObtainError : values()) {
            if (rc4ObtainError.code == code) {
                return rc4ObtainError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
