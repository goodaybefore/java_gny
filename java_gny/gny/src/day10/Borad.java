package day10;

class Board{
	//작성자 날짜
	private int num, view;
	private String title, content, writer, date;
	
	//기본 생성자 만들지 않음 : 번호 제목 작성자 등이 꼭 있어야하니까
	public Board(int num, String title, String content, String writer, String date) {
		//view는 기본이 0이니까
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}
	/* 멤버변수를 변경만 하는 기능은 리턴타입이 void(일반적으로) : ex. resize, modify ... */
	//게시글 제목, 내용을 수정하는 기능
	public void modify(String title, String content) {
		this.title = title;
		this.content = content;
	}
	//게시글을 조회하는 기능(게시글 정보 출력)
	public void print() {
		System.out.println("게시글 번호 : "+num);
		System.out.println("게시글 조회수 : "+view);
		System.out.println("게시글 제목 : "+title);
		System.out.println("게시글 내용 : "+content);
		System.out.println("게시글 작성자 : "+writer);
		System.out.println("게시 날짜 : "+date);
	}
	//조회수 1 증가하는 기능
	public void updatdView() {
		view++;
	}
	public void deleteBoard() {
		title = null;
	}
	
}