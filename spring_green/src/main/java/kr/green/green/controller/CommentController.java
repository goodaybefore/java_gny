package kr.green.green.controller;

import java.util.List;

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
	
	
}
