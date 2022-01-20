package kr.green.green.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.green.dao.BoardDAO;
import kr.green.green.utils.UploadFileUtils;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	//집
	String uploadPath = "C:\\Users\\tsj02\\Documents\\java_gny\\upload";
	//학원
//	String uploadPath = "E:\\upload";
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
	public void regBoard(BoardVO board, MemberVO user, List<MultipartFile> files) {
		
		//사실 Controller에서 넘겨줄 때 user는 null일수 없음..
		//근데 SErviceImp입장에서 확신을 할 수 없으니까 그냥 user==null도 넣어줌
		//regBoard들어가는 조건 자체가 user!=null이라 그럴린 없지만 그래도 if문으로 예외처리 한번 해주기
		if(board == null || user == null) return;
		
		if(board.getBd_title()==null || board.getBd_title().trim().length()==0) return;
		
		//게시글에 작성자의 id를 set해주기
		board.setBd_me_id(user.getMe_id());
		
		//게시글 추가 후
		boardDao.insertBoard(board);
		//첨부파일 등록
		uploadFile(files, board.getBd_num());
		
		
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
	public void modifyBoard(BoardVO board, MemberVO user, List<MultipartFile> files2, Integer[] fileNums) {
		//예외처리
		if(board==null || board.getBd_num() <= 0) return;
		
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
		
		
		
		//파일 수정
		
		//첨부파일을 삭제(수정화면에서는 x버튼 눌러서 취소한 첨부파일들)

		//게시글의 첨부파일들을 가져옴.(db에 저장되어있는 파일들의 fi_num들을 불러오기)
		List<FileVO> fileList = boardDao.selectFileList(board.getBd_num());
		//삭제리스트에서 삭제할 파일 (DB에 놔둘 파일)을 담을 List 설정... Q.꼭 List로 설정해야하나요?
		List<FileVO> remainFileList = new ArrayList<FileVO>();
		
		//가져온 첨부파일들 번호 중에서 fileNums와 일치하는 번호가 있으면 remainFileList에 추가 - 남겨야할 애들을 따로 빼놓음
		//fileList는 null 여부같은거 생각할 필요 없음 => 왜?? fileNums에 뭔가 들어있다는건 원본 첨부파일에 뭔가가 들어있다는 말
		//1.유지해야할 첨부파일(fileNums) 이 있는 경우
		if(fileNums != null && fileNums.length !=0) {//fileNums가 비어있지 않다는 가정하에 작업 시작
			for(FileVO tmpList : fileList) {
				for(Integer tmpNum : fileNums) {
					if(tmpList.getFi_num() == tmpNum) {
						remainFileList.add(tmpList);
					}
				}
			}
			//게시글의 전체 첨부파일 중, 유지해야할 첨부파일을 제외한 첨부파일을 만든다.
			
			fileList.removeAll(remainFileList);
		}
		
		//실제서버에서 삭제처리
		deleteFile(fileList);
		
		
		//새로 추가한 첨부파일을 업로드
		uploadFile(files2, board.getBd_num());
		
	}

	//게시글 삭제
	@Override
	public void deleteBoard(MemberVO user, Integer bd_num, List<MultipartFile> files2) {
		if(bd_num == null || bd_num <= 0) return ;
		
		BoardVO board = boardDao.getBaord(bd_num);
		
		
		if(board ==null) return;
		//board.getBd_me_id() !=null의 경우, 아이디는 db에서 primarykey이기 때문에 누락될 일이 없으나
		//더 안정적인 코드를 만드는 연습을 하고싶다면 삽입해주기
		if(user != null && 
				board.getBd_me_id() !=null && board.getBd_me_id().equals(user.getMe_id())) {
			boardDao.deleteBoard(bd_num);
			///첨부파일 삭제하기 위해서 해당 게시글과 일치하는 첨부파일들을 가져와야함.
			List<FileVO> fileList = boardDao.selectFileList(bd_num);
			deleteFile(fileList);
			
		}
			
		
		
	}

	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num == null || bd_num <= 0) return null;
		return boardDao.selectFileList(bd_num);
	}
	
	
	private void uploadFile(List<MultipartFile> files, int bd_num) {
		if(files == null || files.size()==0) return;
		for(MultipartFile tmpFile : files) {
			if(tmpFile !=null && tmpFile.getOriginalFilename().length()!=0) {//실제로 파일도 존재하고, 파일 이름도 있어야 등록가능
				try {
					//다운로드 옵션? 설정
					String path = UploadFileUtils.uploadFile(uploadPath, tmpFile.getOriginalFilename(),tmpFile.getBytes());
					/* FileVO는
					 * public FileVO(String fi_ori_name, String fi_name, int fi_bd_num) {
					   this.fi_ori_name = fi_ori_name;
					   this.fi_name = fi_name;
					   this.fi_bd_num = fi_bd_num; 참고
					 * */
					FileVO file = new FileVO(tmpFile.getOriginalFilename(), path, bd_num);
					/* 저 생성자 안 만들었을 떄
					 * FileVO file = new FileVO();
					 * file.setFi_bd_num(board.getBd_num());
					 * file.serFi_name(path);
					 * file.setFi_ori_name(tmpFile.getOriginalFilename());
					 * */
					//파일 넣어라고 일시킴
					boardDao.insertFile(file);
					System.out.println("regBoard : file : "+file);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	private void deleteFile(List<FileVO> fileList) {
		//실제 서버에서 삭제 후 DB에서도 삭제 처리
		if(fileList != null && fileList.size() != 0) {
			for(FileVO tmp : fileList) {
				String fileName = tmp.getFi_name().replace("/", File.separator);//이전 수업시간에는 얘가 길어서 나눠썼음. 이게 가벼운 버전
				File f = new File(uploadPath + fileName);
				//저장된 리스트에 있는 첨부파일들을 DB에서 삭제 처리
				boardDao.deleteFile(tmp);
				if(f.exists()) {
					f.delete();
					
				}
			}
		}
	}
}
