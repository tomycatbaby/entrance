package com.entrance.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginFilter implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
		//获取请求URL
		String url = request.getRequestURI();
		System.out.println(url);
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		if(username!=null){
			return;
		}
		request.getRequestDispatcher("/maven/index.html").forward(request, response);
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
