package day6;

public class ArrayMultiDimensionEx1 {

	public static void main(String[] args) {
		/* 한 학년을 관리하기 이ㅜ한 이차원 배열을 선언 및 생성
		 * 한 학년은 최대 10반까지.
		 * 한 반에 최대 30명까지 배치
		 * */
		
		int std[][] = new int[10][30];
		//1반 30번의 성적에 80을 입력
		std[0][29] = 80; 
		
		//고등학교 모든 학년 학생의 성적을 관리하기위한 배열 선언
		int [][][] highScore = new int[3][10][30]; //3학년, 10반씩, 30번까지

	}

}
