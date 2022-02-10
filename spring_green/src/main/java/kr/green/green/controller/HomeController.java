package kr.green.green.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		}else {
			loginUser.setMe_auto_login(user.getMe_auto_login());//로그인되면 로그인된 유저한테 me_auto_login 넘겨줌
			mv.setViewName("redirect:/");
			mv.addObject("user",loginUser);
			
		}
		return mv;
	}
	
	//로그아웃get
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, HttpSession session){
		
		//세션에 있는 유저정보/자동로그인 정보를 삭제
		MemberVO user = (MemberVO)session.getAttribute("user");
		session.removeAttribute("user");
		
		user.setMe_session_limit(new Date());
		user.setMe_session_id("none");
		memberService.updateAutologin(user);
		
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
	//idcheck
	@ResponseBody
	@RequestMapping(value = "/idcheck", method=RequestMethod.GET)
	public String idcheck(String me_id){
		System.out.println(me_id);
		return memberService.idCheck(me_id);
	}
	
	
	//mypage
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(ModelAndView mv, HttpServletRequest request, MemberVO input){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		MemberVO modUser = memberService.updateMember(input, user);
		if(modUser != null) {
			request.getSession().setAttribute("user", input);
		}
		mv.setViewName("/member/mypage");
		return mv;
	}
	
	
	//find
	@RequestMapping(value = "/member/find", method=RequestMethod.GET)
	public ModelAndView findGet(ModelAndView mv){
		mv.setViewName("/member/find");
		return mv;
	}
	//id찾기
	@ResponseBody
	@RequestMapping(value = "/member/find/id", method=RequestMethod.POST)
	public String findIdPost(@RequestBody MemberVO member){
		return memberService.findId(member);
	}
	//pw찾기
	@ResponseBody
	@RequestMapping(value = "/member/find/pw", method=RequestMethod.POST)
	public String findPwPost(@RequestBody MemberVO member){
		
		return memberService.findPw(member);
	}
	
}
