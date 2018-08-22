package com.example.demo.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class HospitalInterceptor  implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(uri.endsWith("login")||uri.endsWith("testName")) {
			return true ;		
		}if(request.getSession().getAttribute("user")!=null) {
			return true ;
		}
		request.getSession().setAttribute("mes", "先登录");
		response.sendRedirect("/hospital/login");
		return false ;
	}
	
	

}
