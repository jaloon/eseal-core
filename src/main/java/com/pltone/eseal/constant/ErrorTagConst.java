package com.pltone.eseal.constant;

/**
 * 错误标志常量
 *
 * @author chenlong
 * @version 1.0 2018-03-15
 */
public class ErrorTagConst extends com.pltone.common.constant.ErrorTagConst {

    /** 根据设备ID获取用户中心IP、端口、RC4等信息错误标志位 */
    public static final byte CENTER_INFO_ERROR_TAG = 3;
    /** 根据用户中心ID获取用户中心RC4秘钥信息错误标志位 */
    public static final byte CENTER_CR4_ERROR_TAG = 4;
    /** 根据用户中心ID获取道闸接口信息错误标志位 */
    public static final byte BARRIER_INFO_ERROR_TAG = 5;
    /** 根据APP配置（IP、端口号）信息错误标志位 */
    public static final byte APP_CONFIG_ERROR_TAG = 6;
    /** 根据用户中心ID获取用户中心Web服务地址错误标志位 */
    public static final byte WEB_ADDRESS_ERROR_TAG = 7;
    /** 设备ID申请错误标志位 */
    public static final byte DEVICE_ID_APPLY_ERROR_TAG = 8;

    /** 车台GPS配置错误标志位 */
    public static final byte TERM_GPS_CONFIG_ERROR_TAG = 31;
    /** 车台软件升级错误标志位 */
    public static final byte TERM_SOFT_UPGRADE_ERROR_TAG = 32;
    /** 设备绑定错误标志位 */
    public static final byte DEV_BIND_ERROR_TAG = 33;

    /** 远程控制错误标志位 */
    public static final byte REMOTE_CONTROL_ERROR_TAG = 40;
    /** 远程换站错误标志位 */
    public static final byte CHANGE_STATION_ERROR_TAG = 41;
    /** 消除报警错误标志位 */
    public static final byte ELIMINATE_ALARM_ERROR_TAG = 42;
    /** 开锁重置错误标志位 */
    public static final byte LOCK_OPEN_RESET_ERROR_TAG = 43;
    /** 轨迹查询错误标志位 */
    public static final byte FIND_TRACK_ERROR_TAG = 46;
    /** 授权记录上报错误标志位 */
    public static final byte AUTH_REPORT_ERROR_TAG = 47;

    /** 道闸接口错误标志位 */
    public static final byte BARRIER_ERROR_TAG = 50;

    /** 邮件通知错误标志位 */
    public static final byte EMAIL_ERROR_TAG = 60;


    private ErrorTagConst() {}
}
