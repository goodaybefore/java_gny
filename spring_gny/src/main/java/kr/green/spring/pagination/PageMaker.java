package kr.green.spring.pagination;

import lombok.Data;

@Data
public class PageMaker {
	//총 게시글 개수 : end페이지를 결정할 때 활용 또는 게시글 번호를 연속되게 출력할 때 활용
	private int totalCount; 
	private int startPage; //시작페이지
	private int endPage; //마지막페이지
	private boolean prev; //이전버튼 활성화 여부
	private boolean next; //다음버튼 활성화 여부
	private int displayPageNum; //한 pagination에서 보여주는 페이지 개수
	private Criteria criteria; // 현재 선택된 페이지 정보
	
	/* endPage, startPage, prev, next 값 계산 */
	public void calcData() {
		/* starPage와 endPage는 현재 페이지 정보인 criteria와 displayPageNum을 이용하여 계산
		 * displayPageNum이 10이고 현재 페이지가 3페이지면 startPage = 1, endPage = 10이 되도록 계산 */
		//((현재페이지)/(한번에표시되는페이지개수))=>를 올림해서 한번에표시되는페이지개수를 곱해준다
		endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);
		
		startPage = (endPage - displayPageNum)+1;
		/* 총 콘텐츠 갯수를 이용하여 마지막 페이지 번호를 계산 */
		int tempEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		//현재페이지에서 만들 수 있는 가장 마지막 페이지 번호
		//(전체게시글수)/(한번에에서가질수있는페이지개수) 
		
		/* 현재 페이지에 계산된 현재 페이지메이커의 마지막 페이지 번호와 실제 마지막 페이지 번호를 비교하여
		 * 작은 값이 마지막 페이지 번호가 됨 */
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		/*
		 * pagination설정에 따라 달라질 수 있음.
		 * 다음 버튼을 클릭하면 현재 페이지에서 다음 페이지로 이동
		 * 현재 페이지가 1페이지면 다음 버튼을 클릭하면 2페이지로 이동
		 * 이전 버튼을 클릭하면 현재페이지에서 이전 페이지로 이동
		 * */
		//위 설정에서 이전버튼은 1페이지에서만 비활성화시키면 됨
		prev = criteria.getPage() == 1 ? false : true;
		//prev = startPage == 1 ? false : true; //StartPage가 1페이지이면 이전버튼을 비활성화
		
		//위 설정에서 다음버튼은 마지막페이지에서만 비활성화시키면 됨
		next = criteria.getPage() == tempEndPage? false: true;
		//next = endPage * criteria.getPerPageNum() >= totalCount ? false:true;
	}

	public PageMaker(int totalCount, int displayPageNum, Criteria criteria) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.criteria = criteria;
		calcData();
	}
	
	
}