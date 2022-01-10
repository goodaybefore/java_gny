package kr.green.spring.controller;

import java.util.List;

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
		//등록된 모든 게시글을 확인
		List<BoardVO> list = boardService.getBoardList("일반");
		mv.addObject("list", list);
		System.out.println("list" + list);
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
	@RequestMapping(value="/register", method=RequestMethod.POST) 
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		//중요!!!!!!!!!!!!!!!!!!!!!!!!!
		//getAttribute의 리턴타입은 Object임.그래서 request.앞에다가 (MemberVO)라고 해서 어떤 클래스의 객체인지 명시해줘야함...!
		MemberVO user = (MemberVO)(request.getSession().getAttribute("user"));
		//게시판 작성자를 현재 로그인해있는 사람의 id로 넣기
		board.setBd_me_id(user.getMe_id());
		board.setBd_type("일반");
		//서비스한테 일시키기
		mv.setViewName("/board/register");
		//추가
		mv.setViewName("redirect:/board/list");
		boardService.registerBoard(board);
		System.out.println("board : "+board);
		return mv;
	}
	@RequestMapping(value="/detail") 
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
		mv.setViewName("/board/detail");
		//게시글 번호 확인
//		System.out.println("게시글 번호 : "+bd_num);
		BoardVO board = boardService.getBoard(bd_num);
		//화면에 게시글 전달
		mv.addObject("board",board);
		return mv;
	}
	
	//게시글 삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET) 
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		//삭제처리
		//게시글 번호 확인
//		System.out.println("bd_num"+bd_num);
		
		//로그인한 유저 정보를 확인
//		getAttribute는 반환값이 Object라서 앞에 반환값을()로 설정해줘야함 
		MemberVO user = (MemberVO)(request.getSession().getAttribute("user"));
//		System.out.println("user id : "+user.getMe_id());
		//Service에 게시글 번호와 로그인한 유저 정보를 전달
		
		boardService.deleteBoard(bd_num, user);
		//게시글 삭제
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	//게시글 수정
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//게시글 = 서비스.게시글가져오기(번호, 로그인 정보)
		BoardVO board = boardService.getBoard(bd_num, user);
		
		//게시글이 없으면
			//1. 번호가 잘못된경우
			//2. 본인이 작성자가 아닐경우
		if(board==null) {
			mv.setViewName("redirect:/board/list");
		}else {
			mv.addObject("board", board);
			mv.setViewName("/board/modify");
		}
		
		//서비스에게 변호를 알려주면서 게시글을 가져오라고 시킴
		//서비스가 보내준 게시글의 작성자와 로그인한 회원 아이디가 일치하는지 확인
		//컨트롤러가 서비스가 보내준 게시글 정보를 가지고 추가확인
		
		mv.setViewName("/board/modify");
		return mv;
	}
	
	
	//게시글 수정
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board) {
		//화면에서 수정한 게시글 정보가 넘어오는지 확인
		System.out.println("수정한 게시글 정보 : "+board);
		
		//서비스에게 게시글 정보를 주면서 업ㅌ데이트 하라고 시킴
		//서비스.게시글업데이트(게시글정보)
		boardService.updateBoard(board);
		//추가
		mv.addObject("bd_num", board.getBd_num());
		mv.setViewName("redirect:/board/detail");
		return mv;
	}
	
}
