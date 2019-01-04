package com.pltone.eseal.constant.net;

/**
 * UDP应答公共错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-07-26
 */
public enum UdpReplyCommonErrorEnum {
    /** 协议版本不合法 */
    PROTOCOL_VERSION_INVALID(1, "协议版本不合法"),
    /** 消息头太短 */
    MSG_HEAD_TOO_SHORT(2, "消息头太短"),
    /** 数据库操作错误 */
    DB_OPERATE_ERROR(3, "数据库操作错误"),
    /** 源终端地址（设备ID）不合法（值错误或者不属于本中心监管设备或者设备不可用） */
    SRC_TERM_ADDR_INVALID(4, "数据库操作错误"),
    /** 目的终端地址（设备ID）不合法（值错误或者不属于本中心监管设备或者设备不可用） */
    DEST_TERM_ADDR_INVALID(5, "目的终端地址（设备ID）不合法（值错误或者不属于本中心监管设备或者设备不可用）"),
    /** 消息标识不合法 */
    MSG_TAG_INVALID(6, "消息标识不合法"),
    /** 数据体长度超过最大长度 */
    DATA_LEN_OVERFLOW(7, "数据体长度超过最大长度"),
    /** 数据体长度不合法 */
    DATA_LEN_INEQUALITY(8, "数据体长度不合法"),
    /** 网络错误 */
    NETWORK_ERROR(9, "网络错误"),
    /** 数据体版本号不合法 */
    DATA_VERSION_INVALID(10, "数据体版本号不合法"),
    /** 序列号重复或者为0 */
    SERIAL_NUMBER_INVALID(11, "序列号重复或者为0"),
    /** 设备已登陆，发现新的端口号登陆中心 */
    DUPLICATE_LOGIN(12, "设备已登陆，发现新的端口号登陆中心"),
    /** 设备未登陆 */
    UN_LOGIN(13, "设备未登陆"),
    /** 设备登陆失败 */
    LOGIN_FAIL(14, "设备登陆失败"),
    /** 设备离线 */
    DEVICE_OFFLINE(15, "设备离线"),
    /** Http通讯错误 */
    HTTP_CONNECTION_ERROR(16, "Http通讯错误"),
    /** 车辆信息错误：中心不存在该车辆信息,或者车辆未绑定车台 */
    VEHICLE_INVALID(17, "车辆信息错误：中心不存在该车辆信息,或者车辆未绑定车台"),
    /** 公共参数数量不对 */
    COMMON_PARAM_NUM_ERROR(18, "公共参数数量不对"),
    /** 车辆信息未完成绑定 */
    VEHICLE_BIND_FAIL(19, "车辆信息未完成绑定"),
    /** 锁信息未完成绑定 */
    LOCK_BIND_FAIL(20, "锁信息未完成绑定"),
    /** 车载终端已与其他车辆绑定 */
    TERMINAL_BINDED(21, "车载终端已与其他车辆绑定"),
    /** 锁已经绑定 */
    LOCK_BINDED(22, "锁已经绑定"),
    /** 轨迹时间小于2017年或者其它时间错误 */
    TRACK_TIME_ERROR(23, "轨迹时间小于2017年或者其它时间错误"),
    /** 记录ID不合法 */
    RECORD_ID_INVALID(24, "记录ID不合法"),
    /** 设备ID不合法 */
    DEVICE_ID_INVALID(25, "设备ID不合法"),
    /** 车台应答超时 */
    REPLY_TIME_OUT(26, "车台应答超时"),
    /** 设备类型不合法 */
    DEVICE_TYPE_INVALID(27, "设备类型不合法");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    UdpReplyCommonErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取UDP应答公共错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link UdpReplyCommonErrorEnum} 错误枚举
     */
    public static UdpReplyCommonErrorEnum getByCode(int code) {
        for (UdpReplyCommonErrorEnum commonError : values()) {
            if (commonError.code == code) {
                return commonError;
            }
        }
        return null;
    }

    /**
     * 根据UDP应答公共错误码获取公共错误信息
     *
     * @param code {@link int} 错误码
     * @return {@link String} 错误信息
     */
    public static String codeToMsg(int code) {
        for (UdpReplyCommonErrorEnum commonError : values()) {
            if (commonError.code == code) {
                return commonError.msg;
            }
        }
        return new StringBuffer().append("未知错误[").append(code).append(']').toString();
    }

    @Override
    public String toString() {
        return msg;
    }

}
