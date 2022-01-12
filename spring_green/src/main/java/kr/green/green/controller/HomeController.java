package kr.green.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;


@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/")
	public ModelAndView openTilesView(ModelAndView mv) throws Exception {
		mv.setViewName("/main/home");
		//연동 확인 후 지울 코드
//		MemberVO user = memberService.testSQL("abc123");
//		System.out.println(user);
		
		return mv;
	}
	
	
	//회원가입 페이지
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv){
		mv.setViewName("/member/signup");
		return mv;
	}
	
	//회원가입
	@RequestMapping(value = "/signup", method=RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user){
		System.out.println("signup:POST");
//		System.out.println("회원가입으로 받은 정보 : "+user);
		boolean isSignup = memberService.signup(user);
		if(isSignup) {
			mv.setViewName("redirect:/signup");
		}else {
			mv.setViewName("redirect:/");
		}
		
		return mv;
	}
	
	//로그인
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv){
		mv.setViewName("/member/login");
		return mv;
	}
	
	//로그인post
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO user){
		//로그인 됐는지 안됐는지
		MemberVO loginUser= memberService.login(user);
		
		if(loginUser==null) {
			mv.setViewName("redirect:/login");
			
//			mv.setViewName("member/login");//은 안되나범
		}else {
			mv.setViewName("redirect:/");
			//인터셉터한테 정보 주는 역할
			mv.addObject("user",loginUser);
			
		}
		return mv;
	}
	
	//로그아웃get
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request){
		System.out.println("/logout");
		//세션에 있는 유저정보를 삭제
		request.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
}
