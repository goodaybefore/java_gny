package kr.green.green.pagination;

import lombok.Data;

@Data
public class Criteria {
	private int page; 
	private int perPageNum;
	private String type;
	private String search;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.type = "일반";
		this.search = "";
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page <= 0 ? 1 : page;
		this.perPageNum = perPageNum <= 0 ? 10 : perPageNum;
		this.type = "일반";
		this.search = "";
	}

	/* 쿼리문에서 limit에 사용되는 인덱스를 계산하는 getter */
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	public String getTypeTitle() {		
		if(type != null && type.equals("공지")) return "공지사항";
		return "게시글";
	}
}