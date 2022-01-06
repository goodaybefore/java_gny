package kr.green.spring.service;

import kr.green.spring.vo.BoardVO;

public interface BoardService {
	
	//리턴타입 필요없음
	//이유 : 제목, 내용만 입력하기 때문에 회원가입에 비하면 뭐 리턴할게 없음
	void registerBoard(BoardVO board);

}
