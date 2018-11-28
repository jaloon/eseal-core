package com.pltone.eseal.util;

import com.pltone.eseal.dll.UmfDLL;

/**
 * IC卡读写器读卡工具类
 *
 * @author chenlong
 * @version 1.0 2018-05-14
 */
public class UMFUtil {
    private static final UmfDLL UMF_DLL = UmfDLL.INSTANCE;
    private static final long[] CARD_ID = new long[8];
    private static final byte[] CARD_HEX = new byte[16];
    private static final byte[] CARD_DEC = new byte[10];

    /**
     * 初始化通讯口
     *
     * @param port {@link Integer} 取值为 0～99 时，表示串口 1～100；取值为 101~M(M 表示大于 101 的一个数)时，表示串口 101~M；
     *             为 100 时，表示 USB 口通讯，此时波特率无效。
     * @param baud {@link Long} 为通讯波特率（ 9600～115200），若设备为 USB 接口此参数无效，可设任意long 型值
     * @return {@link Integer} 成功则返回通讯设备标识符值，失败返回 -1
     */
    public static int init(int port, long baud) {
        return UMF_DLL.fw_init(port, baud);
    }

    /**
     * 初始化 USB 口
     *
     * @return {@link Integer} 成功则返回通讯设备标识符值，失败返回 -1
     */
    public static int initUSB() {
        return init(100, 0);
    }

    /**
     * 蜂鸣
     *
     * @param icdev {@link Integer} 通讯设备标识符
     * @param xmsec {@link Integer} 蜂鸣时间，单位是 10 毫秒
     * @return {@link Integer} 成功则返回 0
     */
    public static int beep(int icdev, int xmsec) {
        return UMF_DLL.fw_beep(icdev, xmsec);
    }

    /**
     * 设置 LCD 背光点亮或熄灭
     *
     * @param icdev  {@link Integer} 通讯设备标识符（
     * @param bright {@link Integer} 点亮或熄灭的标志（15 点亮，0 熄灭）
     * @return {@link Integer} 成功则返回 0
     */
    public static int lcd(int icdev, int bright) {
        return UMF_DLL.fw_lcd_setbright(icdev, bright);
    }

    /**
     * 关闭端口
     *
     * <b>注：</b>在 WIN32 环境下 icdev 为端口的设备句柄，必须释放后才可以再次连接。
     *
     * @param icdev {@link Integer} 通讯设备标识符
     * @return {@link Integer} 成功返回 0
     */
    public static int exit(int icdev) {
        return UMF_DLL.fw_exit(icdev);
    }

    /**
     * 寻卡，能返回在工作区域内某张卡的序列号
     *
     * @param icdev {@link Integer} 通讯设备标识符
     * @param mode  {@link Integer} 寻卡模式（0 表示 IDLE 模式，一次只对一张卡操作；1 表示 ALL 模式，一次可对多张卡操作）
     * @return {@link Long} 卡序列号（长整形变量）
     * @throws IllegalStateException if result code is not 0.
     */
    public static long cardId(int icdev, int mode) {
        int code = cardId(icdev, mode, CARD_ID);
        if (code == 0) {
            return CARD_ID[0];
        } else {
            throw new IllegalStateException("寻卡失败！错误码：" + code);
        }
    }

    /**
     * 寻卡，能返回在工作区域内某张卡的序列号
     * <p>
     * 选择 IDLE 模式，在对卡进行读写操作，执行 fw_halt 指令中止卡操作后，只有当该卡离开并再次进入操作区时，读写器才能够再次对它进行操作
     *
     * @param icdev  {@link Integer} 通讯设备标识符
     * @param mode   {@link Integer} 寻卡模式（0 表示 IDLE 模式，一次只对一张卡操作；1 表示 ALL 模式，一次可对多张卡操作）
     * @param cardId {@link long[]} 返回的卡序列号（长整形变量）
     * @return {@link Integer} 成功返回 0
     */
    public static int cardId(int icdev, int mode, long[] cardId) {
        return UMF_DLL.fw_card(icdev, mode, cardId);
    }

    /**
     * 寻卡，能返回在工作区域内某张卡的序列号(16进制形式字符串)
     *
     * @param icdev {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @param mode  {@link Integer} 寻卡模式（0 表示 IDLE 模式，一次只对一张卡操作；1 表示 ALL 模式，一次可对多张卡操作）
     * @return {@link String} 卡的序列号(16进制形式字符串，8个字节)
     * @throws IllegalStateException if result code is not 0.
     */
    public static String cardHex(int icdev, int mode) {
        int code = cardHex(icdev, mode, CARD_HEX);
        if (code == 0) {
            return new String(CARD_HEX);
        } else {
            throw new IllegalStateException("寻卡失败！错误码：" + code);
        }
    }

    /**
     * 寻卡，能返回在工作区域内某张卡的序列号(16进制形式字符串)
     *
     * @param icdev {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @param mode  {@link Integer} 寻卡模式（0 表示 IDLE 模式， 一次只对一张卡操作；1 表示 ALL 模式，一次可对多张卡操作）
     * @param hexId {@link byte[]} 返回的表示 16 进制字符串卡号（8个字节）的字节数组
     * @return {@link Integer} 成功返回 0
     */
    public static int cardHex(int icdev, int mode, byte[] hexId) {
        return UMF_DLL.fw_card_hex(icdev, mode, hexId);
    }

    /**
     * 使用 IDLE + HALT 模式寻卡（必须把卡移开感应区再进来才能寻得这张卡），返回10进制字符串卡号
     *
     * @param icdev {@link Integer} 通讯设备标识符
     * @return {@link String} 卡的序列号(10进制形式字符串，10个数字序列)
     * @throws IllegalStateException if result code is not 0.
     */
    public static String cardDec(int icdev) {
        int code = cardDec(icdev, 0, CARD_DEC);
        halt(icdev);
        if (code == 0) {
            beep(icdev, 10);
            return new String(CARD_DEC);
        } else {
            throw new IllegalStateException("寻卡失败！错误码：" + code);
        }
    }

    /**
     * 寻卡，能返回在工作区域内某张卡的序列号(10进制形式字符串)
     *
     * @param icdev {@link Integer} 通讯设备标识符
     * @param mode  {@link Integer} 寻卡模式（0 表示 IDLE 模式，一次只对一张卡操作；1 表示 ALL 模式，一次可对多张卡操作）
     * @return {@link String} 卡的序列号(10进制形式字符串，10个数字序列)
     * @throws IllegalStateException if result code is not 0.
     */
    public static String cardDec(int icdev, int mode) {
        int code = cardDec(icdev, mode, CARD_DEC);
        if (code == 0) {
            return new String(CARD_DEC);
        } else {
            throw new IllegalStateException("寻卡失败！错误码：" + code);
        }
    }

    /**
     * 寻卡，能返回在工作区域内某张卡的序列号(10进制形式字符串)
     *
     * @param icdev {@link Integer} 通讯设备标识符
     * @param mode  {@link Integer} 寻卡模式（0 表示 IDLE 模式，一次只对一张卡操作；1 表示 ALL 模式， 一次可对多张卡操作）
     * @param decId {@link byte[]} 返回的 10 进制字符串卡号（ 10个数字序列）
     * @return {@link Integer} 成功返回 0
     */
    public static int cardDec(int icdev, int mode, byte[] decId) {
        return UMF_DLL.fw_card_str(icdev, mode, decId);
    }

    /**
     * 中止对该卡操作
     * <p>
     * 使用 fw_card()函数时，有个mode参数。如果mode=0，则在对卡进行操作完毕后，
     * 执行 fw_halt()方法，该卡进入 HALT 模式，则必须把卡移开感应区再进来才能寻得这张卡
     *
     * @param icdev {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @return {@link Integer} 成功返回 0
     */
    public static int halt(int icdev) {
        return UMF_DLL.fw_halt(icdev);
    }
}