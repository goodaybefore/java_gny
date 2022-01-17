package kr.green.green.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	

	
	//list출력
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView BoardlistGet(ModelAndView mv){
		
		//게시글을 가져오기위한 List
		List<BoardVO> list = boardService.getBoardList("일반");
		//list를 넘겨주기
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		//mv.addObject("list",list).setViewName("/board/list");로 한줄로 해도됨
		return mv;
	}
	//게시글 상세(detail)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView BoardDetailPost(ModelAndView mv, Integer bd_num) {
		BoardVO  board = boardService.getBoardList(bd_num);
		
		//게시글 번호와 일치하는 첨부파일 가져오라고 시킴(최대 3개)
		List<FileVO> fileList = boardService.getFileList(bd_num);
//		System.out.println("fileList : "+fileList);
		mv.addObject("fileList",fileList);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	//게시글 등록(register) - GET
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView BoardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	
	
	//게시글 등록(register) - POST
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView BoardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request,
			List<MultipartFile> files) {
		//현재 세션에서 로그인되어있는 유저 정보를 가져오기
		//아직 HttpServeltRequest에 익숙하지 않으니 꼭 명심해두기
		MemberVO user = (MemberVO)(request.getSession().getAttribute("user"));
		//board에 등록하라고 service에게 전달

		board.setBd_type("일반");
		boardService.regBoard(board, user, files);
		
		//insert되었으면 list로 돌아가서 목록 보여주기
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	//게시글 수정 get
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView BoardModifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");//user를 다른걸로 하면 안나오는 이유 누가 아시는분 => 로그인할때 addObject를 user로 해줬기 때문인가?
		System.out.println("user " +user);//pw가 qwer그대로 나오는거 봐서는 알아서 복호화 된걱겠지?
		BoardVO board = boardService.getBoardList(bd_num);
		
		if(user!=null|| board!=null &&
				user.getMe_id().equals(board.getBd_me_id())) {
			mv.addObject("board", board);
			mv.setViewName("/board/modify");
		}else {
			mv.addObject("bd_num",bd_num);//detail로 넘어가려면 게시글 번호(bd_num)가 필요
			mv.setViewName("redirect:/board/detail");
		}
		return mv;
	}
	
	//게시글 수정 post
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ModelAndView BoardModifyPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		
		//강사님
		mv.setViewName("redirect:/board/detail");
		
		//
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//강사님은 비밀번호 암호와 되어서 오는데 왜 난 아니지??
		boardService.modifyBoard(board, user);
		
		//이거 넣어주면 detail에 '수정된 번호의 게시글'이 나옴
		mv.addObject("bd_num", board.getBd_num());
		
		
		/*
		//내꺼. 안될듯.
		System.out.println("board : "+board);
		boardService.modifyBoard(board);
		
		//난 왜 맨날 addObject를 빼먹을까?
		//mv.addObject("board", board);
		//근데 board가 아니라 bd_num을 해줬어야했대
		mv.addObject("bd_num", board.getBd_num());
		mv.setViewName("redirect:/board/detail");
		*/
		return mv;
	}
	
	//게시글 삭제 - GET
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView BoardDeleteGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		boardService.deleteBoard(user, bd_num);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
		
	//첨부파일 다운로드
	@ResponseBody
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		String uploadPath = "C:\\Users\\tsj02\\Documents\\java_gny\\upload";
		InputStream in = null;
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
}
