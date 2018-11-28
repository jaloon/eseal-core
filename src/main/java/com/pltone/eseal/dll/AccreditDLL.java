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
    // 通过授权Key获取授权密码
    // v_iByteLen v_iPwdLen 必须等于6
    // 授权密钥生成成功的话接口会返回true

    /**
     * @param data    {@link byte[]}
     * @param dataLen {@link Integer}
     * @param pwd     {@link byte[]}
     * @param pwdLen  {@link Integer}
     * @return {@link Boolean}
     */
    boolean GetAccreditPassword(byte[] data, int dataLen, byte[] pwd, int pwdLen);
}
