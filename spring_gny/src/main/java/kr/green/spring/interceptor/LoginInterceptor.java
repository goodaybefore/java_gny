package kr.green.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		
		
		//mv.addObject()로 전달한 정보 중에 user라는 정보가 있는지 확인해서
		//user정보를 가져오는 코드
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");
	    
	    if(user != null) {
	    	//request라는 세션에 user정보를 추가
	    	//화면 또는 url로 가기전에 회원정보강 ㅣㅆ는지 확인하고 세션에 저장하는 interceptor
	        HttpSession session = request.getSession();
	        
	        //자동로그인이 체크되어있으면
	        if(user.getMe_auto_login() != null) {
	        	//서버에서 쿠키생성(이름 : loginCookie, 값 : session ID)
	        	Cookie cookie = new Cookie("loginCookie", session.getId());
	        	//쿠키 기본 경로 설정
	        	cookie.setPath("/");
	        	//쿠키 유지 시간 설정
	        	int day = 7;
	        	int session_limit_second = 60 * 60 * 24 * day;//60초 60초 24번 day일
	        	cookie.setMaxAge(session_limit_second);
	        	//서버에서 생성된 쿠키를 client로 보내기위해 쿠키를  response에 추가
	        	response.addCookie(cookie);
	        	//DB회원정보에 쿠키에 저장된 session_id와 session_유지시간을 update
	        	//day(7일)후의 날짜
	        	Date session_limit = new Date(System.currentTimeMillis()
	        			+ 1000 * session_limit_second);//현재시간을 밀리세컨드로 계산해서
	        	user.setMe_session_id(session.getId());
	        	user.setMe_session_limit(session_limit);
	        	memberService.updateAutoLogin(user);
	        	
	        }
	        
	        //여기서의 "user"와 jsp의 "user", 그리고 /login:post의 mv.Object("user",user)의 "user"와 보통 맞춤
	        session.setAttribute("user", user);
	        
	        
	    }
	}

}
