/**
 * 
 */
let commentService = (function(){//method들을 이 안에서 구현
	function setContextPath(contextPath){
		this.contextPath = contextPath;
	}
	//ajax Post방식을 사용하여 Object로 전달하고 Object로 받는...메소드
	function ajaxPostJsonToJson(url, comment, success){
		$.ajax({
			//동기화 : 다 끝날때까지 기다림
			async :false, 
		    type:'POST',
		    //서버로 보낸 객체가 VO에 잘 담기기 위하 변형
		    data:JSON.stringify(comment),
		    url: this.contextPath + url,
		    //서버에서 보낸 데이터의 타입
			//server에서 보낸 data의 type
		    //http://localhost:8080/comment/list?bd_num=38&page=1 <-이런거 입력하면 json형태 볼수있음!!!
		    //구성형태 : 
		    /*
		    {
		    	"list" : [].
		    	"pm" : {
		    		"totalCount" : 8,
		    		"startPage" : 1
		    	}
		    }
		    */
		    dataType : "json",
		    //화면이 서버로 보낸 데이터의 타입
		    contentType:"application/json; charset=UTF-8",
		    //ajax성공시
		    success : function(res){
		    	success(res);
			}
		});
	}
	//ajax Get방식으로 url에 데이터를 전달하여 Object로 받는 메소드
	function ajaxGetJson(url, success){
		$.ajax({
			async :false,
			//삭제할 댓글 번호는 노출되어도 상관없기 때문에 get으로 보냄
		    type:'get',
		    url : this.contextPath + url,
		    dataType:"json",
		    success : function(res){
		    	success(res);
		    	}
		    
		    });
	}
	return{
		name : 'commentService',	//commentService를 하나의 객체로 만듦.
		contextPath : '', 
		setContextPath : setContextPath,
		insert : ajaxPostJsonToJson,
		modify : ajaxPostJsonToJson,//insert, modify의 차이는 url과 실행문 뿐.
		list : ajaxGetJson,
		delete : ajaxGetJson
		//메소드명 : 메소드 => 요런식으로 여러개의 method를 추가
	}
})();//(); => 모듈화 시키는 작업이라 js는 붙여줘야함