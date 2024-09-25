package com.novel.NovelProject.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class loginIntercepter implements HandlerInterceptor{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id") == null) {
			request.setAttribute("msg", "로그인이 필요한 기능입니다. ");
			request.setAttribute("url", "/login");
			request.getRequestDispatcher("/WEB-INF/views/common/msgBox.jsp").forward(request, response);
			
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
