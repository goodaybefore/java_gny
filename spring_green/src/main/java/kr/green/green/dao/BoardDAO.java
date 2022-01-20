package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	//detail
	BoardVO selectBoard(@Param("bd_num")Integer bd_num);

	void insertBoard(@Param("board")BoardVO board);

	
	BoardVO getBaord(@Param("bd_num")Integer bd_num);

	void updateBoard(@Param("board")BoardVO board);

	void deleteBoard(@Param("bd_num")Integer bd_num);

	void insertFile(@Param("file")FileVO file);

	//detail에서 첨부파일 불러오기
	List<FileVO> selectFileList(@Param("bd_num")Integer bd_num);

	void deleteFile(@Param("file")FileVO tmp);

	int selectCntBoard(@Param("cri")Criteria cri);

	
}
