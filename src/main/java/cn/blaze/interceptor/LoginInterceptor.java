package cn.blaze.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.blaze.domain.UserInfo;
import cn.blaze.utils.BlazeConstants;

/**
 * @ClassName LoginInterceptor
 * @Description 登录拦截器
 * @author LiuLei
 * @date 2017年5月6日 下午5:45:22
 */
public class LoginInterceptor implements HandlerInterceptor {
	private String[] excludeURLs=new String[]{"/user/login","/user/admin","user/userRegister","user/forgetPassword"}; //排除拦截的URL
	
	/*
	 * Handler执行之前调用这个方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获取请求的URL  
        String url = request.getRequestURI();
        for (int i = 0; i < excludeURLs.length; i++) {
			String exclude = excludeURLs[i];
			if (url.indexOf(exclude) >= 0) {
				return true;
			}
		}
        
        //获取Session  
        HttpSession session = request.getSession();  
        UserInfo user = (UserInfo)session.getAttribute(BlazeConstants.SESSION_SAVE_LOGIN);  
          
        if(user != null){  
            return true;  
        }  
        //不符合条件的，跳转到登录界面  
        request.getRequestDispatcher("/WEB-INF/views/index/login.jsp").forward(request, response);  
        return false;
	}

	/*
	 * Handler执行之后，ModelAndView返回之前调用这个方法 
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/*
	 * Handler执行之后调用这个方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
