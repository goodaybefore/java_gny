<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="shortcut icon" href="#">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/comment.js"></script>
</head>
<body>
	<div class="body container">
		<c:if test="${board != null}">
			<h1>게시글 상세</h1>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_title" readonly value="${board.bd_title}">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_me_id" readonly value="${board.bd_me_id}">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_reg_date" readonly value="${board.bd_reg_date_str}">
			</div>
			<div class="form-group">
			  <div type="text" class="form-control" style="height:auto; min-height:300px;">${board.bd_contents}</div>
			</div>
			<div class="form-group">
				<c:if test="${files != null && files.size() != 0}">
					<label>첨부파일</label>
					<!-- items = 서버에서 보내줄 리스트 -->
					<c:forEach items="${files}" var="file">
						<a href="<%=request.getContextPath() %>/board/download?fileName=${file.fi_name}" class="form-control">${file.fi_ori_name}</a>
					</c:forEach>
					
				</c:if>
					
				<c:if test="${files==null || files.size() == 0}">
					<label>첨부파일 없음</label>
				</c:if>
			</div>
			<c:if test="${user != null && user.me_id == board.bd_me_id}">
				<a href="<%= request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">
					<button class="btn btn-outline-success">수정</button>
				</a>
				<a href="<%= request.getContextPath()%>/board/delete?bd_num=${board.bd_num}">
					<button class="btn btn-outline-danger">삭제</button>
				</a>
			</c:if>
			<!-- 추천 비추천 -->
			<div class="justify-content-center likes-btn-box" style="display : flex;">
				<button class="btn btn-outline-primary btn-up" data-state="1">추천</button>
				<button class="btn btn-outline-primary btn-down ml-2" data-state="-1">비추천</button>
			</div>
			<!-- 공지에 답변 안들어가도록 수정 -->
			<c:if test="${board.bd_type!='공지' && user != null && board.bd_ori_num == board.bd_num }">
				<a href="<%= request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}">
					<button class="btn btn-outline-warning">답변</button>
				</a>
			</c:if>
		</c:if>
		<c:if test="${board == null}">
			<h1>없는게시글이거나 삭제된 게시글입니다</h1>
		</c:if>
		
		
		<hr class="mt-3">
		<div class="comment-list mt-3">
			
		</div>
		<div class="comment-pagination">
			<ul class="pagination justify-content-center">
			    <li class="page-item"><a class="page-link" href="javascript:void(0);" data-page="">Previous</a></li>
			    <li class="page-item"><a class="page-link" href="javascript:void(0);" data-page="1">1</a></li>
			    <li class="page-item"><a class="page-link" href="javascript:void(0);" data-page="2">2</a></li>
			    <li class="page-item"><a class="page-link" href="javascript:void(0);" data-page="">Next</a></li>
			  </ul>
		</div>
		<div class="comment-box">
			<div class="input-group mb-3">
			  <textarea class="form-control text-comment" placeholder="댓글"></textarea>
			  <div class="input-group-append">
			    <button class="btn btn-success btn-comment">등록</button>
			  </div>
			</div>
		</div>
	</div>
	<script>
		commentService.setContextPath('<%=request.getContextPath()%>');
		console.log(commentService);
		
		$(function(){
			//댓글 등록 버튼 클릭
			$('.btn-comment').click(function(){
				//로그인한 회원만 가능하도록 회원 id를 가져오고, id가 없으면 로그인하라고 알려줌
				var user = '${user.me_id}';
				if(user == ''){
				alert('로그인 후 댓글 등록이 가능합니다')
				return;
				}
				//댓글 내용
				var co_contents = $('.text-comment').val();
				//게시글 번호
				var co_bd_num = '${board.bd_num}';
				//댓글 원본 번호(답글 기능 때 사용)
				
				//댓글 내용이 없는 경우
				if(co_contents == ''){
					alert('댓글 내용을 입력하세요');
					return;
				}
				
				//ajax로 댓글 정보를 보내기 위한 객체 생성
				//이 때 만들어지는 객체의 속성명을 CommentVO의 멤버변수 이름과 일치시킴
				var comment = {
						co_contents : co_contents,
						co_bd_num : co_bd_num
						};
				
				
				//댓글을 등록하기위해 ajax로 서버에 데이터를전송
				commentService.insert('/comment/insert', comment, function(res){
					if(res==true){
			    		//입력한 댓글을 지워줌
			    		$('.text-comment').val('');
			    		alert("댓글 등록이 완료되었습니다");
			    		//새로고침을 해서(전체가 아닌 댓글부분만) 1페이지에 맞는 댓글을 새로 가져옴
			    		readComment(co_bd_num, 1);
			    		
			    	}else{
			    		alert("댓글 등록에 실패했습니다.");
			    	}
				});
				
			})
		});
		
		//이렇게 하면 안됨! => 나중에 추가된 이벤트들을 동작시키지 못함.
		//=> 댓글 등록하면 페이지네이션부분이 ajax로 새로 만들어지는데, 그부분이 동작이 안됨.
		//$('.comment-pagination page-link').click(function(){})
		
		//요소에 이벤트를 등록하는것이 아니라 document에 등록해서, 요소가 나중에 추가되어도
		//해당 선택자만 맞으면 Event가 실행됨
		var page = $(this).data('page');
		$(document).on('click', '.comment-pagination .page-link', function(){
			//var page = $(this).data('page');
			readComment(co_bd_num, page);
		});
		
		//댓글 삭제
		$(document).on('click', '.comment-list .btn-del-comment', function(){
			//삭제할 댓글 번호 가져옴(삭제할댓글번호 : delete버튼에 data-num 속성값으로 입력되어있음)
			//data() 메소드는 data-xxx인 속성들의 값을 가져올때사용
			var co_num = $(this).data('num');//data-num => data.('num') 하면 값을 가져올수있음
			
			//삭제할 댓글 번호가 있는 경우만 삭제
			if(co_num != ''){
				commentService.delete('/comment/delete?co_num='+co_num, function(res){
					var co_bd_num = '${board.bd_num}';
					readComment(co_bd_num, 1);
				})
			}
		});
		
		
		//댓글 수정
		$(document).on('click', '.comment-list .btn-mod-comment', function(){
			// 이전에 댓글 수정버튼을 클릭해서 생긴 textarea태그와 등록button을 제거하고, 감춰뒀던 답글, 수정,삭제button을 추가
			//.co_contents2가 있으면 걔 형제중에 co_contents2를 다시 보여주고, 자기자신을 지움
			//수정할때 하나만 선택되도록 하는 기능
			$('.co_contents2').each(function(){
				//수정하기의 댓글을 다시 보여줌(co_contents : 수정 전 / co_contents2 : 수정 후)
				$(this).siblings('.co_contents').show();
				//답변,(수정,삭제)button을 보여줌
				$(this).parent().children('button').show();
				//댓글수정을 위한 등록버튼을 없앰
				$(this).siblings('.btn-mod-comment2').remove();//remove()본인 포함해서 자식들까지 삭제. empty()본인 제외하고 자식들만 삭제
				
				//답글 등록버튼 없애기
				$(this).siblings('.btn-reply-comment2').remove();
				
				//textarea태그를 제거(수정하기위한 입력창)
				$(this).remove();
			})
			
			//등록된 댓글 내용을 가져옴(수정 전) => textarea안에 넣어주기위해
			var contents = $(this).siblings('.co_contents').text();
			//textarea태그를 꾸며주기위한 html
			var str = '<div class="form-group co_contents2 mt-2">'+
			'<textarea class=" form-control">'+contents+'</textarea>'+
			'</div>';
			
			//등록 버튼을 위한 html(수정 완료를 위한 버튼)
			var btnStr = '<button class=" btn btn-mod-comment2 btn-outline-success ml-2">수정등록</button>';
			//기존 댓글을 감춤
			$(this).siblings('.co_contents').hide();
			//답글, 수정, 삭제버튼을 감춤
			$(this).parent().children('button').hide();
			//textarea태그를 id(co_me_id)밑에 배치
			$(this).siblings('.co_me_id').after(str);
			//등록버튼을 날짜(co_reg_date) 밑에 배치
			$(this).siblings('.co_reg_date').after(btnStr);
			
			
		});
		
		
		//수정버튼 눌렀을 때 생기는 등록버튼 클릭 이벤트
		$(document).on('click', '.comment-list .btn-mod-comment2', function(){
			//수정된 댓글 내용
			var co_contents = $(this).siblings('.co_contents2').children().val();
			
			//수정할 댓글 번호
			var co_num = $(this).siblings('[name=co_num]').val();
			//수정된 내용, 번호를 이용하여 객체를 생성 => 서버로 전송해야하니까
			var comment={
					co_num : co_num,
					co_contents :  co_contents
			}
			commentService.modify('/comment/modify', comment, function(res){
				//수정에 성공하면
		    	if(res){
		    		var page = $('.comment-pagination .active').text();
			    	var co_bd_num = '${board.bd_num}';
			    	//현재 페이지와 게시글 번호에 맞게 댓글을 새로고침
					readComment(co_bd_num, page);
					}else{
						alert("댓글 수정에 실패했습니다.")
					}
			})			
		});
		
		
		
		//답글버튼 클릭
		$(document).on('click', '.btn-reply-comment', function(){
			//답글을 달려는 원본댓글
			var co_num = $(this).data('num');
			//로그인한 아이디를 가져옴
			var id = '${user.me_id}';//${user.me_id}에 ''를 붙인거랑 안ㅇ붙인거랑 차이?
					//''를 안쓰면 로그인한 회원이 없을 때 코드가 id = ;가 됨(문법에 안맞음)
					
			//로그인안하면 답글을 못달게함
			if(id == ''){
				alert('답글은 로그인한 회원만 작성가능합니다.');
				return;
			}
			//이전 답글창 제거
			$('.co_contents2').each(function(){
				$(this).siblings('.btn-reply-comment2').remove();
				$(this).parent().children('button').show();//답글 삭제 수정버튼
				
				$(this).siblings('.co_contents').show();
				$(this).siblings('.btn-mod-comment2').remove();
				
				$(this).remove();
			})
			//답글창 추가
			//textarea태그를 꾸며주기위한 html
			var str = '<div class="form-group co_contents2 mt-2">'+
			'<textarea class=" form-control"></textarea>'+
			'</div>';
			//답글 등록을 위한 html 버튼
			var btnStr = '<button class=" btn btn-reply-comment2 btn-outline-success ml-2">답글등록</button>';
			
			//textarea태그를 id(co_me_id)밑에 배치
			$(this).siblings('.co_reg_date').after(str);
			//등록버튼을 날짜(co_reg_date) 밑에 배치
			$(this).siblings('hr').before(btnStr);
			//답글, (수정, 삭제)버튼을 감춤
			$('.btn-reply-comment2').siblings('button').hide();
			
		});
		
		//답글 등록 버튼 클릭
		$(document).on('click', '.btn-reply-comment2', function(){
			//원래 댓글 번호(여기서는 co_num), 내용, 게시글 번호
			var co_contents = $('.co_contents2 textarea').val();
			var co_ori_num = $(this).siblings('.btn-reply-comment').data('num');
			var co_bd_num = '${board.bd_num}';
			
			var comment = {
					co_contents : co_contents,
					co_ori_num : co_ori_num,
					co_bd_num : co_bd_num
			}
			commentService.insert('/comment/insert', comment, function(res){
				//답글 달기에 성공하면
		    	if(res){
		    		var page = $('.comment-pagination .active').text();
			    	var co_bd_num = '${board.bd_num}';
			    	//현재 페이지와 게시글 번호에 맞게 댓글을 새로고침
					readComment(co_bd_num, page);
					}else{
						alert("답글 달기에 실패했습니다.")
					}
			});
			
		});
		
		
		
		
		
		$('.btn-up, .btn-down').click(function(){
			var li_state = $(this).data('state');
			var li_bd_num = '${board.bd_num}';
			var li_me_id = '${user.me_id}';
			
			var likes = {
					li_state: li_state,
					li_bd_num : li_bd_num,
					li_me_id : li_me_id
			}
			console.log(likes);
			
			if(li_me_id == '') {
				alert('로그인한 회원만 추천/비추천이 가능합니다');
				return;
			}
			$.ajax({
				async :false, 
			    type:'POST',
			    data:JSON.stringify(likes),
			    url: '<%=request.getContextPath()%>/board/likes',
			    dataType : "json",
			    contentType:"application/json; charset=UTF-8",
			    success : function(res){
			    	if(res == 1){
			    		alert('추천했습니다');
			    	}else if(res == -1){
			    		alert('비추천했습니다')
			    	}else if(res != 'fail'){
			    		var str = li_state == 1 ? '추천' : '비추천';
			    		alert(str+'을 취소했습니다')
			    		
			    	}
			    	viewLikes(likes);
				}
			});
		});
		
		
		
		//화면 로딩 후 댓글과 댓글 페이지네이션 배치
		var co_bd_num = '${board.bd_num}';
		readComment(co_bd_num, 1);
		
		viewLikes({
			li_bd_num : '${board.bd_num}',
			li_me_id : '${user.me_id}'
		});
		
		
		
		//Functions
		
		//Date 객체를 yyyy-MM-dd hh:mm형태의 문자열로 변환하는 함수
		function getDateStr(date){
    		var year = date.getFullYear();
    		var month = date.getMonth()+1;
    		var day = date.getDate();
    		var hour = date.getHours();
    		var minute = date.getMinutes();
			return year+"-"+month+"-"+day+" "+hour+":"+minute;
			
		}
		function createCommentStr(comment, co_reg_date){
			var str='';
			if(comment.co_num == comment.co_ori_num){
				str += '<div class="comment-box">';
			}
			else{ str += '<div class="comment-box" style="margin-left : 30px;">'}
				
			str += '<input type="hidden" name="co_num" value="'+comment.co_num+'">'+
				'<div class="co_me_id">'+comment.co_me_id+'</div>';
				
				if(comment.co_num == comment.co_ori_num)
					str += '<div class="co_contents">'+comment.co_contents+'</div>';
				else
					str += '<span class="co_contents mt-2"> '+comment.co_contents+'</span>';
				
				
				str += '<div class="co_reg_date">'+co_reg_date+'</div>';
				
				//co_num으로 해도되는이유 : 답글버튼은 항상 댓글한테만 있을수있고 댓댓글에는 없어야함
				if(comment.co_num == comment.co_ori_num)
					str += '<button class=" btn btn-reply-comment btn-outline-success" data-num="'+comment.co_num+'">답글</button>';
				
				//수정,삭제의 조건 => 작성자==로그인한아이디 인 경우에만 보여야함
				if('${user.me_id}' == comment.co_me_id){
					str += '<button class=" btn btn-mod-comment btn-outline-warning ml-2" data-num="'+comment.co_num+'">수정</button>'+
					'<button class=" btn btn-del-comment btn-outline-danger ml-2" data-num="'+comment.co_num+'">삭제</button>';
				}
				
				str += 	'<hr>'+	'</div>';
				
				return str;
		}
		
		//게시글에 댓글 중 pag번호에 맞는 댓글을 가져와서 화면에 배치하는 함수
		function readComment(co_bd_num, page){
			//게시글 번호가 없으면 가져올 게시글이 없어서 작업하지 않음
			if(co_bd_num != ''){
				var  url = '/comment/list?co_bd_num='+co_bd_num + '&page='+page;
				commentService.list(url, function(res){
					//res.list : 페이지번호에 맞는 댓글리스트
			    	//res.pm : 댓글의 페이지메이커
			    	var str = '';
			    	//댓글을 하나씩 가져와서 html로 이루어진 문자열을 만든 후 이어붙임
			    	for(tmp of res.list){
			    		//정수로 넘어온 댓글 날짜를 날짜타입으로 형변환
			    		//그냥 콘솔 찍으면 날짜가 1642989793000 이딴식으로 나와서 변형해줘야함
						var date = new Date(tmp.co_reg_date);
						//댓글 정보를 html 문자열로 만든 후 이어붙임
						str += createCommentStr(tmp, getDateStr(date));
			    	}
			    	//html로 된 댓글들을 지정된 위치에 배치
			    	$('.comment-list').html(str);
			    	//서버에서 보낸 PageMaker를 이용하여 html로 이루어진 pagination을 만듦
			    	var paginationStr = createCommentPagination(res.pm);
			    	//만들어진 html pagination을 배치
			    	$('.comment-pagination').html(paginationStr);
					
				})
			}
		}
		function createCommentPagination(pm){
			
			var str = "";
			str += 
			'<ul class="pagination justify-content-center">';
			var startDisabled = pm.prev  ? '' : 'disabled';
			var endDisabled= pm.next ? '' : 'disabled';
			
			str += '<li class="page-item '+startDisabled+'"><a class="page-link" href="javascript:void(0);" data-page="'+(pm.criteria.page-1)+'">이전</a></li>';
			for(i = pm.startPage; i<=pm.endPage;i++){
				var currentActive = pm.criteria.page == i ? ' active' : '';
				str += '<li class="page-item '+currentActive+'"><a class="page-link" href="javascript:void(0);" data-page="' +i + '">'+i+'</a></li>';
			}
			str += '<li class="page-item '+endDisabled+'"><a class="page-link" href="javascript:void(0);" data-page="' + (pm.criteria.page+1) +'">다음</a></li>'+
			'</ul>';
			return str;
				
		}
		
		function viewLikes(likes){
			
			$.ajax({
				async :false, 
			    type:'POST',
			    data:JSON.stringify(likes),
			    url: '<%=request.getContextPath()%>/board/view/likes',
			    dataType : "json",
			    contentType:"application/json; charset=UTF-8",
			    success : function(res){
			    	$('.likes-btn-box .btn').removeClass('btn-primary').addClass('btn-outline-primary');
			    	$('.likes-btn-box .btn').each(function(){
			    		if($(this).data('state') == res){
			    			$(this).removeClass('btn-outline-primary').addClass('btn-primary');
			    		}
			    	})
				}
			});
			
		}
		//
		/*function commentService(){
			var commentSerivce={
					insert : function(){
						
					},
					delete : function(){
						
					},
					list : function(){
						
					}
			};
		}*/
	</script>
</body>
</html>