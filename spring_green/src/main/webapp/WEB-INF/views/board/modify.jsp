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
		<h1>게시글 수정</h1>
		<form action="<%= request.getContextPath() %>/board/modify" method="POST">
			<div class="form-group">
				<label>제목</label>
				<input type="text" class="form-control" placeholder="제목" name="bd_title" value="${board.bd_title}">
			</div>
			<div class="form-group">
				<label>작성자</label>
				<input type="text" class="form-control" name="bd_me_id" value="${board.bd_me_id}" readonly >
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" placeholder="내용" name="bd_contents" rows="10">${board.bd_contents}</textarea>
			</div>
			<input type="hidden" name="bd_num" value="${board.bd_num}">
			<button class="btn btn-outline-success col-12">수정완료</button>
		</form>
	</div>
</body>
</html>