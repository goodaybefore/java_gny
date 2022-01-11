package kr.green.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;


//@Controller가 있어야 url을 분석하여 처리함
//실제 컨트롤러인지 이름만 컨트롤러인지 구분을 못함
//@ <- 어노테이션 이라고 읽음
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	//url을 확인하는 곳(필수)
	//value : localhost:8080/패키지명 을 제외한 부분
	//method : 전달방식(GET/POST) => 보여지면 안되는 경우 OR 내용이 긴 경우 : POST
	//method 생략시 : 둘다 처리 가능
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//php : 서버정보, 화면정보, 데이터정보 등등을 php라는 하나의 파일에 다함께 관리 => 복잡함
	//spring : Controller 에서는 서버제어 / views 폴더 에서는 화면관련기능(jsp) / Model은 class파일에 담아서 주고받음 =>M(odel)V(iews)C(ontroller)
	//ModelAndView : 정보와 화면이 같이 있음!
	public ModelAndView home(ModelAndView mv) {
		//화면 파일명(여기서는 home). 확장자는 여기서 선택하는게 아니라 붙여주지 않음
		//확장자는 servlet-context.xml에서 설정함
		//단,  views 폴더에는 jsp만 가능
		//html을 화면으로 사용하려면 src/main/resources폴더에 넣어줘야함
		mv.setViewName("/main/home");//화면이름을 home으로 하겠다! => home.jsp or home.html 를 찾음 => jsp인지 html인지는 servlet-context.xml에 가야함
		
		//화면으로 데이터를 보낼 때 addObject를 사용
		//addObject("화면에서 사용할 이름", 보낼 데이터);
		mv.addObject("serverTime", "데이터"); 
		
		return mv;
	}
	
	//login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		System.out.println("/login:get");
		mv.setViewName("/member/login");
		return mv;
	}
	
	//login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		System.out.println("/login:post :" + member);
		MemberVO user = memberService.login(member);
		System.out.println(user);
		
		if(user==null) {
			mv.setViewName("redirect:/login");
		}else {
			mv.addObject("user", user);
			mv.setViewName("redirect:/");
		}
		//로그인 성공하면 메인, 실패하면 로그인페이지
		
		return mv;
	}
	
	//signup
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv,  MemberVO user) {
		System.out.println("/signup");
		mv.setViewName("/member/signup");
//		mv.addObject("user", user);//이거그대로 놔두면 signup눌러도 login한거처럼 header가 출력됨
		return mv;
	}
	//signup
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPOST(ModelAndView mv, MemberVO user) {
		//name에 일치하는 변수가 있으면 setter가 호출됨
		//MemberVo user = new MemberVO();
		//
		System.out.println("/signup:POST");
		System.out.println("회원가입으로 받은 정보 : "+user);
		if(memberService.signUp(user)) {
			mv.setViewName("redirect:/");
		}else {//회원가입에 실패하면 signUp으로 재등장
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	//logout
		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request) {
			System.out.println("/logout");
			//세션에 있는 유저 정보를 삭제
			request.getSession().removeAttribute("user");
			mv.setViewName("redirect:/");
			return mv;
		}
		
		
		
}


//default 접근 제한자 : 나 + 같은 패키지 => vo 패키지에다가 public으로 만들어주기
class A{
	//여기에서 A 클래스 호출 가능
}