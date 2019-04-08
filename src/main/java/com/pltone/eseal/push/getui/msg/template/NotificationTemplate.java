package com.pltone.eseal.push.getui.msg.template;

import com.pltone.eseal.push.getui.msg.template.style.LayoutStyle;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 点开通知打开应用模板
 * 字段名：notification
 *
 * @author chenlong
 * @version 1.0 2019-04-02
 */
@Getter
@Setter
@ToString
public class NotificationTemplate<T extends LayoutStyle> implements Serializable {
    private static final long serialVersionUID = -8435869062802032666L;
    /** 收到消息是否立即启动应用，true为立即启动，false则广播等待启动，默认是否 */
    private boolean transmission_type;
    /** 透传内容 */
    private String transmission_content;
    /** 设定展示开始时间，格式为yyyy-MM-dd HH:mm:ss */
    private String duration_begin;
    /** 设定展示结束时间，格式为yyyy-MM-dd HH:mm:ss */
    private String duration_end;
    /** 【必传】通知栏消息布局样式 */
    private T style;
}
