package kr.green.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//list출력
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView BoardlistGet(ModelAndView mv){
		
		//게시글을 가져오기위한 List
		List<BoardVO> list = boardService.getBoardList("일반");
		
		//list를 넘겨주기
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		//mv.addObject("list",list).setViewName("/board/list");로 한줄로 해도됨
		return mv;
	}
	//게시글 상세(detail)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView BoardDetailPost(ModelAndView mv, Integer bd_num) {
		BoardVO  thisBoard = boardService.getBoardList(bd_num);
		mv.addObject("thisBoard", thisBoard);
		mv.setViewName("/board/detail");
		return mv;
	}
	//게시글 등록(register)
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView BoardRegisterPost(ModelAndView mv) {
		return mv;
	}
}
