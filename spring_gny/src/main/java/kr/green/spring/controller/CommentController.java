package kr.green.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
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
	
	
	@RequestMapping(value ="/comment/list")
	//매개변수 안에 @RequestBody를 붙이는 이유?
	//페이지네이션을 하려면 댓글list보내줄때 pageMaker도 같이 넘겨줘야하기 때문에Map으롭 ㅏ꿔줌 => Map이라는 곳에 담앗다가 보내줄거임
	public Map<String, Object> commentList(Integer co_bd_num, Integer page){
		Criteria cri = new Criteria(page, 5);
		List<CommentVO> list=commentService.selectCommentList(co_bd_num, cri); 
		Map<String, Object> map = new HashMap<String, Object>();
		int totalCnt = commentService.selectTotalCnt(co_bd_num);
		//totalcount, 페이지네이션개수
		PageMaker pm = new PageMaker(totalCnt, 2, cri);
		
		map.put("pm", pm);
		map.put("list", list);
		return map;
	}
	
	
	@RequestMapping(value ="/comment/delete")
	//매개변수 안에 @RequestBody를 붙이는 이유? 
	public String commentDelete(Integer co_num, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		return commentService.deleteComment(co_num, user);
	}
	
}
