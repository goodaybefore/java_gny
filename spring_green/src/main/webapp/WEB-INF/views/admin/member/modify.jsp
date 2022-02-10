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
		<h1> 회원 정보 권한 변경</h1>
		<table class="table table-hover">
			<thead>
				<tr>
			        <th>회원 아이디</th>
			        <th>회원 이름</th>
			        <th>권한</th>
				</tr>
		    </thead>
		    <tbody>
		    	<c:forEach items="${list}" var = "user">
		    		<tr>
				        <td class="me_id">${user.me_id}</td>
				        <td>${user.me_name}</td>
				        <td>
				        	<select class="authority">
				        		<option <c:if test="${user.me_authority == '회원'}">selected</c:if>>회원</option>
				        		<option <c:if test="${user.me_authority == '관리자'}">selected</c:if>>관리자</option>
				        	</select>
				        </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
	$(function(){
		$('.authority').change(function(){
			var me_authority = $(this).val();
			var me_id = $(this).parents('tr').find('.me_id').text();
			var member = {
					me_authority : me_authority,
					me_id : me_id
			};
			console.log(member);
			$.ajax({
				async :false, 
			    type:'POST',
			    data:JSON.stringify(member),
			    url: '<%= request.getContextPath()%>/admin/update/authority',
			    contentType:"application/json; charset=UTF-8",
			    success : function(res){
			    	if(res == 'true')
			    		alert(me_id+' 회원의 권한이 <'+me_authority+'>(으)로 변경되었습니다.');
			    	else
			    		alert('권한 변경에 실패하였습니다. 다시 시도해주세요.')
				}
			});
		})
	})
	</script>
</body>
</html>