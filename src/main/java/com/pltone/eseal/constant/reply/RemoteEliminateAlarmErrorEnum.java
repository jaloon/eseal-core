package com.pltone.eseal.constant.reply;

/**
 * 远程消除报警错误枚举
 * 
 * @author chenlong
 * @version 1.0 2018-03-30
 *
 */
public enum RemoteEliminateAlarmErrorEnum {
	/** 车牌号为空 */
	CARNUMBER_NULL(1, "车牌号为空！"),
	/** 车辆不存在 */
	VEHICLE_INVALID(1, "车辆不存在！"),
	/** 报警ID为空 */
	ALARM_ID_NULL(2, "报警ID为空！"),
    /** 消除报警的设备不唯一 */
    ALARM_DEV_NOT_UNIQUE(3, "消除报警的设备不唯一！"),
    /** 报警ID无效 */
	ALARM_ID_INVALID(4, "报警ID无效！"),
    /** 报警记录不存在 */
    ALARM_NOT_EXIST(5, "报警记录不存在!"),
	/** 请求发起时间为空 */
	REQUEST_TIME_NULL(6, "请求发起时间为空！"),
	/** 时间格式不正确 */
	TIME_FORMAT_INVALID(7, "时间格式不正确！");

	private int code;
	private String msg;

	public int code() {
		return code;
	}

	public String msg() {
		return msg;
	}

	RemoteEliminateAlarmErrorEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 根据code获取远程消除报警错误枚举
	 * 
	 * @param code
	 *            {@link int}
	 * @return
	 */
	public static RemoteEliminateAlarmErrorEnum getByCode(int code) {
		for (RemoteEliminateAlarmErrorEnum eliminateAlarmError : values()) {
			if (eliminateAlarmError.code == code) {
				return eliminateAlarmError;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return msg;
	}
}
