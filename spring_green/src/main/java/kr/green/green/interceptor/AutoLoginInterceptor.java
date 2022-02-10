package kr.green.green.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		//세션정보 가져오기
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		//자롱 로그인 해야하는 경우 : 로그인 상태가 아닐 때 + 이전에 로그인 유지를 체크하지 않은경우
		//사이트 접속했는데 로그인이 안되어있고 + 이전에 로그인유지를 체크했으면 자동로그인 시도
		if(user == null) {
			//request안에 담겨져있는 쿠키정보를 가져옴(MemberInterceptro에서 지정한 이름으로)
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			
			
			
			//쿠키는 시간이 지나면 없어짐(null이 됨)
			//그래서 쿠키가 존재한다는 조건 하에 작업시작
			if(cookie != null) {
				//쿠키에 있는 value를 가져옴
				// => 쿠키안에 들어있는게 무슨무슨 값인데ㅠㅠ?
				String me_session_id = cookie.getValue();
				
				//쿠키에 저장된 세션아이디와 일치하는 회원 정보를 가져옴
				user = memberService.selectMemberBySessionId(me_session_id);			}
			
				if(user != null) {
					session.setAttribute("user", user);
				}
		}		
		return true;
	}

}
