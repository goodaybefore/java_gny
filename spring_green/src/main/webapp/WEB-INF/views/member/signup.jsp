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
	
	<!-- 정규표현식 -->
	<script src="<%=request.getContextPath()%>//resources/js/jquery.validate.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/additional-methods.js"></script>
	<style>

	</style>
	<style>
		.error{ color : red; }
	</style>
</head>
<body>
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
			<div class="form-group">
				<input type="text" class="form-control" placeholder="아이디" name="me_id" value="${user.me_id}">
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-info form-control" id="idcheck">중복확인</button>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="비밀번호" name="me_pw" id="pw" value="${user.me_pw}">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="비밀번호확인" name="pw2">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="이름" name="me_name" value="${user.me_name}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="생년월일" name="me_birth" id="birth" value="${user.me_birth}">
			</div>			
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
				<div>
					<label class="error" id="me_gender-error" for="me_gender"></label>
				</div>
			</div>
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
			//datepicker
			$( "#birth" ).datepicker();
			$( "#birth" ).datepicker( "option", "dateFormat", "yy-mm-dd" );

			let idCheck = false;
			//아이디 중복 체크
			$('#idcheck').click(function(){
				var id = $('[name=me_id]').val();
				$.ajax({
			        async : false,//다끝날때까지 기다령
			        type:'GET',
			      //url은 대문자 안ㅆ느ㅡㄴ게 좋대
			        url:'<%=request.getContextPath()%>/idcheck?me_id='+id,
			        dataType:"json",
			        //contentType:"application/json; charset=UTF-8",//보낼때 쓰는거라 필요없음
			        success : function(res){
			            console.log(res);
			            if(res == true){
			            	alert('사용가능한 아이디');
			            	idCheck = true;
			            	//console.log('사용가능한 아이디');
			            }else{
			            	alert('이미 가입된 아이디입니다.')
			            	idCheck = false;
			            	//console.log('이미 가입된 아이디입니다.');
			            }
			            	
			        }
			    });
			})
			
			$('[name=me_id]').change(function(){
				idCheck = false;
			})

			
			//항목 기입
			let id, pw, pw2, name, gender, birth, phone;
			let warnings = '';

			$('form').submit(function(){
				
				let isAgree = $('[name=agree]').is(':checked');
				
				
				
				if(!isAgree){
					alert('동의에 체크해야합니다.');
					$('[name=agree]').focus();
					return false;
				}
				if(!idCheck){
					alert('아이디 중복체크를 하세요');
					return false;
				}
				
				let address = $('#address').val() + ' ' +$('#detailAddress').val();
				$('[name=me_address]').val(address);
				
				
			})
		});
		
		$(function(){
			/* $("form").validate({
				rules : {
					//A : input, select, textarea 태그의 name을 써야함
					//옵션 : required, minlength와 같은 지정된 속성
					//옵션이 equalTo인 경우, 값으로 태그의 아이디가 와야함
					A:{
						옵션1 : 값,
						옵션2 : 값
					}
				},
				messages : {
					A : {
						옵션1 : 메세지,
						옵션2 : 메세지
					}
				}
			}); */
			
		    $("form").validate({
		        rules: {
		            me_id: {
		                required : true,//필수항목인지 아닌지
		                regex : /^[A-Za-z0-9][A-z0-9_-]{4,19}$/
		            },
		            me_pw: {//8~16자 영문 대소문자, 숫자, 특수문자를 사용
		            	required : true,
		                regex : /^[A-Za-z0-9-_!@#$%^&*]{8,16}$/
		            },
		            me_pw2: {
		            	//require : true,
		            	equalTo : pw
		            },
		            me_name: {
		            	required : true
		            },
		            me_birth: {
		            	required : true,
		            	regex : /^\d{4}-\d{2}-\d{2}$/
		            },
		            me_phone: {
		            	required : true,
		            	regex : /^\d{3}-\d{4}-\d{4}$/
		            },
		            me_gender: {
		            	required : true
		            }
		        },
		        //규칙체크 실패시 출력될 메시지
		        messages : {
		        	 me_id: {
			                required : "필수로 입력하세요",
			                regex : "5~20자의 영문또는 소문자, 특수기호(-, _)fmf tkdydgktpdy"
			            },
			            me_pw: {//8~16자 영문 대소문자, 숫자, 특수문자를 사용
			            	required : "필수로 입력하세요",
			                regex : "8~16자의 영문 대소문자, 숫자, 특수문자를 사용하세요"
			            },
			            me_pw2: {
			            	//require : true,
			            	equalTo : '비밀번호와 일치하지 않습니다.'
			            },
			            me_name: {
			            	required : "필수로 입력하세요",
			            },
			            me_birth: {
			            	required : "필수로 입력하세요",
			            	regex : 'yyyy-mm-dd형태로 입력하세요'
			            },
			            me_phone: {
			            	required : "필수로 입력하세요",
			            	regex : '000-0000-000 형태로 입력하세요.'
			            },
			            me_gender : {
			            	required : '필수로 입력하세요.'
			            }
		        }
		    });
		})
		$.validator.addMethod(
		    "regex",
		    function(value, element, regexp) {
		        var re = new RegExp(regexp);
		        return this.optional(element) || re.test(value);
		    },
		    "Please check your input."
		);
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
	</script>
</body>
</html>