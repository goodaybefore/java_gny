<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
</head>
<body>
	<div class="body container">
		<h1>게시글 상세</h1>
		<div class="form-group">
			<!-- 이거 name 왜들어갔지? Mapper였나? -->
			<input type="text" class="form-control" readonly name="bd_title" value="${thisBoard.bd_title}">
		</div>
		<div class="form=group">
			<input type="text" class="form-control" readonly name="bd_me_id" value="${thisBoard.bd_me_id}">
		</div>
		<div class="form=group">
			<input type="text" class="form-control" readonly name="bd_red_date_str" value="${thisBoard.bd_reg_date_str}">
		</div>
		<div class="form-group">
			<textarea readonly class="form-control" name="bd_contents" rows="10">${thisBoard.bd_contents}</textarea>
		</div>
	</div>
</body>
</html>