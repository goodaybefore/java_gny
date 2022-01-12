package kr.green.green.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GuestInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//request안에 세션이 있는데 그 안에 유저정보가 있는지 없는지 가죠오는 코드 
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		//유저정보가 있으면 넘어올 수 없도록 막아줌
		if(user != null) {
			response.sendRedirect(request.getContextPath()+"/");
			//원래 가려던 컨트롤러로 안가고 윗줄로  바로가버림
			return false;
		}
		return true;
	}//언제 동작할지를 servelt-context.xml에서 설정해줘야함

}
