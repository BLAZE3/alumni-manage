package cn.blaze.service;
/**
 * @ClassName MailService
 * @Description 邮件业务接口
 * @author LiuLei
 * @date 2017年4月28日 下午2:37:01
 */
public interface MailService {
	
	/**
	 * @Title sendMail
	 * @Description：发送邮件
	 * @param target 发送的目标邮箱
	 * @param subject 主题
	 * @param content 内容
	 * @return
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	String sendMail(String target, String subject, String content);
}
