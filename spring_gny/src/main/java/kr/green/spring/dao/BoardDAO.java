package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.LikesVO;

public interface BoardDAO {

	void insertBoard(@Param("board")BoardVO board);

	List<BoardVO> getBoardList(@Param("cri")Criteria cri);

	BoardVO getBoard(@Param("bd_num")Integer bd_num);

	void updateBoardIsdel(@Param("bd_num")Integer bd_num);

	//Param 뒤에오는 ""안의 내용은 맘대로 정하는거임 : mapper랑만 맞춰주면 되는듯
	void updateBoard(@Param("board")BoardVO dbBoard);

	void insertFile(@Param("file")FileVO fileVo);

	List<FileVO> selectFileList(@Param("bd_num")Integer bd_num);

	//첨부파일 삭제
	void deleteFile(@Param("fi_num")int fi_num);

	int selectCountBoard(@Param("cri")Criteria cri);
	
	//조회수 증가
	void updateViews(@Param("bd_num")Integer bd_num);

	LikesVO selectLikes(@Param("likes")LikesVO likes);

	void insertLikes(@Param("likes")LikesVO likes);

	void updateBoardLikes(@Param("likes")LikesVO likes);

	void updateLikes(@Param("likes")LikesVO likes);


}
