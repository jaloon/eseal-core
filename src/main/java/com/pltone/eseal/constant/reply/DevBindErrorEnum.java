package com.pltone.eseal.constant.reply;

/**
 * 设备绑定错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-03-16
 */
public enum DevBindErrorEnum {
    /** 车牌号为空 */
    CARNUMBER_NULL(1, "车牌号为空！"),
    /** 车辆不存在 */
    VEHICLE_INVALID(2, "车辆不存在！"),
    /** 车辆未绑定车台 */
    VEHICLE_UNBINDED(3, "车辆未绑定车台！"),
    /** 设备ID为空 */
    DEVICE_ID_NULL(4, "设备ID为空！"),
    /** 设备不存在 */
    DEVICE_INVALID(5, "设备不存在！"),
    /** 设备类型不符 */
    DEVICE_TYPE_INCONSISTENT(6, "设备类型不符！"),
    /** 设备已绑定 */
    DEVICE_BINDED(7, "设备已绑定！"),
    /** 仓数为空 */
    STORE_NUM_NULL(8, "仓数为空！"),
    /** 锁绑定变更类型为空 */
    LOCK_BIND_TYPE_NULL(9, "锁绑定变更类型为空！"),
    /** 锁绑定变更类型无效 */
    LOCK_BIND_TYPE_INVALID(10, "锁绑定变更类型无效！"),
    /** 待绑定锁列表为空 */
    BINDING_LOCKS_NULL(11, "待绑定锁列表为空！"),
    /** 待绑定锁信息不完整 */
    BINDING_LOCK_INCOMPLETE(12, "待绑定锁信息不完整！"),
    /** 锁绑定监听状态为空 */
    LOCK_LISTEN_STATE_NULL(13, "锁绑定监听状态为空！"),
    /** 锁绑定监听状态值无效 */
    LOCK_LISTEN_STATE_INVALID(14, "锁绑定监听状态值无效！"),
    /** 锁绑定触发状态为空 */
    LOCK_TRIGGER_STATE_NULL(15, "锁绑定触发状态为空！"),
    /** 锁绑定触发状态值无效 */
    LOCK_TRIGGER_STATE_INVALID(16, "锁绑定触发状态值无效！"),
    /** 请求发起时间为空 */
    REQUEST_TIME_NULL(17, "请求发起时间为空！"),
    /** 时间格式不正确 */
    TIME_FORMAT_INVALID(18, "时间格式不正确！"),
    /** 与车载终端绑定的车辆不是要解绑的车辆 */
    BINDED_CAR_INCONSISTENT(19, "与车载终端绑定的车辆不是要解绑的车辆！");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    DevBindErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取设备绑定错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link DevBindErrorEnum} 设备绑定错误枚举
     */
    public static DevBindErrorEnum getByCode(int code) {
        for (DevBindErrorEnum devBindError : values()) {
            if (devBindError.code == code) {
                return devBindError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
