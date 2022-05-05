<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>
	<!-- datepicker -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
	<!-- jquery -->
	<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	
	<!-- 우편번호 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- datapicker -->
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	
	<!-- Validation 검사를 위한 플러그인 -->
	<!-- 순서 바뀌면 안됨 -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/additional-methods.min.js"></script>
	<style>
	.error{ color : red; }
	</style>
</head>
<body>
	<!-- 회원가입 화면
	- 입력항목 : 아이디, 비번, 비번확인, 이름, 성별, 생년월일, 주소
	- 아이디, 비번, 비번확인,이름, 성별, 생년월일은 필수항목
	- 비밀번호와 비밀번호확인 => 값이 같아야함

	조건 만족 시 회원가입 진행, 불만족시 alert창으로 불만족 조건 알려주고 회원가입 진행 stop
	약관동의창 만들고 약관동의 체크X시 회원가입no -->
	<form class="container signup body" action="<%= request.getContextPath()%>/signup" method="POST">
		
		<h1 class="title text-center">회원가입</h1>
		<div class="box" style="height: 100px; border: 1px solid black;">약관내용</div>
		<div class="form-group">
			<!-- 성별 -->
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="checkbox" class="form-check-input" name="agree">동의합니다
				</label>
			</div>
			
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디" name="me_id" value="${user.me_id}">
			<button type="button" class="btn btn-outline-success col-12" id="idCheck">아이디 중복 검사</button>
			<input type="password" class="form-control" placeholder="비밀번호" name="me_pw" value="${user.me_pw}" id="me_pw">
			<input type="password" class="form-control" placeholder="비밀번호확인" name="pw2"">
			<input type="text" class="form-control" placeholder="이름" name="me_name" value="${user.me_name}">
			<input type="text" class="form-control" placeholder="생년월일" name="me_birth" id="birth" value="${user.me_birth}">
			
			<div class="form-group">
				<!-- 성별 -->
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="radio" class="form-check-input" name="me_gender" value="female">여성
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="radio" class="form-check-input" name="me_gender" value="male">남성
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
				<input type="text" id="address" placeholder="주소" class="form-control mb-2">
				<input type="text" id="detailAddress" placeholder="상세주소" class="form-control mn-2">
				<input type="text" name="me_address" style="display:none;">
				<input type="text" class="form-control" placeholder="전화번호(-를 포함하여 입력하세요)" name="me_phone" value="${user.me_phone}">
			</div>
			<button type="submit" class="btn btn-outline-success col-12" id="btn">회원가입</button>
		</div>
	</form>
	
	<script>
	$(function(){
		
		//생년월일
		$( "#birth" ).datepicker();
		$( "#birth" ).datepicker( "option", "dateFormat", "yy-mm-dd" );

		//항목 기입
		let id, pw, pw2, name, gender, birth, phone;
		let warnings = '';
		
		var idCheck = false;
		$('#idCheck').click(function(){
			var id = $('[name=me_id]').val();
			$.ajax({
				async :true,
			    type:'POST',
			    data:{id: id},
			    url:"<%=request.getContextPath()%>/idcheck",
			    success : function(res){
			    	console.log(res);
			    	idCheck = res == 'ok' ? true : false;
			    	
			    	if(idCheck) alert('사용가능한 아이디');
			    	else alert('사용할 수 없는 아이디입니다.')
			    	}
			    });
		})
		
		
		
		$('form').submit(function(){
			
			let isAgree = $('[name=agree]').is(':checked');
			if(!isAgree){
				alert('동의에 체크해야합니다.');
				$('[name=agree]').focus();
				return false;
			}
			
			//id체크
			if(!idCheck){
				alert('아이디 중복검사를 하세요');
				return false;
			}
			
			
			let address = $('#address').val() + ' ' +$('#detailAddress').val();
			$('[name=me_address]').val(address);
			
		})
	});
			

	//address
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
	
	//validate : submit 되기전에 check한다는 뜻 : true면 전송, false면 전송아님
	$("form").validate({
	    rules: {
	        me_id: {
	            required : true,//필수항목인지
	            regex : /^[A-z]\w{4,7}$/
	        },
	        me_pw: {
	            required : true,
	            //최소 영문자 숫자가 1글자 이상씩 포함되어있고 최소 8자 최대 20자
	            //?= : 1을 만족하면 뒤에껄 체크함
				// 영어나 숫자가 들어가있고 8~20자 인 password 	            		
	            regex: /^(?=\w{4,20}$)\w*(\d[A-z]|[A-z]\d)\w*$/
	            //regex: /^\w*(\d[A-z]|[A-z]\d)\w*$/
	            //minlength : 4,
	            //maxlength : 20
	        },
	        me_pw2: {
	            required : true,
	            equalTo : me_pw//id를 지정하는거라 input 태그에 id를 설정해줘야함
	        },
	        me_name: {
	            required : true,
	            minlength : 2
	        },
	        me_gender: {
	        	required : true
	        }
	    },
	    //규칙체크 실패시 출력될 메시지
	    messages : {
	        me_id: {
	            required : "필수로입력하세요",
	            regex : "영문자, 숫자로 이루어져있으며 5~8자로 구성되어야 함."
	        },
	        me_pw: {
	            required : "필수로입력하세요",
	            minlength : "최소 {0}글자이상이어야 합니다",
	            maxlength : "최대 {0}글자이하여야 합니다",
	            regex : "영문자, 숫자로 이루어져있으며 최소 하나이상 포함"
	        },
	        me_pw2: {
	            equalTo : "비밀번호가 일치하지 않습니다."
	        },
	        me_name: {
	            required : "필수로입력하세요"
	        },
	        me_gender:{
	        	required : "필수로입력하세요"
	        }
	    }
	});
	
	$.validator.addMethod(
	    "regex",
	    function(value, element, regexp) {
	        var re = new RegExp(regexp);
	        return this.optional(element) || re.test(value);
	    },
	    "Please check your input."
	);
	</script>
</body>
</html>