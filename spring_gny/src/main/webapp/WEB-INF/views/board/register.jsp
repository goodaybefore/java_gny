<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>register</title>
	<!-- summernote -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<div class="body container">
		<h1>게시글 등록</h1> ${bd_ori_num}
		<form action="<%=request.getContextPath() %>/board/register" method="post" enctype="multipart/form-data">
			<div class="form-group">
			  <input type="text" class="form-control" placeholder="제목" name="bd_title">
			</div>
			<div class="form-group">
			  <textarea type="text" class="form-control" placeholder="내용" rows="10" name="bd_contents"></textarea>
			</div>
			<!-- 첨부파일 등록 -->
			<div class="form-group">
		        <label>첨부파일(최대3개)</label>
		        <input type="file" class="form-control" name="files2"/>
		        <input type="file" class="form-control" name="files2"/>
		        <input type="file" class="form-control" name="files2"/>
		    </div>
		    
		    <c:if test="${bd_ori_num != null}">
		    	<input type="hidden" name="bd_ori_num" value="${bd_ori_num}">
		    </c:if>
		    <c:if test="${bd_type == null }">
		    	<input type="hidden" name="bd_type" value="일반">
		    </c:if>
		    <c:if test="${bd_type != null }">
		    	<input type="hidden" name="bd_type" value="${bd_type}">
		    </c:if>
			<button class="btn btn-outline-success col-12">submit</button>
		</form>
	</div>
	<script>
      $('[name=bd_contents]').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 100
      });
    </script>
</body>
</html>