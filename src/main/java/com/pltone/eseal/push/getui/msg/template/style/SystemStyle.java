package com.pltone.eseal.push.getui.msg.template.style;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统样式
 *
 * @author chenlong
 * @version 1.0 2019-04-02
 */
@Getter
@Setter
@ToString
public class SystemStyle implements LayoutStyle, Serializable {
    private static final long serialVersionUID = 2944501933000300398L;
    /** 【必传】固定为 0 */
    private int type = 0;
    /** 【必传】通知内容 */
    private String text;
    /** 【必传】通知标题 */
    private String title;
    /** 【必传】通知的图标名称，包含后缀名（需要在客户端开发时嵌入），如“push.png” */
    private String logo;
    /** 收到通知是否响铃：true响铃，false不响铃。默认响铃 */
    private boolean is_ring = true;
    /** 收到通知是否振动：true振动，false不振动。默认振动 */
    private boolean is_vibrate = true;
    /** 通知是否可清除： true可清除，false不可清除。默认可清除 */
    private boolean is_clearable = true;
}
