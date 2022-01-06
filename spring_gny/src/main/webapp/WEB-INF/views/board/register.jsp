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
		<h1>게시글 등록</h1>
		<form action="<%=request.getContextPath() %>/board/register" method="post">
			<div class="form-group">
			  <input type="text" class="form-control" placeholder="제목" name="bd_title">
			</div>
			<div class="form-group">
			  <textarea type="text" class="form-control" placeholder="내용" rows="10" name="bd_contents"></textarea>
			</div>
			<button class="btn btn-outline-success col-12">submit</button>
		</form>
	</div>
</body>
</html>