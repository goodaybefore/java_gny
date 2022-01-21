<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="body container">
		<h1>${board.typeTitle} 등록</h1>
		<form action="<%= request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
			<c:if test="${bd_type=='일반'}">
				<input type="hidden" name="bd_type" value="${board.bd_type}">
			</c:if>
			<c:if test="${board.bd_type=='공지'}">
				<input type="hidden" name="bd_type" value="${board.bd_type}">
			</c:if>
			<c:if test="${board.bd_type=='qna'}">
				<input type="hidden" name="bd_type" value="${board.bd_type}">
			</c:if>
			<c:if test="${board.bd_type==null}">
				board.bd_type : null임 먼가 잘못되고있음
			</c:if>
			<label>제목</label>
			<div class="form-group">
				<input type="text" class="form-control" name="bd_title" placeholder="제목">
			</div>
			
			<label>내용</label>
			<div class="form-group">
				<textarea class="form-control" name="bd_contents" placeholder="제목" rows="10"></textarea>
			</div>
			<c:if test="${board.bd_ori_num !=null}">
				<input type="hidden" name="bd_ori_num" value="${board.bd_ori_num}">
			</c:if>
			<div class="form-group">
		        <label>첨부파일</label>
		        <input type="file" class="form-control" name="files2"/>
		        <input type="file" class="form-control" name="files2"/>
		        <input type="file" class="form-control" name="files2"/>
		    </div>
			<button class="btn btn-outline-success">작성완료</button>
		</form>
	</div>
</body>
</html>