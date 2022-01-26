/**
 * 
 */

let commentService = (function(){
	function setContextPath(contextPath){
		this.contextPath = contextPath;
	}
	function ajaxGet(url, vo, success){
		$.ajax({
		        async : false,
		        type:'POST',
		        url:this.contextPath+url,
		        data:JSON.stringify(vo),
		        //화면이 서버로 보낸 데이터의 타입
		        contentType:"application/json; charset=UTF-8",
		        success : function(res){
					success(res);
		        }
		    });
	}
	
	return{
		name : 'CommentService',
		contextPath : '',
		setContextPath : setContextPath,
		insert : ajaxGet
	}
	
})();