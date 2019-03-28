package com.pltone.eseal.push.sms;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;

/**
 * 鉴权请求
 *
 * @author chenlong
 * @version 1.0 2019-03-28
 */
@Getter
@Setter
public class AuthReq implements Serializable {
    private static final long serialVersionUID = 2796391984830046257L;
    /** 【必传】由个推短信服务提供，每个应用都对应一个唯一的appId */
    private String appId;
    // private String appKey = "3Vka1Tp5esAEJRiJuHtul";
    // private String appSecret = "bNOP6cMcubAJt9AtVmWvx6";
    // private String masterSecret = "35xB4XwP948xFlKxJVQK44";
    /** 【必传】生成sign的时间戳 */
    private long timestamp;
    /** 【必传】sha256(appKey+timeStamp+masterSecret) */
    private String sign;

    public AuthReq() {
        this.appId = "4micSqx0QF9zgdQEg02gG7";
        this.timestamp = System.currentTimeMillis();
        this.sign = DigestUtils.sha256Hex("3Vka1Tp5esAEJRiJuHtul" + timestamp + "35xB4XwP948xFlKxJVQK44");
    }

    public AuthReq(String appId, String appKey, String masterSecret) {
        this.appId = appId;
        this.timestamp = System.currentTimeMillis();
        this.sign = DigestUtils.sha256Hex(String.format("%s%d%s", appKey, timestamp, masterSecret));
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append('{')
                .append("\"appId\":\"").append(appId).append('\"')
                .append(",\"timestamp\":").append(timestamp)
                .append(",\"sign\":\"").append(sign).append('\"')
                .append('}')
                .toString();
    }
}
