package com.pltone.eseal.constant.reply;

/**
 * 获取用户中心IP、端口、RC4等信息错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-03-21
 */
public enum CenterInfoObtainErrorEnum {
    /** 设备ID为空 */
    DEVICE_ID_NULL(1, "设备ID为空！"),
    /** 设备ID无效 */
    DEVICE_ID_INVALID(2, "设备ID无效！"),
    /** 版本号为空 */
    VERSION_NULL(3, "版本号为空！"),
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

    CenterInfoObtainErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取中心信息错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link CenterInfoObtainErrorEnum} 中心信息错误枚举
     */
    public static CenterInfoObtainErrorEnum getByCode(int code) {
        for (CenterInfoObtainErrorEnum centerInfoObtainError : values()) {
            if (centerInfoObtainError.code == code) {
                return centerInfoObtainError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
