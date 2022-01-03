<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Test2</title>
</head>
<body>
<h1>Test2 Hello</h1>
<form action="/spring/test2/form" method="GET">
	<input type="text" name="num1" value="${num1}"><br>
	<input type="text" name="num2" value="${num2}"><br>
	<input type="text" readonly value="${SUM}">
	<button type="submit">전송</button>
</form>
두 수의 합 : ${SUM}
</body>
</html>