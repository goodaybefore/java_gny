package day10;

import java.util.Scanner;

public class ClassBoardEx2 {

	public static void main(String[] args) {
		/*게시글 관리르 위한 Board클래스 생성 후 테스트*/

		int menu= 0;
		Scanner sc = new Scanner(System.in);
		BoardManager bm = new BoardManager(sc);
		
		//간단한 게시글 관리프로그램
		do {
			//메뉴 입력
			
			menu = printMenu(menu,sc);
			switch(menu) {
			case 1: bm.insertBoard(); break;
			case 2: bm.displayBoard(); break;
			case 3: bm.modifyBoard(); break;
			case 4: bm.deleteBoard(); break;//게시글을 삭제하면 삭제한 위치에 null을 삽입하여 삭제처리
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

/*
 * 게시글을 관리하는 클래스
 */
