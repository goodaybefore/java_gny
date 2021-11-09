package day10;

import java.util.Scanner;

public class ClassBoardEx1 {

	public static void main(String[] args) {
		/*게시글 관리르 위한 Board클래스 생성 후 테스트*/
//		Board b1 = new Board(1,"제목1","내용1");
//		b1.print();
		
		int size=10;
		Board boardList[] = new Board[size];
//		boardList[0] = new Board(1,"제목1","내용1","작성자","21-11-09");
//		boardList[0].print();
		Scanner sc = new Scanner(System.in);
		int menu= 0;
		int boardCnt=0;//현재까지 저장된 게시글 개수
		int searchNum;
		String title, content, writer, date;
		
		//간단한 게시글 관리프로그램
		do {
			//메뉴 입력
			
			menu = printMenu(menu,sc);
			switch(menu) {
			case 1://게시글등록
				sc.nextLine();//메뉴에서 입력한 엔터를 처리
				System.out.println("게시글 제목 :");
				title = sc.nextLine();//엔터를 포함해서 가져가기 때문에 요 밑에 sc.nextLine()을 해줄 필요가 없음
				System.out.println("게시글 내용 :");
				content = sc.nextLine();//띄어쓰기도 포함해서 들어가나?
				System.out.println("게시글 작성자 :");
				writer = sc.next();
				System.out.println("게시 날짜 :");
				date= sc.next();
				//게시글 생성 - 입력받은 정보 초기화 - 배열에 저장
				boardList[boardCnt] = new Board(boardCnt+1,title, content, writer, date);
				boardCnt++;
				break;
				
			case 2://조회
				System.out.println("조회할 게시글 번호");
				searchNum = sc.nextInt();
				if(searchNum<=boardCnt) {
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
//				else {
//					System.out.println("없는 게시글 입니다.");
//				}//삭제하고나서 없는 게시글이라 뜨느데 이게 머선129				
				
				break;
			case 3://수정
				System.out.println("수정하려는 게시글 번호");
				searchNum = sc.nextInt();
				if(boardList[searchNum-1]==null) {
					System.out.println("삭제된 게시글입니다. 수정할 수 없습니다.");
					
				}else {
					sc.nextLine();////게시글 번호에서 입력한 엔터를 처리
					System.out.println("게시글 제목 :");
					title = sc.nextLine();
					System.out.println("게시글 내용 :");
					content = sc.nextLine();
					if(searchNum<=boardCnt) {
						boardList[searchNum-1].modify(title, content);
					}
				}
				
				
				
				break;
				
			//게시글을 삭제하면 삭제한 위치에 null을 삽입하여 삭제처리
			case 4://삭제
				System.out.println("삭제하려는 게시글 번호");
				searchNum = sc.nextInt();
				if(searchNum<=boardCnt) {
					boardList[searchNum-1] = null;//생성자의 전체 항목이 다 null이 되는것인가??
				}
				break;
			case 5: break;
			default:
				
			}
			}while(menu!=5);
		System.out.println("프로그램을 종료합니다.");
		sc.close();
		//
		/*
		 * for(int i=0;i<score.length;i++) {
		 * score[i] = new Score();//실제 학생정보 만들기
		 * }
		 * 
		 */
	}
	public static int printMenu(int menu, Scanner sc) {
		System.out.println("------------");
		System.out.println("1 게시글등록");
		System.out.println("2 게시글조회");
		System.out.println("3 게시글수정");
		System.out.println("4 게시글삭제");
		System.out.println("5 프로그램종료");
		System.out.println("번호를 입력하세요 : ");
		menu = sc.nextInt();
		return menu;
	}

}

