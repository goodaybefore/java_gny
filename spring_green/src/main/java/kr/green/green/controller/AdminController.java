package kr.green.green.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;

@Controller
public class AdminController {

	@Autowired
	MemberService memberService;
	
	//회원관리
	@RequestMapping(value="/admin/member/modify", method=RequestMethod.GET)
	public ModelAndView boardMemberModify(HttpServletRequest request, ModelAndView mv) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(user == null || !user.getMe_authority().equals("슈퍼 관리자"))
			mv.setViewName("redirect:/");
		else {
			List<MemberVO> userList = memberService.getAllMember();
			mv.addObject("list", userList);
			mv.setViewName("/admin/member/modify");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="admin/update/authority", method = RequestMethod.POST)
	public String updateAuthority(@RequestBody MemberVO member, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		return memberService.updateAuthority(member, user);
	}
}
