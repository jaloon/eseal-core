package com.pltone.eseal.constant.reply;

/**
 * 获取用户中心道闸接口信息错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-03-21
 */
public enum BarrierInfoObtainErrorEnum {
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

    BarrierInfoObtainErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取道闸信息错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link BarrierInfoObtainErrorEnum} 道闸信息错误枚举
     */
    public static BarrierInfoObtainErrorEnum getByCode(int code) {
        for (BarrierInfoObtainErrorEnum barrierInfoObtainError : values()) {
            if (barrierInfoObtainError.code == code) {
                return barrierInfoObtainError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
