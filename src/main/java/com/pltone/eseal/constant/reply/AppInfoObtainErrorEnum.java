package com.pltone.eseal.constant.reply;

/**
 * 获取APP配置信息错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-07-17
 */
public enum AppInfoObtainErrorEnum {
    /** 手机UUID为空 */
    UUID_NULL(1, "手机UUID为空！"),
    /** 手机UUID未配置 */
    UUID_INVALID(2, "手机UUID未配置！"),
    /** appid为空 */
    APPID_NULL(3, "appid为空！"),
    /** 系统类型为空 */
    SYSTEM_NULL(4, "系统类型为空！"),
    /** 当前版本号为空 */
    VERSION_NULL(5, "当前版本号为空！"),
    /** 版本号格式不正确 */
    VERSION_INVALID(6, "版本号格式不正确！"),
    /** 版本信息json文件不存在 */
    JSON_FILE_NO_EXIST(7, "版本信息json文件不存在！"),
    /** json文件未包含指定系统的升级信息 */
    SYSTEM_NOT_IN_JSON(8, "json文件未包含指定系统的升级信息！"),
    /** 手机型号为空 */
    MODEL_NULL(9, "手机型号为空！"),
    /** 设备所属用户中心未配置 */
    CENTER_NULL(10, "设备所属用户中心未配置！"),
    /** 设备所属用户中心不唯一 */
    CENTER_NOT_UNIQUE(11, "设备所属用户中心不唯一！"),
    /** 用户中心ID为空 */
    CENTER_ID_NULL(12, "用户中心ID为空！"),
    /** 给定的center_id不属于设备所属的用户中心 */
    CENTER_ID_INVALID(13, "给定的center_id不属于设备所属的用户中心！"),
    /** APP升级版本未配置 */
    UP_VER_NULL(14, "APP升级版本未配置！");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    AppInfoObtainErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取APP信息错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link AppInfoObtainErrorEnum} APP信息错误枚举
     */
    public static AppInfoObtainErrorEnum getByCode(int code) {
        for (AppInfoObtainErrorEnum appInfoObtainError : values()) {
            if (appInfoObtainError.code == code) {
                return appInfoObtainError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
