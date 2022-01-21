<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE>
<html>
<head>
	<title>스프링</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<style>
	.boxy{ min-height : clac(100vh - 240px); }
	</style>
</head>
<body>
	<!-- taglib로 외부로부터 연결(import)해줘서 사용 가능한 태그 : tiles:insertAttribute -->
	<!-- header라고 불린 지정된 파일이 있으면, 그 파일을 지금 위치(tiles~가 있는 위치)에 넣어줌 -->
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
</body>
</html>