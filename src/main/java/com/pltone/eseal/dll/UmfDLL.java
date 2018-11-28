package com.pltone.eseal.dll;

import com.pltone.eseal.util.DLLUtil;
import jnr.ffi.LibraryLoader;

/**
 * IC卡读写
 * 引入C++动态库uml.dll
 *
 * @author chenlong
 * @version 1.0 2018-05-14
 */
public interface UmfDLL /*extends Library*/ {
    // UmfDLL INSTANCE = Native.load(DLLUtil.UMF_DLL_PATH, UmfDLL.class);
    UmfDLL INSTANCE = LibraryLoader.create(UmfDLL.class).load(DLLUtil.extractLib(DLLUtil.UMF_DLL_PATH));

    /**
     * 初始化通讯口
     *
     * @param port {@link Integer} 取值为 0～99 时，表示串口 1～100；取值为 101~M(M 表示大于 101 的一个数)时，表示串口 101~M；
     *             为 100 时，表示 USB 口通讯，此时波特率无效。
     * @param baud {@link Long} 为通讯波特率（ 9600～115200），若设备为 USB 接口此参数无效，可设任意long 型值
     * @return {@link Integer} 成功则返回串口标识符值，失败返回 -1
     */
    int fw_init(int port, long baud);

    /**
     * 蜂鸣
     *
     * @param icdev {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @param xmsec {@link Integer} 蜂鸣时间，单位是 10 毫秒
     * @return {@link Integer} 成功则返回 0
     */
    int fw_beep(int icdev, int xmsec);

    /**
     * 设置 LCD 背光点亮或熄灭
     *
     * @param icdev  {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @param bright {@link Integer} 点亮或熄灭的标志（15 点亮，0 熄灭）
     * @return {@link Integer} 成功则返回 0
     */
    int fw_lcd_setbright(int icdev, int bright);

    /**
     * 关闭端口
     *
     * <b>注：</b>在 WIN32 环境下 icdev 为端口的设备句柄，必须释放后才可以再次连接。
     *
     * @param icdev {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @return {@link Integer} 成功返回 0
     */
    int fw_exit(int icdev);

    /**
     * 寻卡，能返回在工作区域内某张卡的序列号(该函数包含了fw_request,fw_anticoll,fw_select的整体功能)
     * <p>
     * 选择 IDLE 模式，在对卡进行读写操作，执行 fw_halt 指令中止卡操作后，只有当该卡离开并再次进入操作区时，读写器才能够再次对它进行操作
     *
     * @param icdev  {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @param mode   {@link Integer} 寻卡模式（0 表示 IDLE 模式，一次只对一张卡操作；1 表示 ALL 模式，一次可对多张卡操作）
     * @param cardId {@link long[]} 返回的卡序列号（长整形变量）
     * @return {@link Integer} 成功返回 0
     */
    int fw_card(int icdev, int mode, long[] cardId);

    /**
     * 寻卡，能返回在工作区域内某张卡的序列号(16进制形式字符串)
     *
     * @param icdev {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @param mode  {@link Integer} 寻卡模式（0 表示 IDLE 模式，一次只对一张卡操作；1 表示 ALL 模式，一次可对多张卡操作）
     * @param hexId {@link byte[]} 返回的表示 16 进制字符串卡号（8个字节）的字节数组
     * @return {@link Integer} 成功返回 0
     */
    int fw_card_hex(int icdev, int mode, byte[] hexId);

    /**
     * 寻卡，能返回在工作区域内某张卡的序列号(10进制形式字符串)
     *
     * @param icdev {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @param mode  {@link Integer} 寻卡模式（0 表示 IDLE 模式，一次只对一张卡操作；1 表示 ALL 模式，一次可对多张卡操作）
     * @param decId {@link byte[]} 返回的 10 进制字符串卡号（ 10个数字序列）
     * @return {@link Integer} 成功返回 0
     */
    int fw_card_str(int icdev, int mode, byte[] decId);

    /**
     * 中止对该卡操作
     * <p>
     * 使用 fw_card()函数时，有个mode参数。如果mode=0，则在对卡进行操作完毕后，
     * 执行 fw_halt()方法，该卡进入 HALT 模式，则必须把卡移开感应区再进来才能寻得这张卡
     *
     * @param icdev {@link Integer} 通讯设备标识符（即fw_init方法的返回值）
     * @return {@link Integer} 成功返回 0
     */
    int fw_halt(int icdev);
}
