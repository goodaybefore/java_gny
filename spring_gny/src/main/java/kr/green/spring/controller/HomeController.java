package kr.green.spring.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

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
		//System.out.println("/login:get");
		mv.setViewName("/member/login");
		return mv;
	}
	
	//login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO user) {
		//System.out.println("/login:post :" + user);
		MemberVO loginUser = memberService.login(user);
		//System.out.println("loginUser : "+loginUser);
		
		if(loginUser == null) {
			mv.setViewName("redirect:/login");
		}else {
			//loginUser는 DB에서 아이디 비번과 일치하는 회원 정보를 가져온 것이기 때문에
			//login화면에서 선택한 자동 로그인 체크 유무를 알 수 없다. but user는 알고있다.
			//화면에서 전달한 user에 있는 자동로그인체크유무를 loginUser에 설정한다.
			loginUser.setMe_auto_login(user.getMe_auto_login());
			
			mv.addObject("user", loginUser);
			mv.setViewName("redirect:/");
		}
		//로그인 성공하면 메인, 실패하면 로그인페이지
		
		return mv;
	}
	
	//signup
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv,  MemberVO user) {
		//System.out.println("/signup");
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
		if(memberService.signUp(user)) {
			mv.setViewName("redirect:/");
		}else {//회원가입에 실패하면 signUp으로 재등장
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	//logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(user != null) {
			//세션에 있는 유저 정보를 삭제
			request.getSession().removeAttribute("user");
			
			// + 로그인 유지를 해제
			//request 요청정보에 있는 쿠키들 중에서  loginCookie를 가져옴
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			//loginCookie정보가 있으면 (= 자동 로그인상태에서 로그아웃 하는 경우)
			if(cookie != null) {
				//쿠키 해제해주기
				cookie.setMaxAge(0);
				//
				//자동 로그인 해제를 위해 세션 아이디에 none을 저장하고 만료시간을 현재시간으로 설정
				user.setMe_session_id("none");
				user.setMe_session_limit(new Date());
				memberService.updateAutoLogin(user);
				
			}
			
		}
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value ="/idcheck")
	public String ajaxTest1(String id){//String xxx <- ajax의 data이름과 맞추면됨
		if(!memberService.idDuplicated(id))
			return "ok";
		else
			return "no";
	}
	
	//마이페이지
	//GET이 특별히 하는게 없는 경우, Get과 Post를 함께 써주기도 함.
	@RequestMapping(value = "/mypage")
	public ModelAndView mypageGet(ModelAndView mv, HttpServletRequest request, MemberVO input) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		MemberVO modUser = memberService.updateMember(input, user);
		//회원정보를 수정했다면
		if(modUser != null) {
			//Session Update
			//안해주면 회원정보 재확인 할 때 logout했다가 다시 login해서 확인해야함
			request.getSession().setAttribute("user", modUser);
		}
		mv.setViewName("/member/mypage");
		return mv;
	}
	
	
	//아이디,비밀번호 찾기
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ModelAndView memberFind(ModelAndView mv) {
		
		mv.setViewName("/member/find");
		return mv;
	}
	
	//아이디찾기
	@ResponseBody
	@RequestMapping(value = "/find/id", method = RequestMethod.POST)
	public String memberFindId(@RequestBody MemberVO member) {
		return memberService.findId(member);
	}
	
	//비밀번호찾기
	@ResponseBody
	@RequestMapping(value = "/find/pw", method = RequestMethod.POST)
	public String memberFindPw(@RequestBody MemberVO member) {
		//임시 비번 생성
		//생성된 임시 비번을 DB에 저장
		//이메일로 새 비번 전송
		//=>이걸 ServiceImp에 구현
		return memberService.findPW(member);
	}
	
	
}


//default 접근 제한자 : 나 + 같은 패키지 => vo 패키지에다가 public으로 만들어주기
class A{
	//여기에서 A 클래스 호출 가능
}