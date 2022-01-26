package kr.green.green.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.green.green.service.CommentService;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

//ajax만 사용가능한 Controller
@RestController
public class CommentController {
	@Autowired
	CommentService commentService;
	
	//ajax에서 json으로 넘겨줄떄(post방식으로) 서버에서 받으려먼 @RequestBody 쓰기
	@RequestMapping(value = "/comment/insert", method=RequestMethod.POST)
	public boolean commentInsert(@RequestBody CommentVO comment, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		return commentService.insertComment(comment, user);
	}
	
	//comment list
	@RequestMapping(value = "/comment/list", method=RequestMethod.GET)
	public Map<String, Object> commentList(Integer page, Integer bd_num){
		Map<String, Object> map = new HashMap<String, Object>();
		List<CommentVO> list = new ArrayList<CommentVO>();
		CommentVO c = new CommentVO();
		list.add(c);
		map.put("list", list);
//		return commentService.selectAllComment(co_bd_num);
		return map;
	}
}
