<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand/logo -->
	  <a class="navbar-brand" href="<%= request.getContextPath()%>/">Home</a>
	  
	  
	  
	  <!-- Links -->
	  <ul class="navbar-nav">
	  		<!-- Login되어있지 않으면 => 세션에 user가 없으면 -->
		  <c:if test="${user == null}">
		  	<li class="nav-item">
		      <a class="nav-link" href="<%= request.getContextPath()%>/login">login</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="<%= request.getContextPath()%>/signup">sign up</a>
		    </li>
		  </c:if>
		  <!-- Login되어있으면 => 세션에  user가 있으면 =>user가 null이 아니면 -->
		  <c:if test="${ user != null }">
		  	<li class="nav-item">
		      <a class="nav-link" href="<%= request.getContextPath()%>/logout">logout</a>
		    </li>
		  </c:if>
		  
		  <li class="nav-item">
		      <a class="nav-link" href="<%= request.getContextPath()%>/board/list?type=공지">notice</a>
		  </li>
		  <li class="nav-item">
		      <a class="nav-link" href="<%= request.getContextPath()%>/board/list">board</a>
		  </li>
		    
	  </ul>
	</nav>
</body>
</html>