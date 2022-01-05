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
	  <a class="navbar-brand" href="<%= request.getContextPath()%>">Home</a>
	  
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="<%= request.getContextPath()%>/login">login</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%= request.getContextPath()%>/signup">signup</a>
	    </li>
	  </ul>
	</nav>
</body>
</html>