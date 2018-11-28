package com.pltone.eseal.dll;

import com.pltone.eseal.util.DLLUtil;
import jnr.ffi.LibraryLoader;

/**
 * 引入C++动态库rc4.dll
 *
 * @author chenlong
 * @version 1.0 2017-12-22
 */
public interface Rc4DLL /*extends Library*/ {
    // Rc4DLL INSTANCE = Native.load(DLLUtil.RC4_DLL_PATH, Rc4DLL.class);
    Rc4DLL INSTANCE = LibraryLoader.create(Rc4DLL.class).load(DLLUtil.extractLib(DLLUtil.RC4_DLL_PATH));

    /**
     * RC4加密
     *
     * @param data    {@link byte[]} 待加密字节数组
     * @param dataLen {@link Integer} 待加密的字节数
     * @param key     {@link byte[]} RC4秘钥字节数组
     * @param keyLen  {@link Integer} RC4秘钥有效长度
     */
    void RC4(byte[] data, int dataLen, byte[] key, int keyLen);
}