package com.pltone.eseal.constant.reply;

/**
 * 获取用户中心RC4信息错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-03-21
 */
public enum CenterRc4ObtainErrorEnum {
    /** 用户中心ID为空 */
    CENTER_ID_NULL(1, "用户中心ID为空！"),
    /** 用户中心ID无效 */
    CENTER_ID_INVALID(2, "用户中心ID无效！"),
    /** 版本号为空 */
    VERSION_NULL(3, "版本号为空！"),
    /** 版本号无效 */
    VERSION_INVALID(4, "版本号无效！");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    CenterRc4ObtainErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取中心Rc4错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link CenterRc4ObtainErrorEnum}
     */
    public static CenterRc4ObtainErrorEnum getByCode(int code) {
        for (CenterRc4ObtainErrorEnum rc4ObtainError : values()) {
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