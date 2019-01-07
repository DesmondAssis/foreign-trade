package com.desmond.foreigntrade.service;

import java.util.Map;

/**
 * ClassName：EmailService
 * PackageName：com.links86.core.service
 * Description：邮件服务
 *
 * @author zhiyong.li
 * Date：Create in 2017/12/26 下午 02:30
 */
public interface EmailService {

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
     * @author zhiyong.li
     * Date: Create in 2017/12/26 下午 02:31
     */
    boolean sendEmail(String from, String[] toEmail, String[] cc, String subject,
                      String freemarkerFileName, Map<String, Object> modelMap);

    /**
     * MethodName：sendEmail
     * Description：发送邮件
     *
     * @param from     发件人
     * @param toEmail  收件人
     * @param cc       抄送人
     * @param subject  邮件主题
     * @param htmlText 邮件内容
     * @author zhiyong.li
     * Date: Create in 2017/12/26 下午 02:33
     */
    boolean sendEmail(String from, String[] toEmail, String[] cc, String subject, String htmlText);
}
