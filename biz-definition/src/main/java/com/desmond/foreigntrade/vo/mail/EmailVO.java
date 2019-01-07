package com.desmond.foreigntrade.vo.mail;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by presleyli on 2018/1/4.
 */
@Data
public class EmailVO implements Serializable {
    //~~~~~~配置
    @NotBlank
    private String host;
    @NotNull
    private int port;
    @NotBlank
    private String defaultEncoding;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    //~~~~~~内容
    private String sender; // 发送者邮箱
    private String from; // 发件人
    @NotNull
    private String[] toEmail; // 收件人
    private String[] cc; // 抄送人
    @NotBlank
    private String subject; // 邮件主题
    private String htmlText; //邮件内容
}
