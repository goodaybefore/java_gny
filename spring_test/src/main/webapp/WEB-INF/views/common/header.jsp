<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <a class="navbar-brand" href="<%= request.getContextPath()%>">HOME</a>
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="<%= request.getContextPath()%>/login">LOGIN</a>
	    </li>
	    <li class="nav-item">
	    	<a class="nav-link" href="<%= request.getContextPath()%>/signup">SIGN UP</a>
	    </li>
	  </ul>
	</nav>
</body>
</html>