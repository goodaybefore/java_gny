<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container body">
		<h1>회원 정보 관리</h1>
		<table class="table table-hover table-light">
		    <thead>
		      <tr>
		        <th>아이디</th>
		        <th>이름</th>
		        <th>권한</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach items="${list}" var="member">
			      <tr>
			        <td class="id">${member.me_id}</td>
			        <td class="name">${member.me_name}</td>
			        <td>
			        	<select class="authority">
			        		<option <c:if test="${member.me_authority == '회원'}">selected</c:if> >회원</option>
			        		<option <c:if test="${member.me_authority == '관리자'}">selected</c:if> >관리자</option>
			        	</select>
					</td>
			      </tr>
		      </c:forEach>
		    </tbody>
		  </table>
	</div>
	<script>
	$('.authority').change(function(){
		var me_id = $(this).parents('tr').find('.id').text(); 
		var me_authority = $(this).val();
		
		var member = {
				me_id : me_id,
				me_authority : me_authority
		};
		
		$.ajax({
			async :false, 
		    type:'POST',
		    data:JSON.stringify(member),어
		    url: '<%= request.getContextPath()%>/admin/update/authority',
		    contentType:"application/json; charset=UTF-8",
		    success : function(res){
		    	if(res) alert(me_id + '님의 회원권한이 변경되었습니다')
		    	else alert('회원권한 변경에 실패하였습니다.')
			}
		});
		
		
	})
	</script>
</body>
</html>
