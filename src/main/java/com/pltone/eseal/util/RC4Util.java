package com.pltone.eseal.util;

import com.pltone.common.util.BytesUtil;
import com.pltone.eseal.dll.Rc4DLL;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * RC4工具类
 *
 * @author chenlong
 * @version 1.0 2017-12-22
 */
public class RC4Util {
    private static final Rc4DLL RC4_DLL = Rc4DLL.INSTANCE;
    private static final Random random = new Random();
    /** RC4秘钥长度 */
    private static final int RC4_KEY_LENGTH = 16;
    /** 普利通中心域名 */
    private static final String PLTONE_COM = "pltone.com/";

    /**
     * 生成随机字符串秘钥
     */
    public static String createKey() {
        char buf[] = new char[RC4_KEY_LENGTH];
        for (int i = 0; i < RC4_KEY_LENGTH; i++) {
            // ASCII码0~31和127是控制字符，无法显示
            int ascii = random.nextInt(95) + 32;
            buf[i] = (char) ascii;
        }
        return new String(buf);
    }

    /**
     * 生成随机字节流秘钥
     */
    public static byte[] createBinaryKey() {
        byte[] bytes = new byte[RC4_KEY_LENGTH];
        random.nextBytes(bytes);
        return bytes;
    }

    /**
     * 根据设备ID生成RC4秘钥
     *
     * @param deviceId int 设备ID，4个字节
     * @return RC4秘钥
     */
    public static byte[] getKeyByDeviceId(Integer deviceId) {
        ByteBuffer keyBuf = ByteBuffer.allocate(RC4_KEY_LENGTH);
        // 普利通中心域名，11个字节
        keyBuf.put(PLTONE_COM.getBytes(StandardCharsets.ISO_8859_1));
        // 设备ID，4个字节
        keyBuf.put(BytesUtil.LITTLE_ENDIAN_CODEC.getBytes(deviceId));
        // 前15个字节CRC校验码，1个字节
        keyBuf.put(CRCUtil.getCRC(keyBuf.array(), RC4_KEY_LENGTH - 1));
        return keyBuf.array();
    }

    /**
     * RC4加解密
     *
     * @param dataBytes 待加密或解密字节数组
     * @param keyBytes  秘钥字节数组
     * @return byte[] 加密或解密后的字节数组
     */
    public static byte[] rc4(byte[] dataBytes, byte[] keyBytes) {
        RC4_DLL.RC4(dataBytes, dataBytes.length, keyBytes, keyBytes.length);
        return dataBytes;
    }

    /**
     * RC4加解密
     *
     * @param dataBytes 待加密或解密字节数组
     * @param key       秘钥字符串
     * @return byte[] 加密或解密后的字节数组
     */
    public static byte[] rc4(byte[] dataBytes, String key) {
        return rc4(dataBytes, key.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * RC4加解密
     *
     * @param data     待加密或解密字符串
     * @param keyBytes 秘钥字节数组
     * @return byte[] 加密或解密后的字节数组
     */
    public static byte[] rc4(String data, byte[] keyBytes) {
        return rc4(data.getBytes(StandardCharsets.UTF_8), keyBytes);
    }

    /**
     * @param data 待加密或解密字符串
     * @param key  秘钥字符串
     * @return byte[] 加密或解密后的字节数组
     */
    public static byte[] rc4(String data, String key) {
        return rc4(data.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * @param dataBytes 待加密或解密字节数组
     * @param keyBytes  秘钥字节数组
     * @return String 加密或解密后的字节数组对应的十六进制字符串
     */
    public static String rc4ToHexString(byte[] dataBytes, byte[] keyBytes) {
        dataBytes = rc4(dataBytes, keyBytes);
        return BytesUtil.BASE_16.encode(dataBytes);
    }

    /**
     * @param dataBytes 待加密或解密字节数组
     * @param key       秘钥字符串
     * @return String 加密或解密后的字节数组对应的十六进制字符串
     */
    public static String rc4ToHexString(byte[] dataBytes, String key) {
        dataBytes = rc4(dataBytes, key);
        return BytesUtil.BASE_16.encode(dataBytes);
    }

    /**
     * @param data     待加密或解密字符串
     * @param keyBytes 秘钥字节数组
     * @return String 加密或解密后的字节数组对应的十六进制字符串
     */
    public static String rc4ToHexString(String data, byte[] keyBytes) {
        byte[] dataBytes = rc4(data, keyBytes);
        return BytesUtil.BASE_16.encode(dataBytes);
    }

    /**
     * @param data 待加密或解密字符串
     * @param key  秘钥字符串
     * @return String 加密或解密后的字节数组对应的十六进制字符串
     */
    public static String rc4ToHexString(String data, String key) {
        byte[] dataBytes = rc4(data, key);
        return BytesUtil.BASE_16.encode(dataBytes);
    }

}
