package com.pltone.eseal.dll;

import com.pltone.eseal.util.DLLUtil;
import jnr.ffi.LibraryLoader;

/**
 * 引入C++动态库libotp.dll
 *
 * @author chenlong
 * @version 1.0 2018-02-24
 */
public interface OtpDLL /*extends Library*/ {
    // OtpDLL INSTANCE = Native.load(DLLUtil.OTP_DLL_PATH, OtpDLL.class);
    OtpDLL INSTANCE = LibraryLoader.create(OtpDLL.class).load(DLLUtil.extractLib(DLLUtil.OTP_DLL_PATH));

    int genPassword(long cardId, long key, long random, short pwdLen);
}
