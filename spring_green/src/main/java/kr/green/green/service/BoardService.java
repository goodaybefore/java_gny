package kr.green.green.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoardList(Integer bd_num);

	void regBoard(BoardVO board, MemberVO user, List<MultipartFile> files);

	//로그인한 사용자와 
	BoardVO getBoard(Integer bd_num, MemberVO user);

	//게시글 수정
	void modifyBoard(BoardVO board, MemberVO user, List<MultipartFile> files2, Integer[] fileNums);
	//게시글 삭제
	void deleteBoard(MemberVO user, Integer bd_num, List<MultipartFile> files2);

	//detail에서 첨부 파일  목록 불러오기
	List<FileVO> getFileList(Integer bd_num);

	int getTotalCount(Criteria cri);


}
