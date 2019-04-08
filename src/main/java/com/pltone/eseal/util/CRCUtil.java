package com.pltone.eseal.util;

import com.pltone.eseal.dll.CrcDLL;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * CRC校验工具类
 *
 * @author chenlong
 * @version 1.0 2017-12-22
 */
public class CRCUtil {
    private static final CrcDLL CRC_DLL = CrcDLL.INSTANCE;

    /**
     * 获取CRC校验码
     *
     * @param data    待校验的字节数组
     * @param dataLen 待校验的字节数组长度
     * @return byte CRC校验码
     */
    public static byte getCRC(byte[] data, int dataLen) {
        return CRC_DLL.GetCRC(data, dataLen);
    }

    /**
     * 获取CRC校验码
     *
     * @param data 待校验的字节数组
     * @return byte CRC校验码
     */
    public static byte getCRC(byte[] data) {
        return getCRC(data, data.length);
    }

    /**
     * 获取CRC32校验码
     *
     * @param data    待校验的字节数组
     * @param dataLen 待校验的字节数组长度
     * @return int CRC32校验码
     */
    public static int getCRC32(byte[] data, int dataLen) {
        return CRC_DLL.GetCRC32(data, dataLen);
    }

    /**
     * 获取CRC32校验码
     *
     * @param data 待校验的字节数组
     * @return int CRC32校验码
     */
    public static int getCRC32(byte[] data) {
        return getCRC32(data, data.length);
    }

    /**
     * 生成添加了CRC校验码的字节数组
     *
     * @param data 待校验的字节数组
     * @return byte[] 末尾加上一个字节CRC校验码的字节数组
     */
    public static byte[] addCrcToBytes(byte[] data) {
        int len = data.length;
        ByteBuffer buff = ByteBuffer.allocate(len + 1);
        buff.put(data, 0, len);
        byte b = getCRC(data, len);
        buff.put(len, b);
        return buff.array();
    }

    /**
     * 校验具有CRC校验码的字节数组的有效性
     *
     * @param crcData 具有CRC校验码的字节数组
     * @return <code>true</code> 数据有效，<code>false</code> 数据无效
     */
    public static boolean checkCrc(byte[] crcData) {
        int len = crcData.length - 1;
        byte[] data = Arrays.copyOf(crcData, len);
        return getCRC(data, len) == crcData[len];
    }

    /**
     * 校验具有CRC校验码的字节数组的有效性
     *
     * @param crcData 具有CRC校验码的字节数组
     * @param from    the initial index of the range to be checked, inclusive.
     *                要校验的范围的初始索引（包括）
     * @param to      the final index of the range to be checked, exclusive.
     *                要校验的范围的最终索引（不包括）
     * @return <code>true</code> 数据有效，<code>false</code> 数据无效
     */
    public static boolean checkCrc(byte[] crcData, int from, int to) {
        byte[] data = Arrays.copyOfRange(crcData, from, to);
        return getCRC(data) == crcData[crcData.length - 1];
    }

}
