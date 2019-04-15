package com.pltone.eseal.dll;

import com.pltone.eseal.util.DLLUtil;
import jnr.ffi.LibraryLoader;

/**
 * 引入C++动态库accredit.dll
 *
 * @author chenlongs
 * @version 1.0 2018-06-22
 */
public interface AccreditDLL /*extends Library*/ {
    // AccreditDLL INSTANCE = Native.load(DLLUtil.ACCREDIT_DLL_PATH, AccreditDLL.class);
    AccreditDLL INSTANCE = LibraryLoader.create(AccreditDLL.class).load(DLLUtil.extractLib(DLLUtil.ACCREDIT_DLL_PATH));

    /**
     * 通过授权码获取授权密码
     *
     * @param code    授权码
     * @param codeLen 授权码长度，必须等于6
     * @param pwd     密码
     * @param pwdLen  密码长度，必须等于6
     * @return 授权密码生成成功的话接口会返回true
     */
    boolean GetAccreditPassword(byte[] code, int codeLen, byte[] pwd, int pwdLen);

    /**
     * 获取应急解封密码
     *
     * @param key     应急解封密钥
     * @param keyLen  密钥长度
     * @param code    随机码
     * @param codeLen 随机码长度，必须等于6
     * @param pwd     密码
     * @param pwdLen  密码长度，必须等于6
     * @return 应急解封密码生成成功的话接口会返回true
     */
    boolean GetEmergencyAccreditPassword(byte[] key, int keyLen, byte[] code, int codeLen, byte[] pwd, int pwdLen);
}
