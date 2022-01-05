<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
</style>
</head>
<body>
	<form class="container" action="<%= request.getContextPath()%>/login" method="POST">
		<h1>LOGIN</h1>
		<div class="form-group">
			<input type="text" class="form-control" name="me_id" placeholder = "ID">
	    </div>
	    <div class="form-group">
	     	<input type="password" class="form-control" name="me_pw" placeholder ="PW">
	    </div>
	    <button type="submit" class="btn btn-primary col-12">LOGIN</button>
	</form>
</body>
</html>