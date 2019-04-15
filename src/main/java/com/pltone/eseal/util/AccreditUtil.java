package com.pltone.eseal.util;

import com.pltone.common.util.BytesUtil;
import com.pltone.eseal.dll.AccreditDLL;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 授权工具类
 *
 * @author chenlong
 * @version 1.0 2018-06-22
 */
public class AccreditUtil {
    private static final AccreditDLL ACCREDIT_DLL = AccreditDLL.INSTANCE;

    /**
     * 根据授权码生成密码
     *
     * @param code 授权码
     * @param pwd  密码
     * @return true 密码生成成功，false 密码生成失败
     */
    private static boolean getAccreditPassword(byte[] code, byte[] pwd) {
        return ACCREDIT_DLL.GetAccreditPassword(code, 6, pwd, 6);
    }

    /**
     * 根据授权码生成密码
     *
     * @param authCode {@link String} 授权码
     * @return {@link String} 密码
     */
    public static String getAccreditPassword(String authCode) {
        byte[] pwd = new byte[6];
        boolean flag = getAccreditPassword(authCode.getBytes(StandardCharsets.ISO_8859_1), pwd);
        if (flag) {
            return new String(pwd, StandardCharsets.ISO_8859_1);
        }
        throw new IllegalArgumentException("授权码[" + authCode + "]生成密码失败！");
    }

    /**
     * 生成应急解封密码
     *
     * @param key  应急解封密钥
     * @param code 随机码
     * @param pwd  应急解封密码
     * @return true 密码生成成功，false 密码生成失败
     */
    private static boolean getEmergencyPassword(byte[] key, byte[] code, byte[] pwd) {
        System.out.println(Arrays.toString(key));
        System.out.println(Arrays.toString(code));
        return ACCREDIT_DLL.GetEmergencyAccreditPassword(key, key.length, code, 6, pwd, 6);
    }

    /**
     * 生成应急解封密码
     *
     * @param deviceId   设备ID
     * @param centerKey  中心应急解封密钥
     * @param randomCode 随机码
     * @return 应急解封密码
     */
    public static String getEmergencyPassword(int deviceId, String centerKey, String randomCode) {
        // 密钥组合方式：
        // 第1个字节：设备类型
        // 第2、3个字节：设备ID高位的两个字节
        // 第4、5个字节：设备ID低位的两个字节
        // 剩下的字节：用户密钥字符串
        // byte type = (byte) (deviceId >> 24 & 0xFF);
        // deviceId = (deviceId >> 16 & 0x0000FFFF) | (deviceId << 16 & 0xFFFF0000);
        byte[] deviceIdBytes = BytesUtil.LITTLE_ENDIAN_CODEC.getBytes(deviceId);
        byte[] centerKeyBytes = centerKey.getBytes(StandardCharsets.ISO_8859_1);
        ByteBuffer keyBuf = ByteBuffer.allocate(5 + centerKeyBytes.length);
        // 设备类型
        keyBuf.put(deviceIdBytes[3]);
        // 设备ID高位的两个字节
        keyBuf.put(deviceIdBytes[2]);
        keyBuf.put(deviceIdBytes[3]);
        // 设备ID低位的两个字节
        keyBuf.put(deviceIdBytes[0]);
        keyBuf.put(deviceIdBytes[1]);
        // 用户中心密钥
        keyBuf.put(centerKeyBytes);

        byte[] pwd = new byte[6];
        boolean flag = getEmergencyPassword(keyBuf.array(), randomCode.getBytes(StandardCharsets.ISO_8859_1), pwd);
        if (flag) {
            return new String(pwd, StandardCharsets.ISO_8859_1);
        }
        throw new IllegalArgumentException("生成应急解封密码失败！");
    }

}
