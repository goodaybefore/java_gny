package kr.green.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.vo.MemberVO;


//@Controller가 있어야 url을 분석하여 처리함
//실제 컨트롤러인지 이름만 컨트롤러인지 구분을 못함
//@ <- 어노테이션 이라고 읽음
@Controller
public class HomeController {
	
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
	System.out.println("/member/login");
	mv.setViewName("/member/login");
	return mv;
}

//login
@RequestMapping(value = "/login", method = RequestMethod.POST)
public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
	System.out.println("/login:post :" + member);
	mv.setViewName("/member/login");
	return mv;
}

}


//default 접근 제한자 : 나 + 같은 패키지 => vo 패키지에다가 public으로 만들어주기
class A{
	//여기에서 A 클래스 호출 가능
}