package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//HttpSession session = request.getSession();
		//Object user = session.getAttribute("user");
		//아래 한줄로 대체가능. 세션에 있는 회원 정보를 가져옴. 세션에 user로 저장했기 때문에 user를 가져옴
		Object user = request.getSession().getAttribute("user");//회원정보 가져오기
		//MemberVO로 변환 안하는 이유 => 회원 정보를 이용해서 무슨 작업을 하는게 아니라 있다/없다만 확인하기 때문에
		
		//로그인을 안했으면(=세션에 회원 정보가 없으면)
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			//가던 url로 가지 않고 위에 있는 url로 이동
			return false;
		}
		return true;
	}

}
