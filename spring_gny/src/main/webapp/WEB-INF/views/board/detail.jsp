<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		$(function(){
			$('.btn-comment').click(function(){
				var user = '${user}';
				if(user == ''){
				alert('로그인 후 댓글 등록이 가능합니다')
				return;
				}
				//댓글 내용
				var co_contents = $('.text-comment').val();
				//게시글 번호
				var co_bd_num = '${board.bd_num}';
				//댓글 원본 번호(나중에)
				
				if(co_contents == ''){
					alert('댓글 내용을 입력하세요');
					return;
				}
				var comment = {
						co_contents : co_contents,
						co_bd_num : co_bd_num
						};
				$.ajax({
					async :true, 
				    type:'POST',
				    data:JSON.stringify(comment),
				    url:"<%=request.getContextPath()%>/comment/insert",
				    dataType : "json",
				    contentType:"application/json; charset=UTF-8",
				    success : function(res){
				    	if(res==true){
				    		$('.text-comment').val('');
				    		alert("댓글 등록이 완료되었습니다");
				    		//새로운 댓글을 가져옴
				    		readComment(co_bd_num, 1);
				    		
				    	}else{
				    		alert("댓글 등록에 실패했습니다.");
				    	}
					}
				});
			})
		});
		
		//이렇게 하면 안됨! => 나중에 추가된 이벤트들을 동작시키지 못함.
		//=> 댓글 등록하면 페이지네이션부분이 ajax로 새로 만들어지는데, 그부분이 동작이 안됨.
		//$('.comment-pagination page-link').click(function(){})
		
		//요소에 이벤트를 등록하는것이 아니라 document에 등록해서, 요소가 나중에 추가되어도
		//해당 선택자만 맞으면 Event가 실행됨
		$(document).on('click', '.comment-pagination .page-link', function(){
			var page = $(this).data('page');
			readComment(co_bd_num, page);
		});
		
		//댓글 삭제
		$(document).on('click', '.comment-list .btn-del-comment', function(){
			var co_num = $(this).data('num');//data-num => data.('num') 하면 값을 가져올수있음
			if(co_num != ''){
				$.ajax({
					async :false, // 딱히 완료 안되어도 다른거ajax 실행 ㄱ
				    type:'get',
				    url:"<%=request.getContextPath()%>/comment/delete?co_num="+co_num,
				    dataType:"json",
				    success : function(res){
				    	
				    	var co_bd_num = '${board.bd_num}';
				    	//1page 기준으로 
						readComment(co_bd_num, 1);
				    	}
				    
				    });
			}
		});
		
		
		
		//화면 로딩 후 댓글과 댓글 페이지네이션 배치
		var co_bd_num = '${board.bd_num}';
		readComment(co_bd_num, 1);
		
		
		
		
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
		function createCommentStr(co_me_id, co_contents, co_reg_date, co_num){
			var str=
			'<div class="comment-box">'+
				'<div class="co_me_id">'+co_me_id+'</div>'+
				'<div class="co_contents">'+co_contents+'</div>'+
				'<div class="co_reg_date">'+co_reg_date+'</div>'+
				'<button class=" btn btn_reply_comment btn-outline-success">답글</button>';
				//수정,삭제의 조건 => 작성자==로그인한아이디 인 경우에만 보여야함
				if('${user.me_id}' == co_me_id){
					str += '<button class=" btn btn_mod_comment btn-outline-warning ml-2" data-num="'+co_num+'">수정</button>'+
					'<button class=" btn btn-del-comment btn-outline-danger ml-2" data-num="'+co_num+'">삭제</button>';
				}
				
				str += 	'<hr>'+	'</div>';
				
				return str;
		}
		function readComment(co_bd_num, page){
			if(co_bd_num != ''){
				$.ajax({
					async :false, // 딱히 완료 안되어도 다른거ajax 실행 ㄱ
				    type:'get',
				    url:"<%=request.getContextPath()%>/comment/list?co_bd_num="+co_bd_num + '&page='+page,
				    dataType:"json",
				    success : function(res){
				    	var str = '';
				    	for(tmp of res.list){
				    		//그냥 콘솔 찍으면 날짜가 1642989793000 이딴식으로 나와서 변형해줘야함
							var date = new Date(tmp.co_reg_date);//날짜형태로 바꿔주고
							str += createCommentStr(tmp.co_me_id, tmp.co_contents, getDateStr(date), tmp.co_num);
				    	}
				    	
				    	$('.comment-list').html(str);
				    	var paginationStr = createCommentPagination(res.pm);
				    	$('.comment-pagination').html(paginationStr);
				    	}
				    
				    });
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
				console.log("i : "+i)
			}
			str += '<li class="page-item '+endDisabled+'"><a class="page-link" href="javascript:void(0);" data-page="' + (pm.criteria.page+1) +'">다음</a></li>'+
			'</ul>';
			return str;
				
		}
		
		//
		function commentService(){
			var commentSerivce={
					insert : function(){
						
					},
					delete : function(){
						
					},
					list : function(){
						
					}
			};
			
			
		}
	</script>
</body>
</html>