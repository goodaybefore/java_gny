package kr.green.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

//게시글 url을 담당하는 커느롤러. /board/xxx을 담당
//Controller는 @Controller를 꼭 추가해줘야함.
@Controller
@RequestMapping(value="/board")///board로 시작하는 모든 url을 이 컨트롤러로 보내라~ 는 말
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//method=GET이런게 없음. 왜? 게시글 보는 화면에서는 데이터를 전송할 일이 없기 때문...! 그래서 GET은 ㄸ따로 안적어도줘되니껜 ㅇㅅㅇ
	@RequestMapping(value="/list")//앞에 @RequestMapping(value="/board")를 안해줬으면 value="/board/list"로 작성해줘야함 
	public ModelAndView boardList(ModelAndView mv) {
		mv.setViewName("/board/list");
		return mv;
	}
	
	//register(글쓰기)
	@RequestMapping(value="/register", method=RequestMethod.GET)//앞에 @RequestMapping(value="/board")를 안해줬으면 value="/board/list"로 작성해줘야함 
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	//register(글쓰기)
		@RequestMapping(value="/register", method=RequestMethod.POST)//앞에 @RequestMapping(value="/board")를 안해줬으면 value="/board/list"로 작성해줘야함 
		public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
			
			//중요!!!!!!!!!!!!!!!!!!!!!!!!!
			//getAttribute의 리턴타입은 Object임.그래서 request.앞에다가 (MemberVO)라고 해서 어떤 클래스의 객체인지 명시해줘야함...!
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			//게시판 작성자를 현재 로그인해있는 사람의 id로 넣기
			board.setBd_me_id(user.getMe_id());
			board.setBd_type("일반");
			//서비스한테 일시키기
			mv.setViewName("/board/register");
			boardService.registerBoard(board);
			System.out.println("board : "+board);
			return mv;
		}
}
