package com.pltone.eseal.util;

import com.pltone.eseal.dll.AccreditDLL;

import java.nio.charset.StandardCharsets;

/**
 * 授权工具类
 *
 * @author chenlong
 * @version 1.0 2018-06-22
 */
public class AccreditUtil {
    private static final AccreditDLL ACCREDIT_DLL = AccreditDLL.INSTANCE;

    /**
     *
     * @param data
     * @param dataLen
     * @param pwd
     * @param pwdLen
     * @return
     */
    private static boolean getAccreditPassword(byte[] data, int dataLen, byte[] pwd, int pwdLen) {
        return ACCREDIT_DLL.GetAccreditPassword(data, dataLen, pwd, pwdLen);
    }

    /**
     * 根据授权码生成密码
     * @param authCode {@link String} 授权码
     * @return {@link String} 密码
     */
    public static String getAccreditPassword(String authCode) {
        byte[] pwd = new byte[6];
        boolean flag = getAccreditPassword(authCode.getBytes(StandardCharsets.ISO_8859_1), 6, pwd, 6);
        if (flag) {
            return new String(pwd, StandardCharsets.ISO_8859_1);
        }
        throw new IllegalArgumentException("授权码[" + authCode + "]生成密码失败！");
    }
}
