package day18;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ExfBoard{
	private String title, writer, contents;
	Date date;
	private int postNum, view;
	private static int count = 0;
	
	
	/* 기능 : 주어진 제목, 내용으로 수정하는 메소드
	 * 매개변수 :
	 * 리턴타입 : void
	 * 메소드명 : modify
	 * */
	public void modify(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	
	
	//혹시 임시로 만드는 게시글이 있을 때 사용할 생성자
	//만약 게시글을 등록하기위헤 만든게 아니라 잠깐 뭔가 확인하기위해 만든 생성자
	//게시글을 등록할 때 사용되는 게시글이 아닌, 임시로 쓸 게시글이 필요한 경우 사용하려고 만든 기보 ㄴ생성자
	public ExfBoard() {}
	public ExfBoard(String title, String contents, String writer) {
		this.postNum = postNum;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.date = new Date();
		count++;
		this.postNum = count;
	}


	//count는 postNum을 위해 만든거기 때문에 getter, setter 필요없음
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(date);
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}

	@Override
	public String toString() {//제목 내용 날짜 작성자 순으로
		return "[게시글 번호] : "+postNum+"\n[게시글 제목] : "+title+"\n[게시글 내용] : "+contents+"\n[작성날짜] : "+getDate()+"\n[작성자] : "+writer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass()) {
			return false;
			}
		ExfBoard other = (ExfBoard) obj;
		if (postNum != other.postNum)
			return false;
		return true;
	}
	
	
}