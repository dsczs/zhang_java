package demo;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/16.
 */
public class Mail {
    /**
     * Simple spring framework send mail test
     */
    @Test
    public void t1() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(587);
        mailSender.setUsername("370637594@qq.com");
        mailSender.setPassword("hadoop123");//授权码

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("156845024@qq.com");
        mail.setFrom("370637594@qq.com");
        mail.setSubject("test mail");
        mail.setText("test mail content!");
        mailSender.send(mail);
        System.out.println("success");
    }

    /**
     * 简单html邮件
     */
    @Test
    public void t2() throws MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(587);
        mailSender.setUsername("370637594@qq.com");
        mailSender.setPassword("asd123456");//授权码

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);//true用来打开multipart模式，添加图片或附件

        helper.setTo("156845024@qq.com");
        helper.setFrom("370637594@qq.com");
        helper.setSubject("test mail");
        helper.setText("<html><head></head><body>" + "<h1>hello!!spring html Mail</h1>" + "</body></html>", true);
        mailSender.send(mail);
        System.out.println("success");
    }

    /**
     * 带图片的html邮件
     */
    @Test
    public void t3() throws MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(587);
        mailSender.setUsername("370637594@qq.com");
        mailSender.setPassword("asd123456");//授权码
        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);//true用来打开multipart模式，添加图片或附件

        helper.setTo("156845024@qq.com");
        helper.setFrom("370637594@qq.com");
        helper.setSubject("test mail");
        helper.setText("<html><head></head><body>" + "<img src='cid:image' />" + "</body></html>", true);
        FileSystemResource image = new FileSystemResource(new File("E:/images/abc.jpg"));
        helper.addInline("image", image);
        mailSender.send(mail);
        System.out.println("success");
    }

    /**
     * 带附件的html邮件
     */
    @Test
    public void t4() throws MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(587);
        mailSender.setUsername("370637594@qq.com");
        mailSender.setPassword("asd123456");//授权码

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);//true用来打开multipart模式，添加图片或附件

        helper.setTo("156845024@qq.com");
        helper.setFrom("370637594@qq.com");
        helper.setSubject("test mail");
        helper.setText("<html><head></head><body>" + "<h1>hello!!spring html Mail</h1>" + "</body></html>", true);
        FileSystemResource image = new FileSystemResource(new File("E:/images/abc.jpg"));
        helper.addAttachment("abc.jpg", image);
        mailSender.send(mail);
        System.out.println("success");
    }

    /**
     * freemarker模板邮件
     */
    @Test
    public void t5() throws MessagingException {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(587);
        mailSender.setPassword("asd123456");//授权码
        mailSender.setUsername("370637594@qq.com");
        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);//true用来打开multipart模式，添加图片或附件

        helper.setTo("156845024@qq.com");
        helper.setFrom("370637594@qq.com");
        helper.setSubject("test mail");
        Map<String, String> data = new HashMap<String, String>();
        data.put("username", "guess");
        //        String text = new FreemarkerParser().toHtmlString("test.ftl", data);

        //        helper.setText(text, true);
        FileSystemResource image = new FileSystemResource(new File("E:/images/abc.jpg"));
        helper.addInline("image", image);
        mailSender.send(mail);
        System.out.println("success");
    }
}
