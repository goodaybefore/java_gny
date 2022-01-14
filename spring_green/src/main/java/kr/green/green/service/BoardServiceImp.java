package kr.green.green.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.dao.BoardDAO;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.MemberVO;

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

	@Override
	public void regBoard(BoardVO board, MemberVO user) {
		
		//사실 Controller에서 넘겨줄 때 user는 null일수 없음..
		//근데 SErviceImp입장에서 확신을 할 수 없으니까 그냥 user==null도 넣어줌
		//regBoard들어가는 조건 자체가 user!=null이라 그럴린 없지만 그래도 if문으로 예외처리 한번 해주기
		if(board == null || user == null) return;
		
		if(board.getBd_title()==null || board.getBd_title().trim().length()==0) return;
		
		//게시글에 작성자의 id를 set해주기
		board.setBd_me_id(user.getMe_id());
		
		boardDao.insertBoard(board);
		
	}

	//modify 수정 페이지
	@Override
	public BoardVO getBoard(Integer bd_num, MemberVO user) {
		BoardVO board = boardDao.getBaord(bd_num);
		if(bd_num == null) return null;
		if(user == null) return null;
		//bd_num의 board를 가져온다
		if(!board.getBd_me_id().equals(user.getMe_id())) return null;
		
		return board;
	}

	//modify 수정 기능
	@Override
	public void modifyBoard(BoardVO board, MemberVO user) {
		//예외처리
		if(board==null || user==null || board.getBd_num() <= 0) return;
		
		//bd_num에 해당하는db게시글 불러오기
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		//예외처리 : db에 게시글이 없을 때, dbBoard의 id 와 session의 id가 다를 때
		
		boardDao.updateBoard(dbBoard);
		
		if(dbBoard==null) return;
		if(!dbBoard.getBd_me_id().equals(user.getMe_id())) return;
		
		
		
		System.out.println("dbBoard : "+dbBoard);
		System.out.println("board : "+board);
//		dbBoard.setBd_title(board.getBd_title());
//		dbBoard.setBd_contents(board.getBd_contents());
//		
//		//현재시간 Update
//		dbBoard.setBd_up_date(new Date());
//		
//		//받ㅇ아온정보를 sql에서 update
		boardDao.updateBoard(board);
	}

	//게시글 삭제
	@Override
	public void deleteBoard(MemberVO user, Integer bd_num) {
		if(bd_num == null || bd_num <= 0) return ;
		
		BoardVO board = boardDao.getBaord(bd_num);
		if(board ==null) return;
		//board.getBd_me_id() !=null의 경우, 아이디는 db에서 primarykey이기 때문에 누락될 일이 없으나
		//									더 안정적인 코드를 만드는 연습을 하고싶다면 삽입해주기
		if(user != null && 
				board.getBd_me_id() !=null && board.getBd_me_id().equals(user.getMe_id()))
			boardDao.deleteBoard(bd_num);
		
		
		System.out.println("삭제완료되었습니다");
	}
}
