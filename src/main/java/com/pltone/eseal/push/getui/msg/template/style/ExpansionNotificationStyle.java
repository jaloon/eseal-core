package com.pltone.eseal.push.getui.msg.template.style;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 展开通知样式
 *
 * @author chenlong
 * @version 1.0 2019-04-02
 */
@Getter
@Setter
@ToString
public class ExpansionNotificationStyle implements LayoutStyle, Serializable {
    private static final long serialVersionUID = 8875731756085038165L;
    /** 【必传】固定为 6 */
    private int type = 6;
    /** 【必传】通知内容 */
    private String text;
    /** 【必传】通知标题 */
    private String title;
    /** 通知的图标名称，包含后缀名（需要在客户端开发时嵌入），如“push.png” */
    private String logo;
    /** 通知图标URL地址 */
    private String logourl;
    /** 【必传】通知展示样式,枚举值包括 1,2,3 */
    private String big_style;
    /** 通知大图URL地址 */
    private String big_image_url;
    /** 通知展示文本+长文本样式，参数是长文本 */
    private String big_text;
    /** 通知小图URL地址 */
    private String banner_url;
    /** 收到通知是否响铃：true响铃，false不响铃。默认响铃 */
    private boolean is_ring = true;
    /** 收到通知是否振动：true振动，false不振动。默认振动 */
    private boolean is_vibrate = true;
    /** 通知是否可清除： true可清除，false不可清除。默认可清除 */
    private boolean is_clearable = true;

    public static class BigStyle {
        /** 1 通知展示大图样式，参数是大图的URL地址 */
        public static final String big_image_url = "big_image_url";
        /** 2 通知展示文本+长文本样式，参数是长文本 */
        public static final String big_text = "big_text";
        /** 3 通知展示大图+小图样式，参数是大图URL和小图URL */
        public static final String big_image_url_banner_url = "big_image_url,banner_url";
    }
}
