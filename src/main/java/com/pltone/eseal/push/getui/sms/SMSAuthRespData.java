package com.pltone.eseal.push.getui.sms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 短信鉴权应答数据
 *
 * @author chenlong
 * @version 1.0 2019-03-28
 */
@Getter
@Setter
public class SMSAuthRespData implements SMSData, Serializable {
    private static final long serialVersionUID = 3226121466106830465L;
    /** 权限令牌，调用其他接口时需提供 */
    private String authToken;

    @Override
    public String toString() {
        return new StringBuilder()
                .append('{')
                .append("\"authToken\":\"").append(authToken).append('\"')
                .append('}')
                .toString();
    }
}
