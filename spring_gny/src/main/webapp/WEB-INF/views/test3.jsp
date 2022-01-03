<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Test3</title>
</head>
<body>
<h1>Test3 Hello</h1>
<form action="/spring/test3" method="GET">
	<input type="text" name="id" value=""><br>
	<input type="password" name="pw" value=""><br>
	
	<button type="submit">전송</button>
</form>
두 수의 합 : ${SUM}
</body>
</html>