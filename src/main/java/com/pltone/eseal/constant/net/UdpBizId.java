package com.pltone.eseal.constant.net;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.nio.ShortBuffer;
import java.util.Arrays;

/**
 * UDP业务ID
 *
 * @author chenlong
 * @version 1.0 2018-01-22
 */
@Slf4j
public class UdpBizId {
    private UdpBizId() {}

    private static final Field[] FIELDS = UdpBizId.class.getFields();

    /** 链路维护心跳 */
    public static final short LINK_HEARTBEAT_DETECTION = 0x1100;

    /** 公共配置更新（UDP） */
    public static final short TERMINAL_COMMON_CONFIG_UPDATE_REQUEST = 0x1201;
    /** 公共配置更新应答（UDP） */
    public static final short TERMINAL_COMMEN_CONFIG_UPDATE_RESPONSE = 0x1281;
    /** 车辆轨迹信息定时上传间隔参数更新（UDP） */
    public static final short TERMINAL_TRACK_CONFIG_UPDATE_REQUEST = 0x1202;
    /** 车辆轨迹信息定时上传间隔参数更新应答（UDP） */
    public static final short TERMINAL_TRACK_CONFIG_UPDATE_RESPONSE = 0x1282;
    /** 配送卡信息更新下发（UDP） */
    public static final short TRANSPORT_CARD_UPDATE_REQUEST = 0x1203;
    /** 配送卡信息更新下发应答（UDP） */
    public static final short TRANSPORT_CARD_UPDATE_RESPONSE = 0x1283;

    /** 车辆绑定信息下发（UDP） */
    public static final short CAR_BIND_REQUEST = 0x1204;
    /** 车辆绑定信息下发应答（UDP） */
    public static final short CAR_BIND_RESPONSE = 0x1284;

    /** 监听待绑定锁控制下发（UDP） */
    public static final short LOCK_LISTEN_REQUEST = 0x1205;
    /** 监听待绑定锁控制下发应答（UDP） */
    public static final short LOCK_LISTEN_RESPONSE = 0x1285;
    /** 锁待绑定列表清除下发（UDP） */
    public static final short LOCK_CLEAR_REQUEST = 0x1206;
    /** 锁待绑定列表清除下发应答（UDP） */
    public static final short LOCK_CLEAR_RESPONSE = 0x1286;
    /** 锁绑定触发开启关闭控制下发（UDP） */
    public static final short LOCK_BIND_TRIGGER_REQUEST = 0x120A;
    /** 锁绑定触发开启关闭控制下发应答（UDP） */
    public static final short LOCK_BIND_TRIGGER_RESPONSE = 0x128A;
    /** 锁绑定变更下发（UDP） */
    public static final short LOCK_BIND_MODIFY_REQUEST = 0x1207;
    /** 锁绑定变更下发应答（UDP） */
    public static final short LOCK_BIND_MODIFY_RESPONSE = 0x1287;

    /** 车台软件升级下发（UDP） */
    public static final short TERMINAL_SOFTWARE_UPGRADE_REQUEST = 0x1208;
    /** 车台软件升级下发应答（UDP） */
    public static final short TERMINAL_SOFTWARE_UPGRADE_RESPONSE = 0x1288;
    /** 车台功能启用配置下发（UDP） */
    public static final short TERMINAL_FUNCTION_ENABLE_REQUEST = 0x1209;
    /** 车台功能启用配置下发应答（UDP） */
    public static final short TERMINAL_FUNCTION_ENABLE_RESPONSE = 0x1289;

    /** 车辆轨迹实时上报请求（UDP） */
    public static final short REALTIME_MONITOR_REQUEST = 0x1301;
    /** 车辆轨迹实时上报请求应答（UDP） */
    public static final short REALTIME_MONITOR_RESPONSE = 0x1381;
    /** 车辆轨迹实时上报取消（UDP） */
    public static final short REALTIME_MONITOR_CANCEL_REQUEST = 0x1302;
    /** 车辆轨迹实时上报取消应答（UDP） */
    public static final short REALTIME_MONITOR_CANCEL_RESPONSE = 0x1382;
    /** 车辆轨迹列表实时上报请求（UDP） */
    public static final short FOCUS_MONITOR_REQUEST = 0x1303;
    /** 车辆轨迹列表实时上报请求应答（UDP） */
    public static final short FOCUS_MONITOR_RESPONSE = 0x1383;
    /** 车辆轨迹列表实时上报取消（UDP） */
    public static final short FOCUS_MONITOR_CANCEL_REQUEST = 0x1304;
    /** 车辆轨迹列表实时上报取消应答（UDP） */
    public static final short FOCUS_MONITOR_CANCEL_RESPONSE = 0x1384;

    /** UDP车辆轨迹上报 */
    public static final short UDP_TRACK_UPLOAD = 0x1305;

    /** 远程换站请求（UDP） */
    public static final short REMOTE_CHANGE_STATION_REQUEST = 0x1401;
    /** 远程换站请求应答（UDP） */
    public static final short REMOTE_CHANGE_STATION_RESPONSE = 0x1481;
    /** 远程锁报警消除（UDP） */
    public static final short REMOTE_ALARM_ELIMINATE_REQUEST = 0x1402;
    /** 远程锁报警消除应答（UDP） */
    public static final short REMOTE_ALARM_ELIMINATE_RESPONSE = 0x1482;
    /** 远程车辆进出请求（UDP） */
    public static final short REMOTE_CAR_IN_OUT_REQUEST = 0x1403;
    /** 远程车辆进出请求应答（UDP） */
    public static final short REMOTE_CAR_IN_OUT_RESPONSE = 0x1483;
    /** 远程车辆状态强制变更（UDP） */
    public static final short REMOTE_CAR_STATUS_ALTER_REQUEST = 0x1404;
    /** 远程车辆状态强制变更应答（UDP） */
    public static final short REMOTE_CAR_STATUS_ALTER_RESPONSE = 0x1484;
    /** 开锁重置（UDP） */
    public static final short LOCK_OPEN_RESET_REQUEST = 0x1405;
    /** 开锁重置应答（UDP） */
    public static final short LOCK_OPEN_RESET_RESPONSE = 0x1485;

    // /** 道闸开启请求（UDP） */
    // public static final short BARRIER_OPEN_REQUEST = 0x1406;
    // /** 道闸开启应答（UDP） */
    // public static final short BARRIER_OPEN_RESPONSE = 0x1486;

    /** 请求业务ID集合（已排序） */
    public static final short[] REQUEST_BIZ_IDS;
    /** 应答业务ID集合（已排序） */
    public static final short[] RESPONSE_BIZ_IDS;
    /** UDP业务ID集合（已排序） */
    public static final short[] UDP_BIZ_IDS;

    static {
        short[] requestIds = {};
        short[] responseIds = {};
        short[] bizIds = {};
        try {
            final int biz_id_capacity = FIELDS.length - 3;
            final int request_capacity = (biz_id_capacity - 2) / 2;
            ShortBuffer bizIdBuf = ShortBuffer.allocate(biz_id_capacity);
            ShortBuffer requestBuf = ShortBuffer.allocate(request_capacity);
            ShortBuffer responseBuf = ShortBuffer.allocate(request_capacity);
            short bizId;
            for (int i = 0; i < biz_id_capacity; i++) {
                Field field = FIELDS[i];
                bizId = field.getShort(UdpBizId.class);
                bizIdBuf.put(bizId);
                String filedName = field.getName();
                if (filedName.endsWith("_REQUEST")) {
                    requestBuf.put(bizId);
                }
                if (filedName.endsWith("_RESPONSE")) {
                    responseBuf.put(bizId);
                }
            }
            requestIds = requestBuf.array();
            responseIds = responseBuf.array();
            bizIds = bizIdBuf.array();
            Arrays.sort(requestIds);
            Arrays.sort(responseIds);
            Arrays.sort(bizIds);
        } catch (Exception e) {
            requestIds = new short[0];
            responseIds = new short[0];
            bizIds = new short[0];
            log.error("构建UDP业务ID集合异常：{}", e.toString());
        } finally {
            REQUEST_BIZ_IDS = requestIds;
            RESPONSE_BIZ_IDS = responseIds;
            UDP_BIZ_IDS = bizIds;
        }
    }

}
