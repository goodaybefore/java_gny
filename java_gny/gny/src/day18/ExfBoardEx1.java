package day18;
import java.text.SimpleDateFormat;
import java.util.*;
public class ExfBoardEx1 {

	public static void main(String[] args) {
		/* 게시글을 관리하는 프로그램 만들기(10일차 예제)
		 * 배열 O 리스트 X 
		 * 기능
		 * 1 게시글등록
		 * 2 게시글확인
		 * 3 게시글수정
		 * 4 게시글삭제
		 * 5 프로그램종료*/
		
		
		/* 내가한거
		 * Scanner sc = new Scanner(System.in);
		
		
		
		List<Board> board = new ArrayList<Board>();
		int boardCnt = 0;
		int menu = 0;
		
		
		Board b = new Board(0, "타이틀","작성자", "내용dddddddddddddddddddddddddd", presentTime());
		board.add(b);
		boardCnt=1;//임의로 추가해줬기 때문에 boardCnt를 +1 해줌
		
		while(menu !=5) {
			try {
				menu = selectMenu(sc);
				switch(menu) {
				case 1 :
					//public static void insertBoard(Scanner sc, List<Board> board)
					//제목 작성자 내용 입력받고 date는 자동으로 str변환하여 Board객체에 저장
					insertBoard(sc, board, boardCnt);
					boardCnt++;
					break;
					
				case 2 ://게시글 확인
					//public static void printBoard(List<Board> board, Scanner sc)
					printBoard(board);
					break;
					
				case 3 ://게시글 수정
					//public static void modifyBoard(List<Board> board, Scanner sc)
					modifyBoard(board, sc);
					break;
					
				case 4 : //게시글 삭제
					//public static int deleteBoard(List<Board> board, Scanner sc, int boardCnt)
					boardCnt = deleteBoard(board, sc, boardCnt);
					break;
				}
			}catch(IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
				System.out.println("게시글에 아무것도 존재하지 않습니다.");
			}catch(InputMismatchException e) {
				System.out.println("입력오류");
				sc.nextLine();
			}catch(NoSuchElementException e) {
				System.out.println("없는 공간의 값을 호출하고 있습니다.");
			}
			catch(Exception e) {
				System.out.println("============================");
				System.out.println("예외발생 : "+e.getMessage());
//				e.printStackTrace();
				System.out.println("============================");
			}
			
		}*/
		
		//강사님
		Scanner sc = new Scanner(System.in);
		List<ExfBoard> list = new ArrayList<ExfBoard>();
		String strMenu[] = {
				"1 게시글 등록",
				"2 게시글 확인",
				"3 게시글 수정",
				"4 게시글 삭제",
				"5 프로그램종료"	
		};
		ExfBoard b = new ExfBoard("타이틀", "내용dddddddddddddddddddddddddd","작성자");
		list.add(b);
		while(true) {
			
			printMenu(strMenu);
			try {
				int menu = sc.nextInt();
				if(menu ==1) {
					regiseter(list, sc);
				}else if(menu == 2) {
//					System.out.println(list);
					display(list);
					
				}else if(menu == 3) {
					
					modify(list, sc);
				}else if(menu == 4) {
					delete(list, sc);
				}else if(menu == 5) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("잘못된 메뉴입니다.");
				}
			}catch(InputMismatchException e) {
				System.out.println("예외발생! 잘못입력");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//강사님이 만든 메소드
	public static void printMenu(String[] strMenu) {
		bar();
		for(String tmp : strMenu) {
			System.out.println(tmp);
		}
		bar();
		System.out.print("메뉴 선택 : ");
	}
	public static void bar() {
		System.out.println("=======================");
	}
	public static void regiseter(List<ExfBoard> list, Scanner sc) {
		System.out.println("게시글 등록");
		//게시글 정보 입력 : 제목 내용 작성자
		sc.nextLine();
		System.out.println("제목을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.println("작성자를 입력하세요 : ");
		String writer = sc.nextLine();
		System.out.println("내용을 입력하세요 : ");
		String contents = sc.nextLine();
		
		ExfBoard board = new ExfBoard(title, contents, writer);
		list.add(board);
		System.out.println("게시글이 등록됨");
		bar();
	}
	public static void display(List<ExfBoard> list) {
		for(ExfBoard tmp:list) {
			bar();
			System.out.println(tmp);
			bar();
		}
	}
	public static void modify(List<ExfBoard> list, Scanner sc) {
		System.out.println("수정기능");
		System.out.println("수정할 게시글 정보 입력");
		System.out.println("수정할 게시글 번호");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.println("제목을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.println("내용을 입력하세요 : ");
		String contents = sc.nextLine();

		ExfBoard tmp = new ExfBoard();
		tmp.setPostNum(num);
		tmp.setContents(contents);
		
		int index = list.indexOf(tmp);
		//수정할 게시글이 있으면 수정 후 안내문구 출력
		if(index >=0) {
			list.get(index).modify(title, contents);
			System.out.println("게시글 수정이 완료되었습니다.");
		}else {//없으면 없다구 출력
			System.out.println("없는 게시글이 없습니다.");
		}
	}
	public static void delete(List<ExfBoard> list, Scanner sc) {
		System.out.println("삭제기능");
		System.out.println("게시글을 삭제합니다");
		System.out.println("번호 입력 : ");
		int num = sc.nextInt();

		ExfBoard tmp = new ExfBoard();
		tmp.setPostNum(num);
		int index = list.indexOf(tmp);
		System.out.println(index);
		
		if(index>=0) {
			list.remove(index);
			System.out.println("삭제 완료");
		}else {
			System.out.println("없는 게시글 입니다.");
		}
	}
	
	
	
	//내가 만든 메소드
	public static int selectMenu(Scanner sc) {
		int menu = 0;
		System.out.println("1 게시글 등록");
		System.out.println("2 게시글 확인");
		System.out.println("3 게시글 수정");
		System.out.println("4 게시글 삭제");
		System.out.println("5 프로그램종료");
		menu = sc.nextInt();
		return menu;
	}
	public static void insertBoard(Scanner sc, List<Board> board, int boardCnt) {
		
		if(sc==null) throw new NullPointerException("스캐너가 없습니다.");//이거 왜 노란줄일까 => 그럴 일이 절대 없다는뜻
		
		sc.nextLine();
		System.out.println("제목을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.println("작성자를 입력하세요 : ");
		String writer = sc.nextLine();
		System.out.println("내용을 입력하세요 : ");
		String contents = sc.nextLine();
		//자동으로 현재시간 삽입
		String dateStr = presentTime();
		
		//예외처리
		if(title==""||writer==""||contents=="") throw new NullPointerException("제목, 작성자, 내용을 모두 입력해주세요.");
		 
		
		
		Board b = new Board(boardCnt,title, writer, contents, dateStr);
		board.add(b);
		System.out.println("게시글이 추가되었습니다.");
	}
	public static String presentTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String dateStr = format.format(date);
		return dateStr;
	}
	public static void printBoard(List<Board> board) {
		//예외처리
		//예외 1 게시글이 아무것도 없다면?
		if(board.size()==0) throw new IndexOutOfBoundsException("printBoard Error");
		
		System.out.println("전체 게시글을 출력합니다.");
		for(int i=0;i<board.size();i++) {
			System.out.println(board.get(i));
			System.out.println();
		}
	}
	public static void modifyBoard(List<Board> board, Scanner sc) {
		//어차피 발생할 예외 빠르게 발생시켜주기
		if(board.size()==0) throw new IndexOutOfBoundsException("modify Error");
		
		
		System.out.println("수정할 게시글의 번호를 입력하세요 : ");
		int postNum = sc.nextInt();
		//int가 아니고 string 입력했을때 예외처리 어떻게 할지
		
		sc.nextLine();
		System.out.println("게시글 제목 입력 : ");
		String title = sc.nextLine();
		System.out.println("게시글 내용 입력 : ");
		String contents = sc.nextLine();
		String dateStr = presentTime();
		
		//새 객체 하나 만들기
		board.get(postNum);
		board.get(postNum).setTitle(title);
		board.get(postNum).setContents(contents);
		board.get(postNum).setDate(dateStr);
		
		System.out.println(board.get(postNum));
		System.out.println("수정완료");

		
	}
	public static int deleteBoard(List<Board> board, Scanner sc, int boardCnt) {
		//예외처리 : String 입력시?
		//예외처리2 : boardCnt=0일때
		
		System.out.println("게시글을 삭제할 번호를 입력하세요 : ");
		int num = sc.nextInt();
		board.remove(num);
		System.out.println("삭제되었습니다.");
		
		//삭제했으니 boardCnt를 -1해줘야지
		return boardCnt-1;
	}
	

}
//내가한것
//강사님과의 차이 : Date 객체 사용유무
class Board{
	private String title, writer, contents;
	private String date;
	private int postNum, view;
	
	public Board(int postNum, String title, String writer, String contents, String date) {
		this.postNum = postNum;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.date = date;
	}


	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	
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
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	
	//게시글 번호만 가지고 검색하겠다
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (postNum != other.postNum)
			return false;
		return true;
	}


	@Override
	public String toString() {//제목 내용 날짜 작성자 순으로
		return "[게시글 번호] : "+postNum+"\n[게시글 제목] : "+title+"\n[게시글 내용] : "+contents+"\n[작성날짜] : "+date+"\n[작성자] : "+writer;
	}
	
	
}
