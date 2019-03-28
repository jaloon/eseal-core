package com.pltone.eseal.push.sms;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pltone.common.util.JSONUtil;
import com.pltone.common.util.OkHttpUtil;
import lombok.extern.java.Log;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * 短信推送工具类
 *
 * @author chenlong
 * @version 1.0 2019-03-28
 */
@Log
public class SMSPushUtil {
    /** 鉴权url */
    public static final String AUTH_URL = "https://openapi-smsp.getui.com/v1/sps/auth_sign";
    /** 短信群推url */
    public static final String PUSH_URL = "https://openapi-smsp.getui.com/v1/sps/push_sms_list";

    private static final OkHttpClient HTTP_CLIENT = OkHttpUtil.getOkHttpClient();
    private static final TypeReference<SMSResp<AuthRespData>> AUTH_RESP_REF = new TypeReference<SMSResp<AuthRespData>>() {};
    private static final TypeReference<SMSResp<PushRespData>> PUSH_RESP_REF = new TypeReference<SMSResp<PushRespData>>() {};

    private SMSPushUtil() {}

    /**
     * 鉴权请求
     *
     * @param authReq 鉴权请求信息
     * @return 权限令牌，调用其他接口时需提供
     * @throws IOException
     */
    public static String auth(AuthReq authReq) throws IOException {
        SMSResp<AuthRespData> authResp = JSONUtil.parse(req(AUTH_URL, authReq.toString()), AUTH_RESP_REF);
        if (authResp.isSuccessful()) {
            return authResp.getData().getAuthToken();
        }
        throw new IOException("鉴权失败 " + authResp);
    }

    /**
     * 短信群推
     *
     * @param pushReq 短信群推请求
     * @return 短信群推应答数据
     * @throws IOException
     */
    public static PushRespData push(PushReq pushReq) throws IOException {
        SMSResp<PushRespData> pushResp = JSONUtil.parse(req(PUSH_URL, pushReq.toString()), PUSH_RESP_REF);
        if (pushResp.isSuccessful()) {
            return pushResp.getData();
        }
        throw new IOException("短信群推失败 " + pushResp);
    }

    /**
     * 发起HTTP请求
     *
     * @param url     请求URL
     * @param reqBody 请求体
     * @return 应答结果文本
     * @throws IOException
     */
    private static String req(String url, String reqBody) throws IOException {
        log.info("消息推送请求：" + reqBody);
        Request request = new Request.Builder()
                .header("X-Requested-With", "XMLHttpRequest")
                .header("Connection", "close")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Accept", "application/json;charset=UTF-8")
                .url(url)
                .post(RequestBody.create(OkHttpUtil.MEDIA_TYPE_JSON, reqBody))
                .build();

        Response response = HTTP_CLIENT.newCall(request).execute();
        if (response.isSuccessful()) {
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                throw new IOException("HTTP应答体为空");
            }
            String respBody = responseBody.string();
            log.info("消息推送应答：" + respBody);
            return respBody;
        }
        throw new IOException("HTTP请求异常 " + response);
    }
}
