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
	
	/* 쿼리문에서 limit에 사용되는 인덱스를 계산하는 getter */
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	
}