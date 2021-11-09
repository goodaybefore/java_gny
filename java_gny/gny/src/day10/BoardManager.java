package day10;

import java.util.Scanner;

/*
 * 게시글을 관리하는 클래스
 * 아까 case 1 2 3 4가 했던 일들을 다 얘가 할것
 */
public class BoardManager {
	private Board boardList[];//초기값은 자동으로 null이 됨
	private int cnt;//기본이 0이니 따로 초기화 안해줘도됨. (=boardCnt)
	private Scanner sc;//예외발생을 막기 위해서 스캐너 만들어줌

	
	
	//아직 new를 통해 보드를 안 만들었으니 만들어주겠
	public BoardManager(Scanner sc) {
		//this(10,sc) 이거랑 밑에 두줄이랑 같음(와...ㄷㄷ)
		//this()<-다른생성자호출(public BoardManamger(int size, Scanner sc를 호출하는거임)
		boardList = new Board[10];
		this.sc = sc;//밖에서 만들어서 넘겨준 scanner를 받아오기
	}
	public BoardManager(int size, Scanner sc) {
		this.sc = sc;
		//게시글 개수 제한
		if(size>10)boardList = new Board[size];
		else boardList = new Board[10];
	}
	
	
	//게시글 등록
	public void insertBoard() {
		sc.nextLine();//메뉴에서 입력한 엔터를 처리
		System.out.println("게시글 제목 :");
		String title = sc.nextLine();//엔터를 포함해서 가져가기 때문에 요 밑에 sc.nextLine()을 해줄 필요가 없음
		System.out.println("게시글 내용 :");
		String content = sc.nextLine();//띄어쓰기도 포함해서 들어가나?
		System.out.println("게시글 작성자 :");
		String writer = sc.next();
		System.out.println("게시 날짜 :");
		String date= sc.next();
		//게시글 생성 - 입력받은 정보 초기화 - 배열에 저장
		boardList[cnt] = new Board(cnt+1,title, content, writer, date);
		cnt++;
	}
	
	
	//게시글 조회
	public void displayBoard() {
		System.out.println("조회할 게시글 번호");
		int searchNum = sc.nextInt();
		if(searchNum<=cnt) {
			//게시글 삭제여부확인-> 삭제된 게시글이면 "삭제되었습니다" 출력. 아니면 게시글 조회
			if(boardList[searchNum-1]==null) {
				System.out.println("삭제된 게시글입니다");
				
			}else {
				//조회수 증가
				boardList[searchNum-1].updatdView();
				//게시글출력(조회)
				boardList[searchNum-1].print();
			}
		}
	}
	
	
	//게시글 수정
	public void modifyBoard() {
		System.out.println("수정하려는 게시글 번호");
		int searchNum = sc.nextInt();
		if(boardList[searchNum-1]==null) {
			System.out.println("삭제된 게시글입니다. 수정할 수 없습니다.");
			
		}else {
			sc.nextLine();////게시글 번호에서 입력한 엔터를 처리
			System.out.println("게시글 제목 :");
			String title = sc.nextLine();
			System.out.println("게시글 내용 :");
			String content = sc.nextLine();
			if(searchNum<=cnt) {
				boardList[searchNum-1].modify(title, content);
			}
		}
		
	}
	
	//게시글 삭제
	//자꼬 매개변수가 없는 이유는 멤버변수를 가지고 놀기때문(먼소리야 하ㅠ)
	public void deleteBoard() {
		System.out.println("삭제하려는 번호 : ");
		int searchNum = sc.nextInt();
		if(searchNum<=cnt) {
			boardList[searchNum-1] = null;//생성자의 전체 항목이 다 null이 되는것인가??
		}
		
	}

}
