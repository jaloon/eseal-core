package com.pltone.eseal.util;

import com.pltone.eseal.dll.OtpDLL;

import java.util.Random;

/**
 * OTP一次性密码算法工具类
 *
 * @author chenlong
 * @version 1.0 2018-02-24
 */
public class OTPUtil {
    private static final OtpDLL OTP_DLL = OtpDLL.INSTANCE;
    private static final Random RANDOM = new Random();
    private static int complement;
    private static int encrypt;

    /**
     * 生成一个长度为3的OTP密码
     *
     * @param cardId {@link long} 卡ID
     * @param key    {@link long} 卡所对应的密钥
     * @param random {@link long} 随机数
     * @return {@link int} OTP密码
     */
    public static int genPassword3(long cardId, long key, long random) {
        return OTP_DLL.genPassword(cardId, key, random, (short) 3);
    }

    /**
     * 生成一个长度为6的OTP密码
     *
     * @param cardId {@link long} 卡ID
     * @param key    {@link long} 卡所对应的密钥
     * @param random {@link long} 随机数
     * @return {@link int} OTP密码
     */
    public static int genPassword6(long cardId, long key, long random) {
        return OTP_DLL.genPassword(cardId, key, random, (short) 6);
    }

    /**
     * 生成一个指定长度的OTP密码
     *
     * @param cardId {@link long} 卡ID
     * @param key    {@link long} 卡所对应的密钥
     * @param random {@link long} 随机数
     * @param pwdLen {@link short} 生成密码的长度
     * @return {@link int} OTP密码
     */
    public static int genPassword(long cardId, long key, long random, short pwdLen) {
        return OTP_DLL.genPassword(cardId, key, random, pwdLen);
    }

    /**
     * 生成一个长度为3的OTP密码(数字前面补0)
     *
     * @param cardId {@link long} 卡ID
     * @param key    {@link long} 卡所对应的密钥
     * @param random {@link long} 随机数
     * @return {@link String} 格式化的OTP密码
     */
    public static String genFormatPassword3(long cardId, long key, long random) {
        int pwd = genPassword3(cardId, key, random);
        return String.format("%03d", pwd);
    }

    /**
     * 生成一个长度为6的OTP密码(数字前面补0)
     *
     * @param cardId {@link long} 卡ID
     * @param key    {@link long} 卡所对应的密钥
     * @param random {@link long} 随机数
     * @return {@link String} 格式化的OTP密码
     */
    public static String genFormatPassword6(long cardId, long key, long random) {
        int pwd = genPassword6(cardId, key, random);
        return String.format("%06d", pwd);
    }

    /**
     * 生成一个指定长度的OTP密码(数字前面补0)
     *
     * @param cardId {@link long} 卡ID
     * @param key    {@link long} 卡所对应的密钥
     * @param random {@link long} 随机数
     * @param pwdLen {@link short} 生成密码的长度
     * @return {@link String} 格式化的OTP密码
     */
    public static String genFormatPassword(long cardId, long key, long random, short pwdLen) {
        String format = new StringBuffer("%0").append(pwdLen).append('d').toString();
        int pwd = genPassword(cardId, key, random, pwdLen);
        return String.format(format, pwd);
    }

    /**
     * 获取6位格式化OTP密码（三位密码与三位随机数字异或处理）
     *
     * @param cardId {@link long} 卡ID
     * @param key    {@link long} 卡所对应的密钥
     * @param random {@link long} 随机数
     * @return {@link String} 格式化的OTP密码
     */
    public static String getPassword(long cardId, long key, long random) {
        int pwd3 = genPassword3(cardId, key, random);
        dealPwd3(pwd3);
        String prefix = String.format("%03d", encrypt);
        String suffix = String.format("%03d", complement);
        return new StringBuffer(prefix).append(suffix).toString();
    }

    /**
     * 对3位OTP密码进行异或处理
     *
     * @param pwd3 {@link int} 3位数字的OTP密码
     */
    private static void dealPwd3(int pwd3) {
        complement = RANDOM.nextInt(999) + 1;
        encrypt = pwd3 ^ complement;
        if (encrypt > 999) {
            dealPwd3(pwd3);
        }
    }

}
