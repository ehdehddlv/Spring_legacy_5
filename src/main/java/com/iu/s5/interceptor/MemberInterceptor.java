package com.iu.s5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s5.member.MemberVO;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = false;
		
		Object obj = (MemberVO)request.getSession().getAttribute("member");
		if(obj != null) {
			check = true;
			System.out.println("로그인 되었음");
		}else {
			System.out.println("로그인 안돼있음");
			response.sendRedirect("./memberLogin");
		}
		
		return check;
	}
}
