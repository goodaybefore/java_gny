<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>LOGIN</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div class="body">
		<div class="container">
			<h1 class="text-center">LOGIN</h1>
			<form action="<%=request.getContextPath() %>/login" method="POST" class="login-form">
			<div class="form-group">
			  <input type="text" class="form-control" name="me_id">
			</div>
			<div class="form-group">
			  <input type="password" class="form-control" name="me_pw">
			</div>
			<button class="btn btn-outline-success col-12">로그인</button>
			</form>
			<a href="<%=request.getContextPath()%>/find">아이디/비밀번호 찾기</a>
		</div>
	</div>
</body>
</html>

