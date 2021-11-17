package day16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//★★★★ 학생성적 관리 프로그램 
public class ExbListEx2 {

	public static void main(String[] args) {
		/* 학생 성적을 관리하는 프로그램을 만드세요
		 * 메뉴
		 * 1 학생정보 추가
		 * 2 전체 학생 정보 출력
		 * 3 학생 정보 삭제
		 * 4 학생 정보 수정
		 * 5 프로그램 종료
		 * */
		
		/* 그린 고등학생의 국영수 성적을 관리하려한다.
		 * 관리하기 위한 리스트를 만들어보세요*/
		ArrayList<Integer> score = new ArrayList<Integer>();

		ArrayList<ExbStudent> students = new ArrayList<ExbStudent>();
		Scanner sc = new Scanner(System.in);
		
		/* 학생정보 입력받고 계속할건지 물어봐서 y 라고 하면 계속, 아니면 종료 하는 메소드(2지 ver으로 해보기) */
		
		//학생삭제용
		ExbStudent std1 = new ExbStudent("홍길동", 1, 1, 2, 70, 80, 90);
		ExbStudent std2 = new ExbStudent("홍영희", 1, 1, 3, 70, 80, 90);
		ExbStudent std3 = new ExbStudent("홍아람", 1, 1, 4, 70, 80, 90);
		students.add(std1);
		students.add(std2);
		students.add(std3);
		
//		String name = "홍길동";
//		int grade = 1;
//		int stdClass = 1;
//		int stdNum = 2;
//		
		
		int menu=0;
		char next = 'y';
		int searchStd[] = new int[3];
		do {
			menu = printMenu(menu, sc);
			switch(menu) {
			case 1:
				ExbStudent std;
				std = inputStudent(sc);
				ExbStudent tmpStd = new ExbStudent("", std.getGrade(), std.getStdClass(), std.getStdNum(), 0, 0, 0);
				
				if(students.indexOf(tmpStd)>=0) {
					System.out.println("중복된 학생이 존재합니다. 학생삽입을 취소합니다.");
					break;
				}else {
					students.add(std);
					System.out.println("학생 입력이 종료되었습니다.");
				}
				break;
			case 2: //전체 학생 정보 출력
				printStudentList(students);
				System.out.println("출력완료"); 
				break;
			case 3://학생정보삭제
				//public static void removeStd(ArrayList<ExbStudent> stdList)
				if(deleteStudent(students, sc)) {
					System.out.println("학생 정보를 삭제했습니다");
				}else{
					System.out.println("일치하는 학생 정보가 없습니다.");
				}
				break;
//				
				//내가한거
				/* 고칠점 : indexOf안쓴것, equals에 너무 꽂혀있는 것.*/
//				for(int i=0;i<students.size();i++) {
//					if(students.get(i).getGrade()==grade&&students.get(i).getStdClass()==stdClass&&students.get(i).getStdNum()==stdNum) {
//					//equals를 확인
//						System.out.println("일치하는 학생을 찾았습니다"+students.get(i));
//						students.remove(i);//번지로 remove함 (객체로 remove하는거말구)
////						System.out.println("삭제 완료");
//					}else {
//						System.out.println("일치하는 학생이 없습니다.");
//					}
//				}
			case 4: //수정기능
				//수정 원하는 학생의 학년 반 번호 받기
				//이름 학년 반 번호 국어 수학 영어성적 모두 수정
				int index = searchStudentIndex(students, sc);
				if(index>=0) {
					System.out.println("일치하는 학생을 찾았습니다.");
					modifyStudent(students, index, sc);
				}else {
					System.out.println("일치하는 학생을 찾지 못했습니다.");
				}
				break;
				
			default: System.out.println("잘못된 번호를 입력하셨습니다.");
			}
		}while(menu!=5);
		
		}
	
	public static int printMenu(int menu, Scanner sc) {
		System.out.println("메뉴를 선택하세요");
		System.out.println("1. 학생정보추가");
		System.out.println("2. 전체학생정보출력");
		System.out.println("3. 학생정보삭제");
		System.out.println("4. 학생정보수정");
		System.out.println("5. 프로그램 종료");
		menu = sc.nextInt();
		return menu;
		
	}
	public static ExbStudent inputStudent(Scanner sc) {
		System.out.println("학생정보를 입력하세요");
		System.out.println("학년");
		int grade = sc.nextInt();
		System.out.println("학반");
		int stdClass =  sc.nextInt();
		System.out.println("번호");
		int stdNum = sc.nextInt();
		
		sc.nextLine();
		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("성적을 입력하세요");
		System.out.println("국어");
		int kor = sc.nextInt();
		System.out.println("수학");
		int math = sc.nextInt();
		System.out.println("영어");
		int eng = sc.nextInt();
		
		ExbStudent std = new ExbStudent(name, grade, stdClass, stdNum, kor, math, eng);
		return std;
	}
	public static void printStudentList(ArrayList<ExbStudent> stdList) {
		Iterator<ExbStudent> it = stdList.iterator();
		while(it.hasNext()) {
			//리스트에서 하나씩 꺼내서 tmp에 저장
			ExbStudent tmp = it.next();
			System.out.println(tmp);
				
		}
			
	}
	public static void printStd(Iterator<ExbStudent> it) {
		while(it.hasNext()) {
			//리스트에서 하나씩 꺼내서 tmp에 저장
			ExbStudent tmp = it.next();
			System.out.println(tmp);
			
		}
	}
	/* 기능 : 주어진 리스트에 Scanner를 통해 입력받은 학생 정보를 이용하여 삭제하고, 삭제했는지 알려주는 메소드
	 * 매개변수 : ArrayList<ExbStudent> stdList, Scanner sc
	 * 리턴타입 : boolean
	 * 메소드명 : deleteStudent*/
	public static boolean deleteStudent(ArrayList<ExbStudent> stdList, Scanner sc) {
		System.out.println("삭제할 학생의 학년, 반, 번호 입력");
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int stdClass = sc.nextInt();
		System.out.println("번호 : ");
		int stdNum = sc.nextInt();
		ExbStudent searchStd = new ExbStudent("", grade, stdClass, stdNum, 0, 0, 0);
		/* 방법1
		 * 리스트에 특정 객체가 있는지 확인할 때 쓰는 메소드 : contains indexOf
		 * indexOf 사용 : 어디있는지 알려주니깐 => 리스트에 객체가 있으면 번지를 알려주고, 없으면 -1을 알려줌 */

		//int index =  stdList.indexOf(searchStd);
//		if(index >= 0) {
//			stdList.remove(index);
//			//System.out.println("학생정보를 삭제했습니다.");
//			return true;
//		}else {
//			//System.out.println("일치하는 학생 정보가 없습니다.");
//			return false;
//		}
		
		
		/* 방법2
		 * 걍일단 삭제해버고 삭제되면 trun알려주고 안되면 false알려줘
		 * */
		return stdList.remove(searchStd);
	}
	
	
	//학년, 반, 번호로 학생 중복체크하는 메소드(false여야 중복이 없
	//searchStudent(ArrayList<ExbStudent> stdList, Scanner sc)메소드 사용
	public static boolean overlapCheck(ArrayList<ExbStudent> stdList, Scanner sc) {
		if(searchStudentIndex(stdList, sc)>=0) return true;
		else return false;
	}
	//수정될 학생 정보(학년, 반, 번호)를 받고, 일치하는 학생을 서치한 후 존재하면 index번호를, 없으면 -1을 반환하는 메소드
	public static int searchStudentIndex(ArrayList<ExbStudent> stdList, Scanner sc) {
		System.out.println("수정할 학생의 학년, 반, 번호 입력");
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int stdClass = sc.nextInt();
		System.out.println("번호 : ");
		int stdNum = sc.nextInt();
		ExbStudent searchStd = new ExbStudent("", grade, stdClass, stdNum, 0, 0, 0);
		
		int index = stdList.indexOf(searchStd);
		if(index>=0) {
			System.out.println("일치하는 학생 정보를 찾음");
			//학생정보를 다시 받는 메소드
			//public static void modifyStudent(ArrayList<ExbStudent> stdList, int index, Scanner sc)
			return index;
		}else {
			return -1;
		}
	}
	//수정할 정보를 입력하고, 맞는 index 위치의 객체에 해당 정보를 삽입해주는 메소드
	public static void modifyStudent(ArrayList<ExbStudent> stdList, int index, Scanner sc) {
		sc.nextLine();
		System.out.println("이름을 입력하세요(현재 이름 - "+stdList.get(index).getStdName()+" ) : ");
		String newName = sc.nextLine();
		System.out.println("학년을 입력하세요(현재 학년 - "+stdList.get(index).getGrade()+" ) : ");
		int newGrade = sc.nextInt();
		System.out.println("학반을 입력하세요(현재 학번 - "+stdList.get(index).getStdClass()+" ) : ");
		int newClass= sc.nextInt();
		System.out.println("번호를 입력하세요(현재 번호 - "+stdList.get(index).getStdNum()+" ) : ");
		int newNum = sc.nextInt();
		System.out.println("국어성적을 입력하세요(현재 국어성적 - "+stdList.get(index).getKor()+" ) : ");
		int newKor = sc.nextInt();
		System.out.println("수학성적을 입력하세요(현재 수학성적 - "+stdList.get(index).getMath()+" ) : ");
		int newMath = sc.nextInt();
		System.out.println("영어성적을 입력하세요(현재 영어성적 - "+stdList.get(index).getEng()+" ) : ");
		int newEng = sc.nextInt();
		ExbStudent std = new ExbStudent(newName, newGrade, newClass, newNum, newKor, newMath, newEng);
		
		stdList.set(index, std);
		
	}


}
