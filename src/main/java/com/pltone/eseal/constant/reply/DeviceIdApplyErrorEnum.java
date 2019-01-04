package com.pltone.eseal.constant.reply;

/**
 * 设备ID申请错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-08-07
 */
public enum DeviceIdApplyErrorEnum {
    /** 设备ID为空 */
    DEVICE_ID_NULL(1, "设备ID为空！"),
    /** 设备ID已被使用 */
    DEVICE_ID_USING(2, "设备ID已被使用！"),
    /** 设备类型为空 */
    DEVICE_TYPE_NULL(3, "设备类型为空！"),
    /** 设备类型无效 */
    DEVICE_TYPE_INVALID(4, "设备类型无效！");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    DeviceIdApplyErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取设备ID申请错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link DeviceIdApplyErrorEnum} 设备ID申请错误枚举
     */
    public static DeviceIdApplyErrorEnum getByCode(int code) {
        for (DeviceIdApplyErrorEnum deviceIdApplyError : values()) {
            if (deviceIdApplyError.code == code) {
                return deviceIdApplyError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
