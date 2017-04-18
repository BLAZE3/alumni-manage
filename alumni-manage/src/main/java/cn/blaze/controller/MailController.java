package cn.blaze.controller;

import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	@RequestMapping("sendMail")
	public void sendMail(HttpServletRequest request){
		
		try {
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
					PasswordAuthentication pa=new PasswordAuthentication("tobyond", "yxj911103+");
					return pa;
				}
			};
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
			mm.setRecipient(RecipientType.TO, new InternetAddress("840172843@qq.com"));
			//第六步：设置主题
			mm.setSubject("测试邮箱主题");
			
			mm.setContent("测试内容：这是邮箱的测试内容。", "text/plain;charset=utf-8");
			//第七步： 发送邮件
			Transport.send(mm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
