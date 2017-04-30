package cn.blaze.service.impl;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.stereotype.Service;

import cn.blaze.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Override
	public String sendMail(String target, String subject, String content) {
		try {
			
			if(target==null||"".equals(target)){// 目标邮箱
				return "target email is empty";
			}
			
			//第一步：声明properties放信息对象
			Properties prop=new Properties();
			//设置连接哪台服务器
			prop.setProperty("mail.host", "smtp.126.com");
			//设置是否验证
			prop.setProperty("mail.smtp.auth", "true");
			//声明用户名和密码
			Authenticator auth=new Authenticator() {
				//返回用户名和密码的对象
				public PasswordAuthentication getPasswordAuthentication()
				{
					PasswordAuthentication pa=new PasswordAuthentication("tobyond", "Liu982195");
					return pa;
				}
			};
			//获得邮件对象
//			Session session=Session.getInstance(props, authenticator); // 不是使用同一个邮箱发送邮件时使用
			//获得邮件对象
			Session session=Session.getDefaultInstance(prop, auth);
			//设置session的调试模式
			session.setDebug(true);
			//第三步：声明信息
			MimeMessage mm=new MimeMessage(session);
			//第四步：设置发件人email
			Address from=new InternetAddress("tobyond@126.com");
			mm.setFrom(from);
			//第五步：设置收件人
			mm.setRecipient(RecipientType.TO, new InternetAddress(target));
			//第六步：设置主题
			mm.setSubject( MimeUtility.encodeText( subject,"gb2312","B"));
			mm.setContent(content, "text/plain;charset=utf-8");
			//第七步： 发送邮件
			Transport.send(mm);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

}
