package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
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
	        //여기서의 "user"와 jsp의 "user", 그리고 /login:post의 mv.Object("user",user)의 "user"와 보통 맞춤
	        session.setAttribute("user", user);
	    }
	}

}
