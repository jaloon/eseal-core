package com.pltone.eseal.constant.reply;

/**
 * 车台GPS配置错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-04-09
 */
public enum TermGpsConfigErrorEnum {
    /** 车牌号为空 */
    CARNUMBER_NULL(1, "车牌号为空！"),
    /** 车辆不存在 */
    VEHICLE_INVALID(2, "车辆不存在！"),
    /** 车辆未绑定车台 */
    VEHICLE_UNBINDED(3, "车辆未绑定车台！"),
    /** 配置范围越界 */
    BEYOND_CONFIG_SCOPE(4, "配置范围越界！"),
    /** 配置无更新 */
    CONFIG_WITHOUT_UPDATE(5, "配置无更新！"),
    /** 配置参数为空 */
    CONFIG_PARAM_NULL(6, "配置参数为空"),
    /** 配置参数无效 */
    CONFIG_PARAM_INVALID(9, "配置参数无效"),
    /** 请求发起时间为空 */
    REQUEST_TIME_NULL(7, "请求发起时间为空！"),
    /** 时间格式不正确 */
    TIME_FORMAT_INVALID(8, "时间格式不正确！");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    TermGpsConfigErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取车台GPS配置错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link TermGpsConfigErrorEnum} 车台GPS配置错误枚举
     */
    public static TermGpsConfigErrorEnum getByCode(int code) {
        for (TermGpsConfigErrorEnum terminalConfigUpdateError : values()) {
            if (terminalConfigUpdateError.code == code) {
                return terminalConfigUpdateError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
