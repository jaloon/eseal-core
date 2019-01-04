package com.pltone.eseal.constant.net;

/**
 * UDP应答业务错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-09-19
 */
public enum UdpReplyWorkErrorEnum {
    /** 操作成功 */
    OPERATE_SUCCESS(0, "操作成功"),
    /** 操作失败 */
    OPERATE_FAIL_101(101, "操作失败"),
    /** 操作失败，ID错误 */
    OPERATE_FAIL_102_ID_ERROR(102, "操作失败，ID错误"),
    /** 操作失败，设备类型错误 */
    OPERATE_FAIL_103_DEVICE_TYPE_ERROR(103, "操作失败，设备类型错误"),
    /** 操作失败，操作类型不支持 */
    OPERATE_FAIL_104_OPERATION_TYPE_NOT_SUPPORTED(104, "操作失败，操作类型不支持"),
    /** 操作失败，操作不支持 */
    OPERATE_FAIL_105_OPERATION_NOT_SUPPORTED(105, "操作失败，操作不支持"),
    /** 操作失败，数据已存在 */
    OPERATE_FAIL_106_DATA_ALREADY_EXISTS(106, "操作失败，数据已存在"),
    /** 操作失败，数据保存失败 */
    OPERATE_FAIL_107_DATA_STORAGE_FAILED(107, "操作失败，数据保存失败"),
    /** 操作失败，数据不存在 */
    OPERATE_FAIL_108_DATA_NOT_AVAILABLE(108, "操作失败，数据不存在"),
    /** 操作失败，业务处理失败 */
    OPERATE_FAIL_109_FAILURE_OF_BUSINESS_PROCESS(109, "操作失败，业务处理失败"),
    /** 操作失败，设备已断电 */
    OPERATE_FAIL_110_DEVICE_HAS_BEEN_POWERED_OFF(110, "操作失败，设备已断电"),
    /** 操作失败，设备状态不允许 */
    OPERATE_FAIL_150_DEVICE_STATUS_NOT_ALLOWED(150, "操作失败，设备状态不允许"),
    /** 操作失败，设备存在报警 */
    OPERATE_FAIL_151_DEVICE_ALARM(151, "操作失败，设备存在报警"),
    /** 操作失败，存在未关好的锁 */
    OPERATE_FAIL_152_LOCK_NOT_CLOSED(152, "操作失败，存在未关好的锁"),
    /** 操作失败，认证类型不支持 */
    OPERATE_FAIL_153_AUTHENTICATION_TYPE_NOT_SUPPORTED(153, "操作失败，认证类型不支持"),
    /** 操作失败，认证编号错误 */
    OPERATE_FAIL_154_AUTHENTICATION_ID_ERROR(154, "操作失败，认证编号错误"),
    /** 操作失败，站点错误 */
    OPERATE_FAIL_155_STATION_ERROR(155, "操作失败，站点错误"),
    /** 操作失败，车辆不在指定区域内 */
    OPERATE_FAIL_156_VEHICLE_IS_NOT_IN_DESIGNATED_AREA(156, "操作失败，车辆不在指定区域内"),
    /** 操作失败，操作重复 */
    OPERATE_FAIL_157_DUPLICATION_OF_OPERATION(157, "操作失败，操作重复"),
    /** 操作失败，其它原因 */
    OPERATE_FAIL_255_OTHER_REASONS(255, "操作失败，其它原因");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    UdpReplyWorkErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取UDP应答公共错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link UdpReplyWorkErrorEnum} 错误枚举
     */
    public static UdpReplyWorkErrorEnum getByCode(int code) {
        for (UdpReplyWorkErrorEnum workError : values()) {
            if (workError.code == code) {
                return workError;
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
        for (UdpReplyWorkErrorEnum commonError : values()) {
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
