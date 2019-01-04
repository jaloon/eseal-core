package com.pltone.eseal.util;

import com.pltone.common.bean.ResponseMsg;
import com.pltone.eseal.constant.ErrorTagConst;
import com.pltone.eseal.constant.net.UdpProtocolParseResultEnum;
import com.pltone.eseal.constant.reply.AppInfoObtainErrorEnum;
import com.pltone.eseal.constant.reply.AuthReportErrorEnum;
import com.pltone.eseal.constant.reply.BarrierErrorEnum;
import com.pltone.eseal.constant.reply.BarrierInfoObtainErrorEnum;
import com.pltone.eseal.constant.reply.CenterInfoObtainErrorEnum;
import com.pltone.eseal.constant.reply.CenterRc4ObtainErrorEnum;
import com.pltone.eseal.constant.reply.DevBindErrorEnum;
import com.pltone.eseal.constant.reply.DeviceIdApplyErrorEnum;
import com.pltone.eseal.constant.reply.EmailErrorEnum;
import com.pltone.eseal.constant.reply.FindTracksByCarNumberErrorEnum;
import com.pltone.eseal.constant.reply.RemoteChangeErrorEnum;
import com.pltone.eseal.constant.reply.RemoteControlErrorEnum;
import com.pltone.eseal.constant.reply.RemoteEliminateAlarmErrorEnum;
import com.pltone.eseal.constant.reply.RemoteLockResetErrorEnum;
import com.pltone.eseal.constant.reply.TermGpsConfigErrorEnum;
import com.pltone.eseal.constant.reply.TermSoftUpgradeErrorEnum;
import com.pltone.eseal.constant.reply.WebAddrObtainErrorEnum;

/**
 * Response信息工具类
 *
 * @author chenlong
 * @version 1.0 2018-05-03
 */
public class ResponseMsgUtil extends com.pltone.common.util.ResponseMsgUtil {
    /**
     * 错误回复（APP信息错误）
     *
     * @param appInfoError {@link AppInfoObtainErrorEnum} APP信息错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(AppInfoObtainErrorEnum appInfoError) {
        return error(ErrorTagConst.APP_CONFIG_ERROR_TAG, appInfoError.code(), appInfoError.msg());
    }

    /**
     * 错误回复（道闸信息错误）
     *
     * @param barrierError {@link BarrierInfoObtainErrorEnum} 道闸信息错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(BarrierInfoObtainErrorEnum barrierError) {
        return error(ErrorTagConst.BARRIER_INFO_ERROR_TAG, barrierError.code(), barrierError.msg());
    }

    /**
     * 错误回复（中心信息错误）
     *
     * @param centerError {@link BarrierInfoObtainErrorEnum} 中心信息错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(CenterInfoObtainErrorEnum centerError) {
        return error(ErrorTagConst.CENTER_INFO_ERROR_TAG, centerError.code(), centerError.msg());
    }

    /**
     * 错误回复（RC4信息错误）
     *
     * @param rc4Error {@link CenterRc4ObtainErrorEnum} RC4信息错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(CenterRc4ObtainErrorEnum rc4Error) {
        return error(ErrorTagConst.CENTER_CR4_ERROR_TAG, rc4Error.code(), rc4Error.msg());
    }

    /**
     * 错误回复（设备ID申请错误）
     *
     * @param deviceIdApplyError {@link DeviceIdApplyErrorEnum} 设备ID申请错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(DeviceIdApplyErrorEnum deviceIdApplyError) {
        return error(ErrorTagConst.DEVICE_ID_APPLY_ERROR_TAG, deviceIdApplyError.code(), deviceIdApplyError.msg());
    }

    /**
     * 错误回复（邮件通知错误）
     *
     * @param emailError {@link EmailErrorEnum} 邮件通知错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(EmailErrorEnum emailError) {
        return error(ErrorTagConst.EMAIL_ERROR_TAG, emailError.code(), emailError.msg());
    }

    /**
     * 错误回复（Web服务地址错误）
     *
     * @param webAddrError {@link WebAddrObtainErrorEnum} Web服务地址错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(WebAddrObtainErrorEnum webAddrError) {
        return error(ErrorTagConst.WEB_ADDRESS_ERROR_TAG, webAddrError.code(), webAddrError.msg());
    }

    /**
     * 错误回复（授权记录上报错误）
     *
     * @param authReportError {@link AuthReportErrorEnum} 道闸接口错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(AuthReportErrorEnum authReportError) {
        return error(ErrorTagConst.AUTH_REPORT_ERROR_TAG, authReportError.code(), authReportError.msg());
    }

    /**
     * 错误回复（道闸接口错误）
     *
     * @param barrierError {@link BarrierErrorEnum} 道闸接口错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(BarrierErrorEnum barrierError) {
        return error(ErrorTagConst.BARRIER_ERROR_TAG, barrierError.code(), barrierError.msg());
    }

    /**
     * 错误回复（设备绑定错误）
     *
     * @param devBindError {@link DevBindErrorEnum} 设备绑定错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(DevBindErrorEnum devBindError) {
        return error(ErrorTagConst.DEV_BIND_ERROR_TAG, devBindError.code(), devBindError.msg());
    }

    /**
     * 错误回复（根据车牌号获取车辆轨迹错误）
     *
     * @param findTracksError {@link FindTracksByCarNumberErrorEnum} 根据车牌号获取车辆轨迹错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(FindTracksByCarNumberErrorEnum findTracksError) {
        return error(ErrorTagConst.FIND_TRACK_ERROR_TAG, findTracksError.code(), findTracksError.msg());
    }

    /**
     * 错误回复（远程换站错误）
     *
     * @param remoteChangeError {@link RemoteChangeErrorEnum} 远程换站错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(RemoteChangeErrorEnum remoteChangeError) {
        return error(ErrorTagConst.CHANGE_STATION_ERROR_TAG, remoteChangeError.code(), remoteChangeError.msg());
    }

    /**
     * 错误回复（远程操作错误）
     *
     * @param remoteControlError {@link RemoteControlErrorEnum} 远程操作错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(RemoteControlErrorEnum remoteControlError) {
        return error(ErrorTagConst.REMOTE_CONTROL_ERROR_TAG, remoteControlError.code(), remoteControlError.msg());
    }

    /**
     * 错误回复（远程消除报警错误）
     *
     * @param eliminateAlarmError {@link RemoteEliminateAlarmErrorEnum} 远程消除报警错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(RemoteEliminateAlarmErrorEnum eliminateAlarmError) {
        return error(ErrorTagConst.ELIMINATE_ALARM_ERROR_TAG, eliminateAlarmError.code(), eliminateAlarmError.msg());
    }

    /**
     * 错误回复（远程开锁重置错误）
     *
     * @param lockResetError {@link RemoteLockResetErrorEnum} 远程开锁重置错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(RemoteLockResetErrorEnum lockResetError) {
        return error(ErrorTagConst.LOCK_OPEN_RESET_ERROR_TAG, lockResetError.code(), lockResetError.msg());
    }

    /**
     * 错误回复（车台配置更新错误）
     *
     * @param terminalConfigError {@link TermGpsConfigErrorEnum} 车台配置更新错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(TermGpsConfigErrorEnum terminalConfigError) {
        return error(ErrorTagConst.TERM_GPS_CONFIG_ERROR_TAG, terminalConfigError.code(), terminalConfigError.msg());
    }

    /**
     * 错误回复（车台软件升级错误）
     *
     * @param terminalUpgradeError {@link TermSoftUpgradeErrorEnum} 车台软件升级错误
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(TermSoftUpgradeErrorEnum terminalUpgradeError) {
        return error(ErrorTagConst.TERM_SOFT_UPGRADE_ERROR_TAG, terminalUpgradeError.code(), terminalUpgradeError.msg());
    }

    /**
     * 错误回复（UDP协议解析结果）
     *
     * @param protocolParseResult {@link UdpProtocolParseResultEnum} UDP协议解析结果
     * @return {@link ResponseMsg}
     */
    public static ResponseMsg error(UdpProtocolParseResultEnum protocolParseResult) {
        return error(ErrorTagConst.UDP_PARSE_ERROR_TAG, protocolParseResult.code(), protocolParseResult.msg());
    }

}
