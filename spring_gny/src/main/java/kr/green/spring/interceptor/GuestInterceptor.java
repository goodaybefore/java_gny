package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GuestInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {

		Object user = request.getSession().getAttribute("user");

		
		//로그인을 했으면
		if(user != null) {
			//메인화면으로
			response.sendRedirect(request.getContextPath()+"/");
			//가던 url로 가지 않고 위에 있는 url로 이동
			return false;
		}
		return true;
	}

}
