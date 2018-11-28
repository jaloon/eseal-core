package com.pltone.eseal.constant.reply;

/**
 * 远程开锁重置错误枚举
 * @author chenlong
 * @version 1.0 2018-03-29
 *
 */
public enum RemoteLockResetErrorEnum {
	/** 车牌号为空 */
	CARNUMBER_NULL(1, "车牌号为空！"),
	/** 车辆不存在 */
	VEHICLE_INVALID(2, "车辆不存在！"),
	/** 车辆未绑定车台 */
	VEHICLE_UNBINDED(3, "车辆未绑定车台！"),
	/** 锁设备ID为空 */
	LOCK_DEV_ID_NULL(4, "锁设备ID为空！"),
	/** 锁设备ID无效 */
	LOCK_DEV_ID_INVALID(5, "锁设备ID无效 ！"),
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

	RemoteLockResetErrorEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 根据code获取远程开锁重置错误枚举
	 * 
	 * @param code
	 *            {@link int}
	 * @return
	 */
	public static RemoteLockResetErrorEnum getByCode(int code) {
		for (RemoteLockResetErrorEnum lockResetError : values()) {
			if (lockResetError.code == code) {
				return lockResetError;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return msg;
	}
}
