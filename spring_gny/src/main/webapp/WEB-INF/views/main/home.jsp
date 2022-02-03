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
	<div class="body">
		<h1>Main Page</h1>
		<input type="text" id="input">
		<button id="btn">확인</button>
	</div>
	
	<script>
	
	var idRegex = /^[A-z]\w{4,7}$/g;
	//g나 gi 씀
	//gi => 대소문자 구분안함
	$('#btn').click(function(){
		var id = $('#input').val();
		if(idRegex.test(id)){
			alert('정규표현식에 맞음')
		}else{
			alert('정규표현식에 맞지 않음')
		}
	})
	$(function(){
		$.ajax({
			/*{속성명 : 값, 속성명 : 값}*/
			/* sync : 동기(false) async : 비동기(true)
				   비동기 : Ajax가 끝나지 않아도 다음 코드가 실행됨
				   동기 : Ajax가 완료되어야 다음 코드가 실행됨
				   
				   data : 서버로 보낼 데이터
				   url : 데이터를 보낼 서버 url
				   ★dataType : 서버에서 보내준 데이터의 타입
				   contentType : 서버로 보낼 데이터의 타입('data'의 타입)
					success : Ajax를 이용하여 서버에 데이터 전송 -> 서버에서 데이터를 처리
							  => 성공(success)시 호출되는 함수
							  - res : 서버에서 화면으로 보낸 데이터
			*/
			async :true, // 딱히 완료 안되어도 다른거ajswj 실행 ㄱ
		    type:'POST',
		    data:{str : "Sample"},
		    url:"<%=request.getContextPath()%>/ajax/test1",
		    //dataType : "json",
		    //contentType:"application/json; charset=UTF-8",
		    success : function(res){
		    	console.log(res);
		    	}
		    });
		
		
		  $.ajax({
				async :true, // 딱히 완료 안되어도 다른거ajswj 실행 ㄱ
			    type:'POST',
			    data:"Sample",
			    url:"<%=request.getContextPath()%>/ajax/test2",
			    //dataType : "json",
			    contentType:"application/json; charset=UTF-8",
			    success : function(res){
			    	console.log('=====ajax2=====')
			    	console.log(res);
			    	console.log('주소 : '+res.address);
			    	console.log('주소 : '+res['address']);
			    	}
			    });
		  $.ajax({
				async :true, 
			    type:'POST',
			    data:JSON.stringify({id : "qwer", pw:"asdf"}),
			    url:"<%=request.getContextPath()%>/ajax/test3",
			    dataType : "json",
			    contentType:"application/json; charset=UTF-8",
			    success : function(res){
			    	console.log("====ajax3====")
			    	console.log(res);
			    	console.log('주소 : '+res.address);
			    	console.log('주소 : '+res['address']);
			    	console.log('id : ' + res.data.id);
			    	console.log('pw : ' + res.data.pw);
			    	}
			    	
			    });
		console.log(123);
	});
	</script>
</body>
</html>
