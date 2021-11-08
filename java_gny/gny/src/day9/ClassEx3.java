package day9;

public class ClassEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HighStdInfo info = new HighStdInfo();
		info.printStd();
		HighStdInfo info2 = new HighStdInfo("그린고등학교",1,1,1,"홍길동");
		info2.printStd();

	}

}

/* 고등학교 학생 정보를 관리하기 위한 클래스
 * 학년 반 번호 이름
 */
class HighStdInfo{
	String schoolName = "고등학교";
	int std_grade=1;
	int std_classNum=1;
	int std_Num=1;
	String std_name="";

//	public HighStdInfo() {
//		schoolName="고등학교";
//		std_grade = 1;
//		std_className = 1;
//		std_num = 1;
//		std_name = "";
//		
//	}
	public HighStdInfo(){//위에꺼랑 똑같은걸 만들어보자
		this("고등학교", 1,1,1,"");//<<이렇게도 표현가능. 단, this()는 생성자 안에서 첫줄에만 사용가능
	}
	
	

	HighStdInfo(String schoolName, int std_grade, int std_classNum, int std_Num, String std_name) {
//		super();
		this.schoolName = schoolName;
		this.std_grade = std_grade;
		this.std_classNum = std_classNum;
		this.std_Num = std_Num;
		this.std_name = std_name;
	}
//	HighStdInfo(String schoolName,int grade, int classNum, int num, String name){
//	std_grade=grade;
//	std_classNum=classNum;
//	std_Num = num;
//	std_name = name;
//	
//}
	
	
	
	public void printStd() {
		System.out.println("학교: "+schoolName);
		System.out.println("학년 : "+std_grade);
		System.out.println("반 : "+std_classNum);
		System.out.println("번호 : "+std_Num);
		System.out.println("이름 : "+std_name);
	}
}