<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
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
			<textarea readonly class="form-control" name="bd_contents" rows="10">${board.bd_contents}</textarea>
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
		<!-- test=""에는 조건문이 들어가야함~! -->
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
			

	</div>
</body>
</html>