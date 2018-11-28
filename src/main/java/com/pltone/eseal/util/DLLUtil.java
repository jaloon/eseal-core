package com.pltone.eseal.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.pltone.common.constant.SystemPropertyConst.JRE_ARCH;
import static com.pltone.common.constant.SystemPropertyConst.OS_NAME;
import static com.pltone.common.constant.SystemPropertyConst.TEMP_DIR;

/**
 * dll加载调用工具类
 *
 * @author chenlong
 * @version 1.0 2018-11-28
 */
public class DLLUtil {
    private DLLUtil() {}

    /** dll文件目录 */
    public static final String DLL_DIR;

    static {
        String dllDir = DLLUtil.class.getResource("").toString();
        if (dllDir.startsWith("/")) {
            DLL_DIR = dllDir.substring(1, dllDir.length() - 22);
        } else if (dllDir.startsWith("file:/")) {
            DLL_DIR = dllDir.substring(6, dllDir.length() - 22);
        } else if (dllDir.startsWith("jar:file:/")) {
            DLL_DIR = dllDir.substring(10, dllDir.length() - 22);
        } else {
            DLL_DIR = dllDir.substring(0, dllDir.length() - 22);
        }
    }

    /** dll/accredit */
    public static final String ACCREDIT_DLL_PATH = new StringBuffer("dll/").append(JRE_ARCH).append("/accredit").toString();
    /** dll/crc */
    public static final String CRC_DLL_PATH = new StringBuffer("dll/").append(JRE_ARCH).append("/crc").toString();
    /** dll/libotp */
    public static final String OTP_DLL_PATH = new StringBuffer("dll/").append(JRE_ARCH).append("/libotp").toString();
    /** dll/rc4 */
    public static final String RC4_DLL_PATH = new StringBuffer("dll/").append(JRE_ARCH).append("/rc4").toString();
    /** dll/umf */
    public static final String UMF_DLL_PATH = new StringBuffer("dll/").append(JRE_ARCH).append("/umf").toString();

    /**
     * 提取jar包中dll文件到临时目录
     *
     * @param libPath dll文件路径
     * @return dll文件在临时目录的绝对路径
     */
    public static String extractLib(String libPath) {
        boolean isWin = OS_NAME.toLowerCase().contains("win");
        String libSuffix = isWin ? ".dll" : ".so";
        libPath = libPath + libSuffix;
        String[] pathArr = libPath.split("/");
        String libName = pathArr[pathArr.length - 1];

        InputStream input = DLLUtil.class.getResourceAsStream("/" + libPath);
        if (input == null) {
            input = DLLUtil.class.getResourceAsStream(libPath);
        }
        File tempLib = new File(TEMP_DIR, libName);
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(tempLib);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    // ignore
                }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
        String tempLibName = tempLib.getAbsolutePath();
        tempLibName = tempLibName.substring(0, tempLibName.lastIndexOf("."));
        return tempLibName;
    }
}
