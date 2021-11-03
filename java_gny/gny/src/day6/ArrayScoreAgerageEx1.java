package day6;
import java.util.*;
public class ArrayScoreAgerageEx1 {

	public static void main(String[] args) {
		/* 배열로 5명의 성적을 입력받아 평균을 구하는 코드
		 * 성적을 배열에 저장. 성적은 정수
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int score[] = new int[5];
		int sum=0;
		double avg=0;
		for(int i=0;i<5;i++) {
			System.out.println((i+1)+"번째 학생의 성적을 입력 : ");
			score[i] = sc.nextInt();
			sum += score[i];
		}
		
		avg = sum/score.length;
//		System.out.println("sum = "+sum);
		System.out.println("avg = "+avg);
		
		
		

	}

}
