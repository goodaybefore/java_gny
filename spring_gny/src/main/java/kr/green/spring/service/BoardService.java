package kr.green.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

public interface BoardService {
	
	//리턴타입 필요없음
	//이유 : 제목, 내용만 입력하기 때문에 회원가입에 비하면 뭐 리턴할게 없음
	void registerBoard(BoardVO board, List<MultipartFile> files) throws Exception;

	List<BoardVO> getBoardList(String string, Criteria cri);

	BoardVO getBoard(Integer bd_num);
	
	void deleteBoard(Integer bd_num, MemberVO user);

	BoardVO getBoard(Integer bd_num, MemberVO user);

	void updateBoard(BoardVO board, List<MultipartFile> files, Integer[] fileNums);

	List<FileVO> getFileList(Integer bd_num);

	int getTotalCount(String type);

}
