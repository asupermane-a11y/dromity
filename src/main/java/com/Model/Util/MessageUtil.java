package com.Model.Util;

import  java.util.Properties;
import  javax.mail.*;
import  javax.mail.internet.*;

public  class  MessageUtil  {

    public  static void getMessage(String email, String message1,String label)  throws  MessagingException  {
        //  邮件配置
        String  host  =    "smtp-mail.outlook.com"  ;  //  Outlook  SMTP服务器地址
        final  String  user  =    "elric70@outlook.com"  ;  //  发件人邮箱账号
        final  String  password  =    "liu227993$"  ;  //  发件人邮箱密码

        //  创建邮件会话
        Properties  props  =  new  Properties();
        props.put(  "mail.smtp.host"  ,  host);
        props.put(  "mail.smtp.auth" ,    true  );
        props.put(  "mail.smtp.starttls.enable"  ,    true  );
        props.put(  "mail.smtp.port" ,    587  );

        Session  session  =  Session.getInstance(props,  new  javax.mail.Authenticator()  {
            protected  PasswordAuthentication  getPasswordAuthentication()  {
                return  new  PasswordAuthentication(user,  password);  //  发件人邮箱账号、邮箱密码
            }
        });

        try  {
            //  创建邮件对象
            Message  message  =  new  MimeMessage(session);
            message.setFrom(new  InternetAddress(user));  //  发件人邮箱
            message.setRecipients(Message.RecipientType.TO,  InternetAddress.parse(  email ));  //  收件人邮箱
            message.setSubject( "宿舍管理系统验证码" );  //  邮件主题
            message.setText( label+message1 );  //  邮件内容

            //  发送邮件
            Transport.send(message);

            System.out.println(  "发送成功" );
        }  catch  (MessagingException  e)  {
            throw  new  RuntimeException(e);
        }
    }
}