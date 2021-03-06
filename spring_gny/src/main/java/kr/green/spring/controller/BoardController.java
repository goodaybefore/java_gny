package kr.green.spring.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.LikesVO;
import kr.green.spring.vo.MemberVO;

//게시글 url을 담당하는 커느롤러. /board/xxx을 담당
//Controller는 @Controller를 꼭 추가해줘야함.
@Controller
@RequestMapping(value="/board")///board로 시작하는 모든 url을 이 컨트롤러로 보내라~ 는 말
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//method=GET이런게 없음. 왜? 게시글 보는 화면에서는 데이터를 전송할 일이 없기 때문...! 그래서 GET은 ㄸ따로 안적어도줘되니껜 ㅇㅅㅇ
	@RequestMapping(value="/list")//앞에 @RequestMapping(value="/board")를 안해줬으면 value="/board/list"로 작성해줘야함 
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
//		System.out.println("cri"+ cri);//page=1, pagination=10
		cri.setPerPageNum(5);
		//등록된 게시글 중 현재 페이지와 일치하는 게시글을 가져옴
		//cri를 매개변수로 넣어주는 이유 :  일반게시글 중에 현재페이지와 일치하는 게시글 가져왕.
		List<BoardVO> list = boardService.getBoardList(cri);
		
		//페이지메이커를 만들어서 화면에 전달
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		
		mv.addObject("pm", pm);
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	//register(글쓰기)
	@RequestMapping(value="/register", method=RequestMethod.GET)//앞에 @RequestMapping(value="/board")를 안해줬으면 value="/board/list"로 작성해줘야함 
	public ModelAndView boardRegisterGet(ModelAndView mv, Integer bd_ori_num, String bd_type) {
		mv.addObject("bd_ori_num", bd_ori_num);
		mv.addObject("bd_type", bd_type);
		mv.setViewName("/board/register");
		return mv;
	}
	//register(글쓰기)
	@RequestMapping(value="/register", method=RequestMethod.POST) 
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request,
			List<MultipartFile> files2) throws Exception  {
		//중요!!!!!!!!!!!!!!!!!!!!!!!!!
		//getAttribute의 리턴타입은 Object임.그래서 request.앞에다가 (MemberVO)라고 해서 어떤 클래스의 객체인지 명시해줘야함...!
		MemberVO user = (MemberVO)(request.getSession().getAttribute("user"));
		//게시판 작성자를 현재 로그인해있는 사람의 id로 넣기
		board.setBd_me_id(user.getMe_id());
		
		
		//서비스한테 일시키기
		mv.setViewName("/board/register");
		
		//관리자 이름들을 list에 넣기
		List<String> authorityAdmin = new ArrayList<String>();
		authorityAdmin.add("관리자");
		authorityAdmin.add("슈퍼 관리자");
		//회원의 권한이 관리자or슈퍼관리자가 아닐 경우
		if(board.getBd_type().equals("공지") &&
				authorityAdmin.indexOf(user.getMe_authority()) < 0) {
			mv.addObject("type", "공지");
			mv.setViewName("redirect:/board/list");
		}else {
			boardService.registerBoard(board, files2);
			//바로 공지사항 글을 작성하면 작성 후 바로 공지사항 화면으로 갈 수 있게 해주는듯...!
			mv.addObject("type", board.getBd_type());
			//게시글 등록 후 첨부파일 등록
			mv.setViewName("redirect:/board/list");
		}
		
		
		
		System.out.println("reg때 files"+files2);
		
		System.out.println("전달받은 board : "+board);
		return mv;
	}
	@RequestMapping(value="/detail") 
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
		mv.setViewName("/board/detail");
		//게시글 가져오기
		BoardVO board = boardService.getBoard(bd_num);
		//게시글 전달
		mv.addObject("board",board);
		
		//파일가져오기
		List<FileVO> files = boardService.getFileList(bd_num);
		
		//조회수 증가시키기
		boardService.updateViews(bd_num);
		//파일 전달
		mv.addObject("files", files);
		
		return mv;
	}
	
	//게시글 삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET) 
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer bd_num, HttpServletRequest request,
			List<MultipartFile> files, Integer [] fileNums) {
		//삭제처리
		//게시글 번호 확인
//		System.out.println("bd_num"+bd_num);
		
		//로그인한 유저 정보를 확인
//		getAttribute는 반환값이 Object라서 앞에 반환값을()로 설정해줘야함 
		MemberVO user = (MemberVO)(request.getSession().getAttribute("user"));
//		System.out.println("user id : "+user.getMe_id());
		//Service에 게시글 번호와 로그인한 유저 정보를 전달
		
		boardService.deleteBoard(bd_num, user);
		//게시글 삭제
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	//게시글 수정
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//게시글 = 서비스.게시글가져오기(번호, 로그인 정보)
		BoardVO board = boardService.getBoard(bd_num, user);
		
		//게시글이 없으면
			//1. 번호가 잘못된경우
			//2. 본인이 작성자가 아닐경우
		if(board==null) {
			mv.setViewName("redirect:/board/list");
		}else {
			//첨부파일 가져오기
			List<FileVO> fileList = boardService.getFileList(bd_num);
			mv.addObject("fileList", fileList);
			//게시글 가져오기
			mv.addObject("board", board);
			//화면출력
			mv.setViewName("/board/modify");
		}
		
		//서비스에게 변호를 알려주면서 게시글을 가져오라고 시킴
		//서비스가 보내준 게시글의 작성자와 로그인한 회원 아이디가 일치하는지 확인
		//컨트롤러가 서비스가 보내준 게시글 정보를 가지고 추가확인
		
		mv.setViewName("/board/modify");
		return mv;
	}
	
	
	//게시글 수정
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board,
			List<MultipartFile> files2, Integer [] fileNums) {
		if(fileNums != null) {
			for(Integer tmp : fileNums)
				System.out.println(tmp);
		}
		
		//서비스에게 게시글 정보를 주면서 업ㅌ데이트 하라고 시킴
		//서비스.게시글업데이트(게시글정보)
		boardService.updateBoard(board, files2, fileNums);
		//추가
		mv.addObject("bd_num", board.getBd_num());
		mv.setViewName("redirect:/board/detail");
		
		return mv;
	}
	
	@ResponseBody//리턴값이 직접적으로 화면에(요청한곳에) 가도록 해줌 
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		//집
//		String uploadPath = "C:\\Users\\tsj02\\Documents\\java_gny\\upload";
		//학원
		String uploadPath = "E:\\upload";
		
	    InputStream in = null;
	    //byte에 담아서 전송
	    ResponseEntity<byte[]> entity = null;
	    try{
	        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	
	//좋아요 누르기
	@ResponseBody//그냥 controller에 ajax를 이용하는 경우 추가해줘야함
	@RequestMapping(value ="/likes")
	//매개변수 안에 @RequestBody를 붙이는 이유? 
	public String boardLikes(@RequestBody LikesVO likes, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		return boardService.likes(likes, user);
	}
	
	//좋아요 표시
	@ResponseBody//그냥 controller에 ajax를 이용하는 경우 추가해줘야함
	@RequestMapping(value ="/view/likes")
	//매개변수 안에 @RequestBody를 붙이는 이유? 
	public String boardViewLikes(@RequestBody LikesVO likes, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		return boardService.viewLikes(likes, user);
	}
	
}
