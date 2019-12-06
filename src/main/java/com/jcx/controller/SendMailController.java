package com.jcx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.security.util.Password;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @Author JCX
 * @create 2019-12-05 10:21
 */
@Controller
public class SendMailController {
//    JavaMailSenderImpl是spring封装的邮件发送封装类，支持普通文本、附件、html。
//        JavaMailSenderImpl的几个属性设置说明如下：
//        Host：                      邮箱服务器主机。
//        Port：                      端口号。
//        Username：                  发件方账户。
//        Password：                  密码，qq邮箱的话此处设置16位授权码，不是邮箱密码，切记！
//        mail.smtp.auth:             认证机制开关，记得开启。
//        mail.smtp.starttls.enable： TLS通讯协议开关，连接qq的SMTP服务器，需使用此通讯协议。
//        mail.smtp.timeout ：        连接超时时间，单位毫秒。

    @Autowired
    private JavaMailSenderImpl mailSender;

    @RequestMapping("sendmail")
    @ResponseBody
    public String sendMail(MultipartFile annex){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
            messageHelper.setSubject("JCX's TestMail");
            messageHelper.setText("说我在这里~在这里~日复一日，平凡的世界里~");
            messageHelper.addAttachment(annex.getOriginalFilename(),annex);
            messageHelper.setSentDate(new Date());
            messageHelper.setFrom("m15809273850@163.com");
            messageHelper.setTo("1241563018@qq.com");
            mailSender.send(message);
            return "success";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
