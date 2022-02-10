package kr.green.green.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;

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
	    ModelMap modelMap = modelAndView.getModelMap();
	    //User였던걸 MemberVO로 바꿔주기
	    MemberVO user = (MemberVO)modelMap.get("user");
	    
	    //가져온 회원정보가 있으면 세션에 저장
	    if(user != null) {
	        HttpSession session = request.getSession();
	        
	        if(user.getMe_auto_login() != null) {
	        	//쿠키를 생성(이름 : loginCookie, 값 : session ID)
	        	Cookie cookie = new Cookie("loginCookie", session.getId());
	        	
	        	//쿠키 기본 경로 : home화면?
	        	//쿠키 기본경로 설정 안하면 어떻게 되는거지?
	        	//다른 경로로 설정하면 어떻게 되는지?
	        	cookie.setPath("/");
	        	
	        	//쿠키 유지 시간
	        	int day = 7;
	        	int session_limit_second = 60 * 60 * 24 * day; //초계산
	        	cookie.setMaxAge(session_limit_second);//쿠키 유지시간 set
	        	
	        	//서버에서 생성된 쿠키를 클라이언트로 보내기위해 쿠키를 response에 추가
	        	response.addCookie(cookie);
	        	
	        	//day(7)일 후의 날짜를 밀리세컨드로 계산
	        	Date session_limit = new Date(System.currentTimeMillis()
	        			+ 1000 * session_limit_second);
	        	
	        	//DB회원 정보에 쿠키에 저장된 session_id와 session_limit(세션유지시간)을 update set
	        	user.setMe_session_id(session.getId());
	        	user.setMe_session_limit(session_limit);
	        	memberService.updateAutologin(user);
	        	
	        }
	        
	        
	        session.setAttribute("user", user);
	    }
	}

}
