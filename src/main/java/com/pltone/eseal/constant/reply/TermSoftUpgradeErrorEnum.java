package com.pltone.eseal.constant.reply;

/**
 * 车台软件升级错误枚举
 *
 * @author chenlong
 * @version 1.0 2018-04-09
 */
public enum TermSoftUpgradeErrorEnum {
    /** 车台设备ID为空 */
    TERMINAL_IDS_NULL(1, "车台设备ID为空！"),
    /** ftp路径为空 */
    FTP_PATH_NULL(2, "ftp路径为空！"),
    /** 升级类型为空 */
    UPGRADE_TYPE_NULL(3, "升级类型为空！"),
    /** 升级类型无效 */
    UPGRADE_TYPE_INVALID(4, "升级类型无效！"),
    /** 请求发起时间为空 */
    REQUEST_TIME_NULL(5, "请求发起时间为空！"),
    /** 时间格式不正确 */
    TIME_FORMAT_INVALID(6, "时间格式不正确！"),
    /** 车辆升级记录ID为空 */
    UPGRADE_INFO_ID_NULL(7, "车辆升级记录ID为空!"),
    /** 车台已升级，不可取消 */
    HAS_UPGRADED(8, "车台已升级，不可取消！"),
    /** 版本号格式不正确 */
    VERSION_INVALID(9, "版本号格式不正确！"),
    /** 申请的升级文件信息过期 */
    APPLY_EXPIRED(10, "申请的升级文件信息过期");

    private int code;
    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    TermSoftUpgradeErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取车台软件升级错误枚举
     *
     * @param code {@link int} 错误码
     * @return {@link TermSoftUpgradeErrorEnum} 车台软件升级错误枚举
     */
    public static TermSoftUpgradeErrorEnum getByCode(int code) {
        for (TermSoftUpgradeErrorEnum softwareUpgradeError : values()) {
            if (softwareUpgradeError.code == code) {
                return softwareUpgradeError;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return msg;
    }
}
