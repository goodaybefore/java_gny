<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 이거 추가하는거 왜 추가하는거지? -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- ${serverTime}은 Controller(서버)에서 화면으로 보낸 데이터 <- 여기서 serverTime 빼면 에러발생함 ㅜㅜ -->
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
