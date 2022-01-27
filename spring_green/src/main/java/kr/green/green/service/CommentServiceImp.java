package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.dao.CommentDAO;
import kr.green.green.pagination.Criteria;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	CommentDAO commentDao;

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(user == null || comment == null) return false;
		if(comment.getCo_contents()==null || user.getMe_id()==null) return false;
		//session에 잇는 회원정보랑 넘어온 작성자가 다른 경우(일어날 일이 없지만 예방차원)
		if(!comment.getCo_me_id().equals(user.getMe_id())) return false;
		
		comment.setCo_me_id(user.getMe_id());
		System.out.println("user : " + user);
		System.out.println("CommentVO : " +comment);
		commentDao.insertComment(comment);
		return true;
	}

	@Override
	public List<CommentVO> selectAllComment(Integer co_bd_num) {
		if(co_bd_num<0) return null;
		return commentDao.selectAllComment(co_bd_num);
	}

	@Override
	public List<CommentVO> selectCommentList(Integer bd_num, Criteria cri) {
		if(bd_num<=0 || bd_num==null) return null;
		
		return commentDao.selectCommentList(bd_num, cri);
	}

	@Override
	public int selectTotalCnt(Integer bd_num) {
		if(bd_num<=0||bd_num==null) return 0;
		return commentDao.selectTotalCnt(bd_num);
	}
}
