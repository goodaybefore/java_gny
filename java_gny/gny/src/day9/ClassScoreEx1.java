package day9;

import java.util.Arrays;
import java.util.Scanner;

public class ClassScoreEx1 {

	public static void main(String[] args) {
		/* 국어 영어 수학 성적 관리 클래스 만들고
		 * 학생 5명의 성적을 관리하기위한 배열을 만드세요
		 * */
		int size = 3;
		Scanner sc = new Scanner(System.in);
		Score score[] = new Score[size];//5개짜리 배열을 만든거임. 학생정보를 만든게 아님! 그래서 생성자로 실제로 만들어줘야함
		
		for(int i=0;i<score.length;i++) {
			score[i] = new Score();//실제 학생정보 만들기
		}
		for(int i=0;i<score.length;i++) {
			System.out.println("이름 ");
			String name = sc.next();
			System.out.println("국어 ");
			int kor = sc.nextInt();
			System.out.println("영어 ");
			int eng = sc.nextInt();
			System.out.println("수학 ");
			int math = sc.nextInt();
			score[i] = new Score(kor, eng, math, name);
		}
		for(Score tmp : score) {
			tmp.printInfo();//score.printInfo()와 같음
			System.out.println();
		}
		sc.close();
		
		

	}
	

}
class Score{
	//멤버변수
	private int kor, eng, math;
	private String name;
	
	//getter setter만들기
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//기본생성자
	 public Score() {
		 
	 }
	public Score(int kor, int eng, int math, String name) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
	}
	
	
	//학생정보를 출력하는 메소드
	public void printInfo() {
		System.out.println("이름 : "+name);
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("수학 : "+math);
	}
	
	
}
