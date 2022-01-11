package kr.green.green.controller;

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
		System.out.println("DB test");
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

}
