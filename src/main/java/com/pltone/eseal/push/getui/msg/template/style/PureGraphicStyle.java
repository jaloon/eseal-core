package com.pltone.eseal.push.getui.msg.template.style;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 纯图样式(背景图样式 Background Graphic Style)
 *
 * @author chenlong
 * @version 1.0 2019-04-02
 */
@Getter
@Setter
@ToString
public class PureGraphicStyle implements LayoutStyle, Serializable {
    private static final long serialVersionUID = 7304778147410150583L;
    /** 【必传】固定为 4 */
    private int type = 4;
    /** 通知的图标名称，包含后缀名（需要在客户端开发时嵌入），如“push.png” */
    private String logo;
    /** 【必传】通过url方式指定动态banner图片作为通知背景图 */
    private String banner_url;
    /** 收到通知是否响铃：true响铃，false不响铃。默认响铃 */
    private boolean is_ring = true;
    /** 收到通知是否振动：true振动，false不振动。默认振动 */
    private boolean is_vibrate = true;
    /** 通知是否可清除： true可清除，false不可清除。默认可清除 */
    private boolean is_clearable = true;
}
