package kr.green.green.service;

import java.util.List;

import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	List<CommentVO> selectAllComment(Integer co_bd_num);

}
