package com.pltone.eseal.constant.reply;

/**
 * 远程换站错误枚举
 * 
 * @author chenlong
 * @version 1.0 2018-03-23
 *
 */
public enum RemoteChangeErrorEnum {
	/** 原配送ID为空 */
	TRANSPORT_ID_NULL(1, "原配送ID为空！"),
	/** 新加油站ID为空 */
	CHANGED_STATION_ID_NULL(2, "新加油站ID为空！"),
	/** 相关车辆不存在 */
	VEHICLE_INVALID(3, "相关车辆不存在！"),
	/** 车辆未绑定车台 */
	VEHICLE_UNBINDED(4, "车辆未绑定车台！"),
	/** 配送ID不存在 */
	TRANSPORT_ID_INVALID(5, "配送ID不存在！"),
	/** 新加油站不存在 */
	CHANGED_STATION_INVALID(6, "新加油站不存在！"),
	/** 当前配送状态不可换站 */
	TRANSPORT_STATUS_INCONSISTENT(7, "当前配送状态不可换站！"),
	/** 请求发起时间为空 */
	REQUEST_TIME_NULL(8, "请求发起时间为空！"),
	/** 时间格式不正确 */
	TIME_FORMAT_INVALID(9, "时间格式不正确！");
	
	private int code;
	private String msg;

	public int code() {
		return code;
	}

	public String msg() {
		return msg;
	}

	RemoteChangeErrorEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 根据code获取远程换站错误枚举
	 * 
	 * @param code
	 *            {@link int}
	 * @return
	 */
	public static RemoteChangeErrorEnum getByCode(int code) {
		for (RemoteChangeErrorEnum remoteChangeError : values()) {
			if (remoteChangeError.code == code) {
				return remoteChangeError;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return msg;
	}
}
