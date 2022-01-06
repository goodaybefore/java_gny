package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;

	@Override
	public void registerBoard(BoardVO board) {
		if(board == null||board.getBd_title()==null||board.getBd_contents()==null
				||board.getBd_me_id()==null)return;//걍리턴.. 등록할 게시글이 없으니까
		
		//다오야일해라
		//다오한테 일시킬땐 쿼리문이 예상가도록 해야함
		boardDao.insertBoard(board);
		
	}
}
