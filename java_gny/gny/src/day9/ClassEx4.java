package day9;

public class ClassEx4 {

	public static void main(String[] args) {
		/* 학생 1명의 정보를 관리 : 클래스 사용 X 
		 */
		String sName = "그린고등학교", name = "홍길동";
		int grade = 1, classNum=2, num=1;
		

		
		/* 학생 1명의 정보를 관리 : 클래스 사용 O (HighStdInfo) 
		 */
		HighStdInfo std1 = new HighStdInfo("그린고등학교", 1,1,1,"홍길동");
		std1.printStd();
	}

}
