package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.BoardVO;

public interface BoardDAO {

	void insertBoard(@Param("board")BoardVO board);

	List<BoardVO> getBoardList(@Param("type")String type);

	BoardVO getBoard(@Param("bd_num")Integer bd_num);

	void updateBoardIsdel(@Param("bd_num")Integer bd_num);

	//Param 뒤에오는 ""안의 내용은 맘대로 정하는거임 : mapper랑만 맞춰주면 되는듯
	void updateBoard(@Param("board")BoardVO dbBoard);

}