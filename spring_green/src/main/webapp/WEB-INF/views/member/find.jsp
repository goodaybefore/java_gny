<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container body">
		<h1>아이디/비밀번호 찾기</h1>
		<ul class="nav nav-tabs" role="tablist">
		  <li class="nav-item">
		    <a class="nav-link active" data-toggle="tab" href="#home">아이디 찾기</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" data-toggle="tab" href="#menu1">비밀번호 찾기</a>
		  </li>
		</ul>
		
		<!-- Tab panes -->
		<div class="tab-content">
		  <div id="home" class="container tab-pane active"><br>
		    <h3>아이디 찾기</h3>
		     <div id="id-box">
		     	<div class="form-group">
		     		<input type="text" class="form-control" name="me_email" placeholder="이메일 입력">
				</div>
				<div class="form-group">
				    <input type="text" class="form-control" name="me_name" placeholder="이름을 입력">
			    </div>
		     </div>
		     <button class="btn btn-outline-success btn-find-id col-12">아이디 찾기</button>
		  </div>
		  <div id="menu1" class="container tab-pane fade"><br>
		    <h3>비밀번호 찾기</h3>
		    <div id="pw-box">
			    <div class="form-group">
				    <input type="text" class="form-control" name="me_email" placeholder="이메일 입력">
				</div>
				<div class="form-group">
				    <input type="text" class="form-control" name="me_id" placeholder="아이디를 입력">
			    </div>
		    </div>
		    <button class="btn btn-outline-success btn-find-pw col-12">비밀번호 찾기</button>
		  </div>
		</div>
	</div>
	<script>
	$(function(){
		$('.btn-find-id').click(function(){
			var me_email = $(this).siblings().find('[name=me_email]').val();
			var me_name= $(this).siblings().find('[name=me_name]').val();
			var member ={
					me_email : me_email,
					me_name : me_name
			};
			$.ajax({
		    	async : false,
		        type:'POST',
		        url:'<%=request.getContextPath()%>/member/find/id',
		        data:JSON.stringify(member),
		        //화면이 서버로 보낸 데이터의 타입
		        contentType:"application/json; charset=UTF-8",
		        success : function(res){
		        	if(res == '') alert('일치하는 정보가 없습니다.')
					if(res != null){
						alert('찾으시는 아이디는 '+res+' 입니다.');
					}
		        }
			});
		})
	})
	</script>
</body>
</html>