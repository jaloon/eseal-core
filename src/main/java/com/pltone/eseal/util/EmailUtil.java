package com.pltone.eseal.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import javax.mail.Authenticator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 邮件发送工具类
 *
 * @author chenlong
 * @version 1.0 2018-09-03
 */
public class EmailUtil {
    private static final String HOST_NAME = "smtp.exmail.qq.com";
    private static final String SENDER = "eseal@pltone.com";
    private static final String PASSWORD = "e-Seal18";
    private static final Authenticator AUTHENTICATOR = new DefaultAuthenticator(SENDER, PASSWORD);
    private static final String CHARSET_UTF_8 = "UTF-8";
    private static final String SSL_SMTP_PORT = "465";

    /**
     * 邮件初始化设置
     *
     * @param email {@link Email}
     * @throws EmailException
     */
    private static void init(Email email) throws EmailException {
        // 设置SMTP服务器
        email.setHostName(HOST_NAME);
        // 设置连接启用SSL及SLL端口
        email.setSSLOnConnect(true).setSslSmtpPort(SSL_SMTP_PORT);
        // 设置登入认证服务器的认证器
        email.setAuthenticator(AUTHENTICATOR);
        // 设置邮件编码
        email.setCharset(CHARSET_UTF_8);
        // 设置发件人
        email.setFrom(SENDER);
    }

    /**
     * 发送邮件
     *
     * @param email     {@link Email}
     * @param subject   邮件主题
     * @param msg       邮件内容
     * @param receivers 收件人（可以多个）
     * @throws EmailException
     */
    private static void send(Email email, String subject, String msg, String... receivers) throws EmailException {
        email.setSubject(subject).setMsg(msg);
        addTo(email, receivers).send();
    }

    /**
     * 添加收件人
     *
     * @param email     {@link Email}
     * @param receivers 收件人（可以多个）
     * @return {@link Email}
     * @throws EmailException 收件人为空
     */
    private static Email addTo(Email email, String... receivers) throws EmailException {
        List<String> receiverList = new ArrayList<>();
        for (String receiver : receivers) {
            if (!receiver.trim().isEmpty()) {
                receiverList.add(receiver);
                email.addTo(receiver, null);
            }
        }
        if (receiverList.size() == 0) {
            throw new EmailException("收件人地址无效！");
        }
        return email;
    }

    /**
     * 发送普通文本邮件
     *
     * @param subject   邮件主题
     * @param msg       邮件内容
     * @param receivers 收件人（可以多个）
     * @throws EmailException
     */
    public static void sendSimpleEmail(String subject, String msg, String... receivers) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        init(email);
        send(email, subject, msg, receivers);
    }

    /**
     * 发送带附件邮件
     *
     * @param subject   邮件主题
     * @param msg       邮件内容
     * @param filePaths 附件文件路径数组
     * @param receivers 收件人（可以多个）
     * @throws EmailException
     */
    public static void sendMultiPartEmail(String subject, String msg, String[] filePaths, String... receivers)
            throws EmailException {
        MultiPartEmail email = new MultiPartEmail();
        init(email);
        if (filePaths != null) {
            for (String filepath : filePaths) {
                email.attach(createLocalAttachment(filepath));
            }
        }
        send(email, subject, msg, receivers);
    }

    /**
     * 发送带附件邮件
     *
     * @param subject   邮件主题
     * @param msg       邮件内容
     * @param files     附件文件数组
     * @param receivers 收件人（可以多个）
     * @throws EmailException
     */
    public static void sendMultiPartEmail(String subject, String msg, File[] files, String... receivers)
            throws EmailException {
        MultiPartEmail email = new MultiPartEmail();
        init(email);
        if (files != null) {
            for (File file : files) {
                email.attach(file);
            }
        }
        send(email, subject, msg, receivers);
    }

    /**
     * 创建邮件附件
     *
     * @param description 附件描述
     * @param filename    附件文件名
     * @return {@link EmailAttachment}
     */
    private static EmailAttachment createAttachment(String description, String filename) {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(description);
        attachment.setName(filename);
        return attachment;
    }

    /**
     * 创建本地附件
     *
     * @param filepath 文件路径
     * @return {@link EmailAttachment}
     */
    public static EmailAttachment createLocalAttachment(String filepath) {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(filepath);
        return attachment;
    }

    /**
     * 创建本地附件
     *
     * @param filepath    文件路径
     * @param description 文件描述
     * @param filename    文件名
     * @return {@link EmailAttachment}
     */
    public static EmailAttachment createLocalAttachment(String filepath, String description, String filename) {
        EmailAttachment attachment = createAttachment(description, filename);
        attachment.setPath(filepath);
        return attachment;
    }

    /**
     * 创建网络附件
     *
     * @param fileUrl 文件URL地址
     * @return {@link EmailAttachment}
     */
    public static EmailAttachment createUrlAttachment(String fileUrl) {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(fileUrl);
        return attachment;
    }

    /**
     * 创建网络附件
     *
     * @param fileUrl     文件URL地址
     * @param description 文件描述
     * @param filename    文件名
     * @return {@link EmailAttachment}
     */
    public static EmailAttachment createUrlAttachment(String fileUrl, String description, String filename) {
        EmailAttachment attachment = createAttachment(description, filename);
        attachment.setPath(fileUrl);
        return attachment;
    }
}