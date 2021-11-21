package homework2;
import java.util.*;
/* 
 * day17 패키지의 ExbScore와 ExbStudent클래스를 이용하여 학생 성적을 관리하는 프로그램 만들기
 * 기본기능
 * 1 학생정보추가
 * 2 학생정보출력(전체,개인)
 * 3 학생정보수정
 * 4 학생정보삭제
 * 5 프로그램종료
 * 유의사항
 * 학생정보 추가시 기존에 있는 학생(학년, 반, 번호)과 일치하는 경우, 학생 정보를 추가하지 않음 - 예외처리 해주기
 * */
public class StdScoreProgramMain {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		while(menu!=5) {
			 try {
				//메뉴 입력받기
				 menu = printMenu(sc);
				 
				 
				 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		}
	}
	public static int printMenu(Scanner sc) {
		System.out.println("1 학생정보추가");
		System.out.println("2 학생정보출력");
		System.out.println("3 학생정보수정");
		System.out.println("4 학생정보삭제");
		System.out.println("5 프로그램종료");
		int menu = sc.nextInt();
		return menu;
	}
}
