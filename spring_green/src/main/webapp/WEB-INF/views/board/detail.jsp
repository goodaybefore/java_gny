<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- title태그 없어두댄ㄷㅐㅇ -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/comment.js"></script>
</head>
<body>
	<div class="body container">
		<h1>${board.typeTitle} 상세</h1>
		<div class="form-group">
			<label>제목</label>
			<!-- 이거 name 왜들어갔지? Mapper였나? -->
			<input type="text" class="form-control" readonly name="bd_title" value="${board.bd_title}">
		</div>
		
		<div class="form-group">
			<label>작성자</label>
			<input type="text" class="form-control" readonly name="bd_me_id" value="${board.bd_me_id}">
		</div>
		
		<div class="form-group">
			<label>날짜</label>
			<input type="text" class="form-control" readonly name="bd_red_date_str" value="${board.bd_reg_date_str}">
		</div>
		<div class="form-group">
			<label>내용</label>
			<div class="form-control" name="bd_contents" style="min-height:100px; height:auto;">${board.bd_contents}</div>
		</div>
		<div class="form-group">
			<c:if test="${fileList!=null && fileList.size() !=0}">
				<label>첨부파일</label>
				<c:forEach items="${fileList}" var="file">
					<a href="<%=request.getContextPath() %>/board/download?fileName=${file.fi_name}" class="form-control">${file.fi_ori_name}</a>
				</c:forEach>
			</c:if>
			<c:if test="${fileList == null || fileList.size() == 0}">
				<label>첨부파일 없음</label>
			</c:if>
		</div>
		<c:if test="${user.me_id == board.bd_me_id}">
			<a href="<%= request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">
			<button class="btn btn-outline-success">수정</button>
			</a>
			<a href="<%= request.getContextPath()%>/board/delete?bd_num=${board.bd_num}&bd_type=${board.bd_type}">
				<button class="btn btn-outline-danger">삭제</button>
			</a>
		</c:if>
		<!-- 현재 보고있는 게시글이 원본 게시글인 경우 -->
		<c:if test="${board.bd_num == board.bd_ori_num && (board.bd_type == '일반' || board.bd_type =='질문')}">
			<a href="<%= request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}">
				<button class="btn btn-outline-warning">답변</button>
			</a>
		</c:if>
		<!-- 현재 보고있는 게시글이 답변 게시글인 경우 -->
		<c:if test="${board.bd_num != board.bd_ori_num && (board.bd_type == '일반' || board.bd_type =='질문')}">
			<a href="<%= request.getContextPath()%>/board/register?bd_ori_num=${board.bd_ori_num}">
				<button class="btn btn-outline-warning">답변</button>
			</a>
		</c:if>
		<!-- 댓글 -->
		<hr class="mt-3">
		<div class="comment-list">
			
		</div>
		<div class="comment-pagination">
			
		</div>
		
		
		<div class="comment-box">
			<div class="input-group mb-3 mt-3">
				<textarea class="form-control text-comment" rows="3" placeholder="Comment"></textarea>
				<div class="input-group-append">
					<button class="btn btn-success btn-comment">등록</button>  
				</div>
			</div>
		</div>
	</div>
	<script>
	
	var contextPath = '<%=request.getContextPath()%>'
	
	commentService.setContextPath(contextPath);
	console.log(commentService.contextPath)
	
	//문서가 로딩이 되면 이벤트를 등록해
	$(function(){
		
		var co_bd_num = '${board.bd_num}';
		var co_me_id = '${user.me_id}';
		
		$('.btn-comment').click(function(){
			var co_contents = $('.text-comment').val();
			
			if(co_me_id=='') {
				alert('로그인 후 시도하세요');
				return;
			}

			if(co_contents==''){
				alert('내용을 입력하세요');
				return;
			}
			
			var comment = {
					co_me_id : co_me_id,
					co_contents : co_contents,
					co_bd_num : co_bd_num
			};
			//댓글 삽입
			//ajax
			var url = '/comment/insert';
			commentService.insert(url, comment, insertSuccess);
		})
		
		
		//pagination의 번호를 클릭했을때의 댓글 새로고침
		$(document).on('click', '.comment-pagination .page-item', function(){
			console.log("hi");
			var page = $(this).data('page');
			//댓글 새로고침
			var listUrl = '/comment/list?page='+page+'&bd_num='+'${board.bd_num}';
			//commentService.list(listUrl, listSuccess);
			
		});
		
		var listUrl = '/comment/list?page=1&bd_num='+'${board.bd_num}';
		commentService.list(listUrl, listSuccess);
		
		
	});
	
	//리스트 불러오는 함수
	function listSuccess(res){
		var str ='';
		var co_me_id ='${user.me_id}';
        for(tmp of res.list){//res는 Map이라서 여러개가 들어가있음. 그중에서  list를 가져오겠다는 뜻...
        	str += createComment(tmp, co_me_id);
        }
        $('.comment-list').html(str);
        var paginationStr = creatPagination(res.pm);
        $('.comment-pagination').html(paginationStr);
	}
	
	//댓글 등록하기 함수
	function insertSuccess(res){
		if(res){
			$('.text-comment').val('');//기존에 입력한 댓글을 지워줌
			//댓글등록시 댓글목록 새로고침
			var listUrl = '/comment/list?page=1&bd_num='+'${board.bd_num}';
			commentService.list(listUrl, listSuccess);
		}else{
			alert('댓글 등록에 실패하였습니다');
		}
	}
	
	function getDateStr(date){
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		var hour = date.getHours();
		var minute = date.getMinutes();
		return year+"-"+month+"-"+day+" "+hour+":"+minute;
	}
	
	function createComment(comment, me_id){
		var str = '';
		str += '<div class="comment-box clearfix">'
		if(comment.co_ori_num != comment.co_num){//대댓인경우
		str += 	'<div class="float-left" style="width:24px;">ㄴ</div>'
		str += 	'<div class="float-left" style="width:calc(100% - 24px);">'
		}else{
		str += 	'<div class="float-left" style="width:calc(100%);">'
		}
		str += 		'<div class="co_me_id" style="font-size:12px; font-weight:bold;">'+comment.co_me_id+'</div>'
		str += 		'<div class="co_contents">'+comment.co_contents+'</div>'
		str += 		'<div class="co_reg_date" style="font-size:11px; color:grey;">'+comment.co_reg_date+'</div>'
		
		if(comment.co_ori_num == comment.co_num){
		str += 		'<button class="btn btn-success btn-rep-comment mr-2">답글</button>'	
		}
		
		if(comment.co_me_id == me_id){
		str += 		'<button class="btn btn-warning btn-mod-comment mr-2">수정</button>'
		str += 		'<button class="btn btn-danger btn-del-comment mr-2">삭제</button>'
		}
		
		str += 	'</div>'
		str += 	'<hr class="mt-3">'
		str += '</div>';
		return str;
	}
	
	//pagenaition하는 str을 만드는 함수
	function creatPagination(pm){
		str = '';
		//prev, next버튼 활성화결정
		var prevDisabled = pm.prev ? '' : 'disabled';
		var nextDisabled = pm.next  ? '' : 'disabled';
		var page = pm.criteria.page;
		//prev출력
		//for문으로 pagination추가
		str += '<ul class="pagination justify-content-center">'+
		    '<li class="page-item '+prevDisabled+'" data-page="'+(pm.startPage-1)+'"><a class="page-link " href="javascript:; ">이전</a></li>';
		for(i = pm.startPage; i<=pm.endPage;i++){
			var currentActive = page == i ? 'active' : '';
			str += '<li class="page-item '+currentActive+'" data-page="'+i+'"><a class="page-link " href="javascript:;">'+i+'</a></li>';
		}
		    
		    str += '<li class="page-item '+nextDisabled+'" data-page="'+(pm.endPage+1)+'"><a class="page-link " href="javascript:;" >다음</a></li>'+
		  '</ul>';
		//next출력
		return str;
		
	}
	</script>
</body>
</html>