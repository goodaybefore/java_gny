package kr.green.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.spring.service.CommentService;
import kr.green.spring.vo.CommentVO;
import kr.green.spring.vo.MemberVO;

//@responsebody가 피룡없음 - restcontroller가 오면 모두 ajax로 변하기 때문
@RestController//Ajax만 올수있음....
public class CommentController {
	@Autowired
	CommentService commentService;
	@RequestMapping(value ="/comment/insert")
	//매개변수 안에 @RequestBody를 붙이는 이유? 
	public String commentInsert(@RequestBody CommentVO comment, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(commentService.insertComment(comment, user)) {
			return "true";
		}
		return "false";
	} 
}
