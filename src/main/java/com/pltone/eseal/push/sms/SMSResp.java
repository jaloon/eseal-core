package com.pltone.eseal.push.sms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 短信推送服务应答
 *
 * @author chenlong
 * @version 1.0 2019-03-28
 */
@Getter
@Setter
public class SMSResp<T extends SMSData> implements Serializable {
    private static final long serialVersionUID = 7588731937114409018L;
    private String result;
    private String msg;
    private T data;

    @JsonIgnore
    public boolean isSuccessful() {
        return "20000".equals(result);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append("\"result\":\"").append(result).append('\"');
        sb.append(",\"msg\":\"").append(msg).append('\"');
        if (data != null) {
            sb.append(",\"data\":").append(data.toString());
        }
        sb.append('}');
        return sb.toString();
    }
}
