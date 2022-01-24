<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="body container">
		<c:if test="${board != null}">
			<h1>게시글 상세</h1>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_title" readonly value="${board.bd_title}">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_me_id" readonly value="${board.bd_me_id}">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_reg_date" readonly value="${board.bd_reg_date_str}">
			</div>
			<div class="form-group">
			  <div type="text" class="form-control" style="height:auto; min-height:300px;">${board.bd_contents}</div>
			</div>
			<div class="form-group">
				<c:if test="${files != null && files.size() != 0}">
					<label>첨부파일</label>
					<!-- items = 서버에서 보내줄 리스트 -->
					<c:forEach items="${files}" var="file">
						<a href="<%=request.getContextPath() %>/board/download?fileName=${file.fi_name}" class="form-control">${file.fi_ori_name}</a>
					</c:forEach>
					
				</c:if>
					
				<c:if test="${files==null || files.size() == 0}">
					<label>첨부파일 없음</label>
				</c:if>
			</div>
			<c:if test="${user != null && user.me_id == board.bd_me_id}">
				<a href="<%= request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">
					<button class="btn btn-outline-success">수정</button>
				</a>
				<a href="<%= request.getContextPath()%>/board/delete?bd_num=${board.bd_num}">
					<button class="btn btn-outline-danger">삭제</button>
				</a>
			</c:if>
			<!-- 공지에 답변 안들어가도록 수정 -->
			<c:if test="${board.bd_type!='공지' && user != null && board.bd_ori_num == board.bd_num }">
				<a href="<%= request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}">
					<button class="btn btn-outline-warning">답변</button>
				</a>
			</c:if>
		</c:if>
		<c:if test="${board == null}">
			<h1>없는게시글이거나 삭제된 게시글입니다</h1>
		</c:if>
		<div class="comment-list mt-3">
		</div>
		<div class="comment-pagination"></div>
		<div class="comment-box">
			<div class="input-group mb-3">
			  <textarea class="form-control text-comment" placeholder="댓글"></textarea>
			  <div class="input-group-append">
			    <button class="btn btn-success btn-comment">등록</button>
			  </div>
			</div>
		</div>
	</div>
	<script>
		$(function(){
			$('.btn-comment').click(function(){
				var user = '${user}';
				if(user = ''){
				alert('로그인 후 댓글 등록이 가능합니다')
				return;
				}
				//댓글 내용
				var co_contents = $('.text-comment').val();
				//게시글 번호
				var co_bd_num = '${board.bd_num}';
				//댓글 원본 번호
				var comment = {
						"co_contents" : co_contents,
						"co_bd_num" : co_bd_num
						};
				$.ajax({
					async :true, 
				    type:'POST',
				    data:JSON.stringify(comment),
				    url:"<%=request.getContextPath()%>/comment/insert",
				    dataType : "json",
				    contentType:"application/json; charset=UTF-8",
				    success : function(res){
				    	if(res==true){
				    		$('.text-comment').val('');
				    		alert("댓글 등록이 완료되었습니다");
				    		//새로운 댓글을 가져옴
				    	}else{
				    		alert("댓글 등록에 실패했습니다.");
				    	}
				    	}
				    });
			})
		});
	</script>
</body>
</html>