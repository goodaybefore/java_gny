package test1;

public class HighSchoolStudent {
	private String school;
	private int stdGrade, stdClass, stdNum;
	private String stdName;
	
	public HighSchoolStudent(String school, int stdGrade, int stdClass, int stdNum, String stdName) {		
		this.school = school;
		this.stdGrade = stdGrade;
		this.stdClass = stdClass;
		this.stdNum = stdNum;
		this.stdName = stdName;
	}
	
	public void print() {
		System.out.println(school+"고등학교 "+stdGrade+"학년 "+stdClass+"반 "+ stdNum+"번 "+stdName+" 학생");
	}
}
	
