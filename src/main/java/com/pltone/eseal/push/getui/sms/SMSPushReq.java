package com.pltone.eseal.push.getui.sms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 短信群推请求
 *
 * @author chenlong
 * @version 1.0 2019-03-28
 */
@Getter
@Setter
@Builder
public class SMSPushReq implements Serializable {
    private static final long serialVersionUID = -3781671498533065491L;
    /** 【必传】由个推短信服务提供，每个应用都对应一个唯一的appId */
    private String appId;
    /** 【必传】权限令牌，由鉴权接口返回 */
    private String authToken;
    /** 【必传】模板id */
    private String smsTemplateId;
    /** 短信模板变量，传参规则{"key":"value"},key的名字需和模板中定义的变量一致；若模板无变量，此参数不需要传 */
    private Map<String, String> smsParam;
    /** 【必传】接收短信的号码，目前单次最大发送量为50个MD5加密后的手机号码。例如：["md5(pn1)","md5(pn2)"] */
    private List<String> recNum;
    /** 客户用于接收短信发送回执的接口地址，请求以Json格式POST方式提交 */
    private String notifyUrl;

    public SMSPushReq() {}

    public SMSPushReq(String appId, String authToken, String smsTemplateId, Map<String, String> smsParam, List<String> recNum, String notifyUrl) {
        this.appId = appId;
        this.authToken = authToken;
        this.smsTemplateId = smsTemplateId;
        this.smsParam = smsParam;
        this.recNum = recNum;
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append("\"appId\":\"").append(appId).append('\"');
        sb.append(",\"authToken\":\"").append(authToken).append('\"');
        sb.append(",\"smsTemplateId\":\"").append(smsTemplateId).append('\"');
        if (smsParam != null) {
            sb.append(",\"smsParam\":{");
            if (!smsParam.isEmpty()) {
                smsParam.forEach((name, val) -> sb.append("\"").append(name).append("\":\"").append(val).append("\","));
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append('}');
        }
        if (recNum != null) {
            sb.append(",\"recNum\":[");
            if (!recNum.isEmpty()) {
                recNum.forEach(phone -> sb.append("\"").append(phone).append("\","));
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(']');
        }
        if (notifyUrl != null) {
            sb.append(",\"notifyUrl\":\"").append(notifyUrl).append('\"');
        }
        sb.append('}');
        return sb.toString();
    }
}
