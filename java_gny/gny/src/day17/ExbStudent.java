package day17;

import java.util.ArrayList;

//ExbScore 클래스사용
public class ExbStudent {
	private int grade, classNum, num;
	private String name;
	//과목 추가하려면 멤번추가... 겟셋추가.. 프로그램에서도 다추가
	//과목이 늘거나 변경되면 해야할 작업이 많아짐 => grade를 클래스로 만들어보기
	private ArrayList<ExbScore> score;//성적 추가할때 과목 여러개 입력 쌉가눙
	
	public ExbStudent(int grade, int classNum, int num, String name, ArrayList<ExbScore> score) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.score = score;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExbStudent other = (ExbStudent) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ExbScore> getScore() {
		return score;
	}

	public void setScore(ArrayList<ExbScore> score) {
		this.score = score;
	}

	
	@Override
	public String toString() {
		return "ExbStudent [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + ", score="
				+ score + "]";
	}
	
	
	
	
}
