<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- datepicker -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
	<!-- jquery -->
	<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	
	<!-- 우편번호 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- datapicker -->
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	
</head>
<body>
	<form class="container body" method="post" action="<%=request.getContextPath()%>/mypage">
	<h1>MY PAGE</h1>
	<div class="form-group">
		<input type="text" class="form-control" value="${user.me_id}" readonly>
	</div>
	<div class="form-group">
		<input type="password" class="form-control" placeholder="password" name="me_pw" id="me_pw">
	</div>
	<div class="form-group">
		<input type="password" class="form-control" placeholder="password check" name="me_pw2">
	</div>
	<div class="form-group">
		<input type="text" class="form-control"  name="me_name" value="${user.me_name}">
	</div>
	<div class="form-group">
	<input type="text" class="form-control" name="me_birth" id="birth" value="${user.me_birth_str}">
	</div>
	<div class="form-group">
		<!-- 성별 -->
		<div class="form-check-inline">
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="me_gender" value="female" <c:if test="${user.me_gender == 'female'}">checked</c:if>>여성
			</label>
		</div>
		<div class="form-check-inline">
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="me_gender" value="male" <c:if test="${user.me_gender == 'male'}">checked</c:if>>남성
			</label>
		</div>
	</div>
	<label id="me_gender-error" class="error" for="me_gender"></label>
	<div class="form-group">
		<!-- 주소 -->
		<div class="form-inline">
			<input type="text" id="postcode" placeholder="우편번호" class="form-control col-6"> 
			<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="form-control col-6">
		</div>
		<div class="form-group">
			<input type="text" id="address" placeholder="주소" class="form-control mb-2">
			<input type="text" id="detailAddress" placeholder="상세주소" class="form-control mb-2">
			<input type="text" name="me_address" style="display:none;">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="me_phone" value="${user.me_phone}">
		</div>
	</div>
	<button class="btn btn-success btn-mod col-12">회원 정보 수정</button>
	</form>
	
	<script>
	
	$('.btn-mod').click(function(){
		var me_address = $('#address').val() + ' ' +$('#detailAddress').val();
		$('[name=me_address]').val(address);
		var me_pw = $('[name=me_pw]').val();
		if(me_address == '' || me_pw == ''){
			//확인을 누르면 true, 취소를 누르면 false
			return confirm('비밀번호 또는 주소는 입력하지 않은 경우 이전 정보로 저장됩니다. 계속 진행하겠습니까?');
			//prompt : 문자열을 입력받은 입력창으로, 리턴값은 입력한 문자열이 됨
		}
		
		
		
	});
	
	$( "#birth" ).datepicker();
	$( "#birth" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
	$( "#birth" ).val('${user.me_birth_str}');
	
	function execDaumPostcode() {
		new daum.Postcode({
			oncomplete: function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수
	
				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}
	
				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if(data.userSelectedType === 'R'){
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
							extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if(data.buildingName !== '' && data.apartment === 'Y'){
							extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if(extraAddr !== ''){
							extraAddr = ' (' + extraAddr + ')';
					}
				}
	
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('postcode').value = data.zonecode;
				document.getElementById("address").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("detailAddress").focus();
			}
		}).open();
		}
	
	
		
	</script>
</body>
</html>