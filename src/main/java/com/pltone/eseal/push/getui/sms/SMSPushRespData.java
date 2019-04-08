package com.pltone.eseal.push.getui.sms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * 短信群推应答数据
 *
 * @author chenlong
 * @version 1.0 2019-03-28
 */
@Getter
@Setter
public class SMSPushRespData implements SMSData, Serializable {
    private static final long serialVersionUID = 77432760506928254L;
    /** 个推短信服务生成的推送任务id */
    private String taskId;
    /** 短信推送结果返回，例如：[{ "md5(pn1)": code}, { "md5(pn2)": code}] */
    private Map<String, Integer> results;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append("\"taskId\":\"").append(taskId).append('\"');
        if (results != null) {
            sb.append(",\"results\":{");
            if (!results.isEmpty()) {
                results.forEach((phone, code) -> sb.append("\"").append(phone).append("\":").append(code).append(','));
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append('}');
        }
        sb.append('}');
        return sb.toString();
    }
}
