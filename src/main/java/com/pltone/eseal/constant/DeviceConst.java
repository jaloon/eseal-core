package com.pltone.eseal.constant;

/**
 * 设备常量
 *
 * @author chenlong
 * @version 1.0 2018-08-06
 */
public class DeviceConst {
    // 设备类型 0：未指定 | 1：车台 | 2：锁 | 3：出入库读卡器 | 4：手持机
    /** 类型1：车台 */
    public static final byte TYPE_1_TERMINAL = 1;
    /** 类型2：锁 */
    public static final byte TYPE_2_LOCK = 2;
    /** 类型3：出入库读卡器 */
    public static final byte TYPE_3_READER = 3;
    /** 类型4：手持机 */
    public static final byte TYPE_4_HANDSET = 4;

    // 设备ID使用状态 0：未使用 | 1：待使用 | 2：已使用
    /** 类型1：车台 */
    public static final byte DEVICE_ID_STATUS_0_UNUSED = 0;
    public static final byte DEVICE_ID_STATUS_1_TO_USE = 1;
    public static final byte DEVICE_ID_STATUS_2_USING = 2;

    private DeviceConst() {}
}
