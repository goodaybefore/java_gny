package kr.green.green.service;

import java.util.List;

import kr.green.green.vo.BoardVO;
import kr.green.green.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(String bd_type);

	BoardVO getBoardList(Integer bd_num);

	void regBoard(BoardVO board, MemberVO user);

	//로그인한 사용자와 
	BoardVO getBoard(Integer bd_num, MemberVO user);

	//게시글 수정
	void modifyBoard(BoardVO board, MemberVO user);


}
