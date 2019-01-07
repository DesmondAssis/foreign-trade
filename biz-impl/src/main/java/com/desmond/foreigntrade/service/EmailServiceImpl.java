package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.config.MailConfig;
import com.desmond.foreigntrade.vo.mail.EmailVO;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Map;
import java.util.Properties;


/**
 * Created by presleyli on 2017/11/3.
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private final String DEFAULT_CHARSET = "UTF-8";

    @Autowired
    private MailConfig mailConfig;

    @Resource
    private freemarker.template.Configuration freemarkerConfiguration;

    /**
     * MethodName：sendEmail
     * Description：根据邮件模板发送邮件
     *
     * @param from               发件人
     * @param toEmail            收件人
     * @param cc                 抄送人
     * @param subject            邮件主题
     * @param freemarkerFileName 邮件模板名称
     * @param modelMap           内容
     * @author presleyli
     * Date: Create in 2017/12/26 下午 02:31
     */
    @Override
    public boolean sendEmail(String from, String[] toEmail, String[] cc, String subject,
                          String freemarkerFileName, Map<String, Object> modelMap) {
        String htmlContent = geFreeMarkerTemplateContent(freemarkerFileName, modelMap);

        return sendEmail(from, toEmail, cc, subject, htmlContent);
    }

    /**
     * MethodName：sendEmail
     * Description：发送邮件
     *
     * @param from     发件人
     * @param toEmail  收件人
     * @param cc       抄送人
     * @param subject  邮件主题
     * @param htmlText 邮件内容
     * @author presleyli
     * Date: Create in 2017/12/26 下午 02:33
     */
    @Override
    public boolean sendEmail(String from, String[] toEmail, String[] cc, String subject, String htmlText) {
        EmailVO emailVO = getEmailVO();

        emailVO.setFrom(from);
        emailVO.setToEmail(toEmail);
        emailVO.setCc(cc);
        emailVO.setSubject(subject);
        emailVO.setHtmlText(htmlText);

        boolean isSuccuess = this.sendEmail(emailVO);

        return isSuccuess;
    }

    private EmailVO getEmailVO() {
        EmailVO emailVO = new EmailVO();
        emailVO.setHost(mailConfig.getHost());
        emailVO.setPort(mailConfig.getPort());
        emailVO.setDefaultEncoding(mailConfig.getDefaultEncoding());
        emailVO.setUsername(mailConfig.getUsername());
        emailVO.setPassword(mailConfig.getPassword());
        emailVO.setSender(mailConfig.getSender());

        return emailVO;
    }

    /**
     * 合成freemarker内容.
     *
     * @param freemarkerFileName freemarker文件名：在classpath:freemark/目录下
     * @param model              参数
     * @return
     */
    private String geFreeMarkerTemplateContent(String freemarkerFileName, Map<String, Object> model) {
        String result = "";
        try {
            Template template = freemarkerConfiguration.getTemplate(freemarkerFileName, DEFAULT_CHARSET);

            result = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return result;
    }

    public boolean sendEmail(EmailVO emailVO) {
        boolean isSuccess = false;

        try {
            JavaMailSender javaMailSender = getMailSender(emailVO);
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, false, "UTF-8");
            if(StringUtils.isBlank(emailVO.getFrom())) {
                emailVO.setFrom(emailVO.getSender());
            }

            helper.setFrom(emailVO.getFrom());
            helper.setTo(emailVO.getToEmail());
            String[] cc = emailVO.getCc();
            if(cc != null && cc.length > 0) {
                helper.setCc(cc);
            }

            helper.setSubject(MimeUtility.encodeText(emailVO.getSubject()));
            helper.setText(emailVO.getHtmlText(), true);
            javaMailSender.send(msg);
            isSuccess = true;
        } catch (Throwable var6) {
            log.error("发送邮件出错，" + var6.getMessage(), var6);
        }

        return isSuccess;
    }

    private static JavaMailSender getMailSender(EmailVO emailVO) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(emailVO.getHost());
        javaMailSender.setPort(emailVO.getPort());
        javaMailSender.setDefaultEncoding(emailVO.getDefaultEncoding());
        javaMailSender.setUsername(emailVO.getUsername());
        javaMailSender.setPassword(emailVO.getPassword());
//        javaMailSender.setJavaMailProperties(getProperties());
        return javaMailSender;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.socketFactory.port", "25");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.writetimeout", "50000");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.ssl.enable", "false");
        properties.setProperty("mail.smtp.timeout", "30000");
        properties.setProperty("mail.smtp.connectiontimeout", "50000");
        return properties;
    }
}
