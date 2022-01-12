package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.dao.BoardDAO;
import kr.green.green.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;

	@Override
	public List<BoardVO> getBoardList(String bd_type) {
		
		//boardDao.getBoard();//이거해줄필요없이 바로 리턴해줌ㄴ됨
		return boardDao.selectBoardList(bd_type);
	}

	@Override
	public BoardVO getBoardList(Integer bd_num) {
		//없는번호면 null을 리턴
		if(bd_num==null) return null;
		BoardVO board = boardDao.selectBoard(bd_num);
		return board;
	}
}
