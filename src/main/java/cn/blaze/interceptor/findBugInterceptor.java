package cn.blaze.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.blaze.controller.UserController;
import cn.blaze.domain.UserInfo;
import cn.blaze.utils.BlazeConstants;

/**
 * @ClassName findBugInterceptor
 * @Description 查找登录用户信息为空的BUG
 * @author LiuLei
 * @date 2017年5月17日 下午7:31:04
 */
public class findBugInterceptor extends HandlerInterceptorAdapter {
	private Logger _logger = Logger.getLogger(findBugInterceptor.class);
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			_logger.info("*****************************");
			_logger.info("*****************************");
			_logger.info("*****************************");
			_logger.info("*****************************");
			String methodName = method.getName();
			_logger.info("调用的方法名是"+methodName);
			UserInfo user = (UserInfo)request.getSession().getAttribute(BlazeConstants.SESSION_SAVE_LOGIN);
			_logger.info(user!=null?user.toString():"user is null!!!");
			_logger.info("*****************************");
			_logger.info("*****************************");
			_logger.info("*****************************");
			_logger.info("*****************************");
			return true;
		} else {
			_logger.info("*****************************");
			_logger.info("*****************************");
			_logger.info("*****************************");
			_logger.info("*****************************");
			StringBuffer requestURL = request.getRequestURL();
			_logger.info("requestURL==>"+requestURL);
			_logger.info("*****************************");
			_logger.info("*****************************");
			_logger.info("*****************************");
			_logger.info("*****************************");
			return super.preHandle(request, response, handler);
		}
	}
}
