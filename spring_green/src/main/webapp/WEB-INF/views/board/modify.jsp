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
		<form action="<%= request.getContextPath() %>/board/modify" method="POST" enctype="multipart/form-data">
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
			<div class="form-group attachment">
				<label>첨부파일</label>
				<c:forEach items="${fileList}" var="file">
					<div class="form-group">
						<input type="hidden" name="fileNums" value="${file.fi_num}">
						<span>${file.fi_ori_name}</span>
						<a class="btn-close" href="#">X</a>
					</div>
				</c:forEach>
				<c:forEach begin="1" end="${3 - fileList.size()}">
					<input type="file" class="form-control" name="files2">
				</c:forEach>
			</div>
			<button class="btn btn-outline-success col-12">수정완료</button>
		</form>
	</div>
	<script>
		$(function(){
			$('.attachment .btn-close').click(function(e){
				e.preventDefault();
				$(this).parent().remove();
				var str = '<input type="file" class="form-control" name="files2">';
				$('.attachment').append(str);
			})
		})
	</script>
</body>
</html>