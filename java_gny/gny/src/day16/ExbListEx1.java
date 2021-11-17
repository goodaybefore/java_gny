package day16;
import java.util.*;
public class ExbListEx1 {
	//만든 학생 클래스를 ArrayList로 선언하고 인자를 넣은 후 iterator로 출력
	//이거 바탕으로 학생정보 관리 프로그램 만들어보기
	public static void main(String[] args) {
		/* 그린 고등학생의 국영수 성적을 관리하려한다.
		 * 관리하기 위한 리스트를 만들어보세요*/
		ArrayList<Integer> score = new ArrayList<Integer>();

		//과목명도 리스트에 들어가야하나?
		//score만 들어가면 되는건가?
		//관리를 어떻게 하는거징
		
		score.add(87);
		score.add(90);
		score.add(75);
		

//		Iterator<Integer> it = score.iterator();
//		int count=0;
//		while(it.hasNext()) {
//			Integer tmp = it.next();
//			System.out.print(tmp + (count==score.size()-1?"\n" : ", "));
//			count++;
//					
//		}
		
		/* 방법1) 국영수 성적을 각각 리스트로 만들어서 관리하는 방법
		 * - 번지가 같으면 같은 학생의 성적이라는 가정이 필요.
		 * 
		 * 방법2) 국영수 성적을 같이 다룰 수 있는 클래스를 만들어서 활용하는 방법*/
	
		
		//방법2 해보기!
		//해냈다! 그리고 강사님 수업 들으면서 추가한 것..
		ArrayList<ExbStudent> students = new ArrayList<ExbStudent>();
		ExbStudent std1 = new ExbStudent("홍길동",1, 1, 32, 87,90,75);
		//==나는 여기까지만하고 std에 추가하고 프린트함
		
		
		//강사님 : Scanner로 입력하고 출력하기
		Scanner sc = new Scanner(System.in);
		
		/* 학생정보 입력받고 계속할건지 물어봐서 y 라고 하면 계속, 아니면 종료 하는 메소드(2가지 ver으로 해보기) */
		//메소드1
		//insertStd(sc, students);
		
		
		//메소드2
		
		char next = 'y';
		while(next=='y' || next=='Y') {
			ExbStudent std;
			/*내가한것
			std = insertStd(sc);
			std = insertStd2(sc);*/
			//students 리스트에 저장
			
			
			//강사님)메소드1 : inputStudent 이용 : 강사님은 이 방법을 더 추천(기능이 하나 들어가있으므로... 메소드2는 두가지 기능 들어가있음)
//			std = inputStudent(sc);
//			students.add(std);
			
			//강사님)메소드2 : inputStudent2 이용
			inputStudent2(sc, students);
			
			
			
			System.out.println("계속하시겠습니까? (계속 하려면 y나 Y 입력) ");
			next = sc.next().charAt(0);
			if(next!='y') break;
		}
		
		
		
		
		/* iterator를 이용해서 입력받은 학생정보 출력 - iterator 많이 써보깅!*/
		Iterator<ExbStudent> it = students.iterator();
//		printStd(it);
//		printStudentList(students);

		
		sc.close();
		

	}
	//위의 코드를 이용하여 학생 정보를 입력하는 메소드와 학생정보 출력하는 메소드 만들어보기
	/* 메소드1)
	 * 기능 : Scanner를 이용하여 학생 정보와 성적을 입력받아 입력받은 학생 정보를 알려주는 메소드
	 * 매개변수 : Scanner sc
	 * 리턴타입 : 입력받은 학생정보 => ExbStudent
	 * 메소드명 : inputStudent
	 * */
//	public static ExbStudent inputStudent(Scanner sc) {
//		System.out.println("학생정보를 입력하세요");
//		System.out.println("학년");
//		int grade = sc.nextInt();
//		System.out.println("학반");
//		int stdClass =  sc.nextInt();
//		System.out.println("번호");
//		int stdNum = sc.nextInt();
//		
//		sc.nextLine();
//		System.out.println("이름");
//		String name = sc.nextLine();
//		System.out.println("성적을 입력하세요");
//		System.out.println("국어");
//		int kor = sc.nextInt();
//		System.out.println("수학");
//		int math = sc.nextInt();
//		System.out.println("영어");
//		int eng = sc.nextInt();
//		
//		ExbStudent std = new ExbStudent(name, grade, stdClass, stdNum, kor, math, eng);
//		return std;
//	}
	
	
	/* 메소드2)
	 * 기능 : Scanner를 이용하여 학생 정보와 성적을 입력받아 입력받은 학생 정보를 주어진 리스트에 넣어주는 메소드
	 * 매개변수 : Scanner sc, ArrayList<ExbStudent> stdList
	 * 리턴타입 : void
	 * 메소드명 : inputStudent2
	 * */
	public static void inputStudent2(Scanner sc, ArrayList<ExbStudent> stdList) {
//		ExbStudent std = inputStudent(sc);
		//만든 학생정보를 객체로 만들어서
		//students 리스트에 저장
//		stdList.add(std);
		
		
	}
	
	
	
	/* 기능 : 학생 리스트가 주어지면 주어진 학생 정보들을 출력하는 메소드
	 * 매개변수 : 학생 리스트 => ArrayList<ExbStudent> stdList
	 * 리턴타입 : void
	 * 메도스명 : printStudentList*/
//	public static void printStudentList(ArrayList<ExbStudent> stdList) {
//		Iterator<ExbStudent> it = stdList.iterator();
//		while(it.hasNext()) {
//			//리스트에서 하나씩 꺼내서 tmp에 저장
//			ExbStudent tmp = it.next();
//			System.out.println(tmp);
//			
//		}
//		
//	}
	
	
	//메소드1(내가한거)
	public static void insertStd(Scanner sc, ArrayList<ExbStudent> students) {
		char next = 'y';
		while(next=='y' || next=='Y') {
			/* nextLine을 이용하는 경우,
			 * 앞에서 Scanner를 통해 입력받은 값 중, 엔터가 사라지지 않는 상황이면
			 * 실제 사용하려는 nextLine 앞에 nextLine()을 한 번 더 입력해야함.*/
			System.out.println("학년");
			int grade = sc.nextInt();
			System.out.println("학반");
			int stdClass =  sc.nextInt();
			System.out.println("번호");
			int stdNum = sc.nextInt();
			
			/* nextLine을 이용하는 경우,
			 * 앞에서 Scanner를 통해 입력받은 값 중, 엔터가 사라지지 않는 상황이면
			 * 실제 사용하려는 nextLine 앞에 nextLine()을 한 번 더 입력해야함.
			 * 만약 nextLine을 맨처음 Scanner로 받는다면, nextLine()을 한 번 더 안 써줘도된다.*/
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
			
			//만든 학생정보를 객체로 만들어서
			ExbStudent std = new ExbStudent(name, grade, stdClass, stdNum, kor, math, eng);
			//students 리스트에 저장
			students.add(std);
			
			System.out.println("계속하시겠습니까? (계속 하려면 y나 Y 입력) ");
			next = sc.next().charAt(0);
			if(next!='y') break;
		}
	}

	//메소드2(내가한거 - 무한루프에 걸림....ㅠ)
	public static ExbStudent insertStd2(Scanner sc) {
		char next = 'y';
		String name = "";
		int grade = 0, stdClass = 0, stdNum =0, kor = 0, math=0,eng=0;
		while(next=='y' || next=='Y') {
			/* nextLine을 이용하는 경우,
			 * 앞에서 Scanner를 통해 입력받은 값 중, 엔터가 사라지지 않는 상황이면
			 * 실제 사용하려는 nextLine 앞에 nextLine()을 한 번 더 입력해야함.*/
			System.out.println("학년");
			grade = sc.nextInt();
			System.out.println("학반");
			stdClass =  sc.nextInt();
			System.out.println("번호");
			stdNum = sc.nextInt();
			/* nextLine을 이용하는 경우,
			 * 앞에서 Scanner를 통해 입력받은 값 중, 엔터가 사라지지 않는 상황이면
			 * 실제 사용하려는 nextLine 앞에 nextLine()을 한 번 더 입력해야함.
			 * 만약 nextLine을 맨처음 Scanner로 받는다면, nextLine()을 한 번 더 안 써줘도된다.*/
			sc.nextLine();
			System.out.println("이름");
			name = sc.nextLine();
			System.out.println("성적을 입력하세요");
			System.out.println("국어");
			kor = sc.nextInt();
			System.out.println("수학");
			math = sc.nextInt();
			System.out.println("영어");
			eng = sc.nextInt();
		}
		//만든 학생정보를 객체로 만들어서
		ExbStudent std = new ExbStudent(name, grade, stdClass, stdNum, kor, math, eng);
		return std;
	}
	public static void printStd(Iterator<ExbStudent> it) {
		while(it.hasNext()) {
			//리스트에서 하나씩 꺼내서 tmp에 저장
			ExbStudent tmp = it.next();
			System.out.println(tmp);
			
		}
	}
}

/* 상속을 받으려면 a는b이다가 성립되어야함
 * 여기서는 내가 "고등학교"클래스를 만들고싶다 하면
 * class ExbHighStudent extends ExbStudent : 고등학생은 학생이다.*/
//class ExbStudent{
//	//private : 외부에서 멤버변수에 직접 접근하지 못하게 하기 위해서
//	private String stdName;
//	private int grade;
//	private int stdClass;
//	private int stdNum;
//	private int kor;
//	private int math;
//	private int eng;
//	
//	//생성자는 멤버변수를 쉽게 초기화하기위해서 만든다.
//	public ExbStudent(String stdName, int grade, int stdClass, int stdNum, int kor, int math, int eng) {
//		this.stdName = stdName;
//		this.grade = grade;
//		this.stdClass = stdClass;
//		this.stdNum = stdNum;
//		this.kor = kor;
//		this.math = math;
//		this.eng = eng;
//	}
//	
//	//toString 추가 : 멤버변수를 문자열로 쉽게 확인하기 위해서
//	
//	@Override
//	public String toString() {
//		return "["+stdName+"] "+grade+"학년 "+  stdClass+"반 "+ stdNum+"번 "+"["+" 국어 : "+kor+" 수학 : "+math+" 영어 : "+eng+"]";
//	}
//
//	
//	
//	
//	public String getStdName() {
//		return stdName;
//	}
//
//	
//	public void setStdName(String stdName) {
//		this.stdName = stdName;
//	}
//
//	public int getGrade() {
//		return grade;
//	}
//
//	public void setGrade(int grade) {
//		this.grade = grade;
//	}
//
//	public int getStdClass() {
//		return stdClass;
//	}
//
//	public void setStdClass(int stdClass) {
//		this.stdClass = stdClass;
//	}
//
//	public int getStdNum() {
//		return stdNum;
//	}
//
//	public void setStdNum(int stdNum) {
//		this.stdNum = stdNum;
//	}
//
//	public int getKor() {
//		return kor;
//	}
//
//	public void setKor(int kor) {
//		this.kor = kor;
//	}
//
//	public int getMath() {
//		return math;
//	}
//
//	public void setMath(int math) {
//		this.math = math;
//	}
//
//	public int getEng() {
//		return eng;
//	}
//
//	public void setEng(int eng) {
//		this.eng = eng;
//	}
//	
//	
//	//외부에서 멤버변수의 값을 확인하거나 수정하기 위해서
//	
//	
//}