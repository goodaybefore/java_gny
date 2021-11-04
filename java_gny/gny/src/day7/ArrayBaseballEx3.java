package day7;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayBaseballEx3 {

	public static void main(String[] args) {
		
		//computer에게 랜덤한 숫자 세개 주기
		int computer[] = new int[3];
		int count=0;
		int max =9, min=1; 
		while(count !=3) {
			int rand = (int)(Math.random()*(max-min+1)+min);
			int i;
			for(i=0;i<count;i++) {
				if(computer[i]==rand) break;
			}
			if(i==count) {
				computer[i] = rand;
				count++;
			}
		}
		
		System.out.println(Arrays.toString(computer));
		
		//1.사용자가 컴퓨터 숫자 3개를 입력
		int user[] = new int[3];//1.사용자가 컴퓨터 숫자 3개를 입력
		
		Scanner sc = new Scanner(System.in);
		
		
		
		boolean answer = true;
		
		int strike = 0;
		int ball = 0;
		int out = 0;
		
		while(answer) {//다 맞을 때까지 계속 도는 무한루프
			
			for(int i=0;i<computer.length;i++) {//2. 사용자가 세 수를 무한으로 입력받음
				System.out.print("숫자를 입력하세요 ("+(i+1)+"번째) : ");
				user[i] = sc.nextInt();
			}
			ball = 0;
			strike = 0;

			for(int i=0;i<computer.length;i++) {//ball strike 체크
				for(int j=0;j<user.length;j++) {
					if(computer[i]==user[j]) {
						if(i==j) {//strike check
							strike++;
						}else ball++;//ball check
					}
					if(strike==3) {
						answer = false;
					}
				}
			}
			
			if(strike==0 && ball==0) {
				out=3;//strike도 없고 ball도 없으면 3out 출력
				System.out.println("3 OUT 다시 시도하세요");
			}

			System.out.println("strike : "+strike+", ball : "+ball);
			System.out.println();
		}
		
		
		
		
		

		
/* do while문 : 무조건 한 번은 실행되는 프로그램 : 콘솔프로그램
 * 		strike = 0;
		ball = 0;
		out = 0;
 * 		do{
			
			for(int i=0;i<computer.length;i++) {//2. 사용자가 세 수를 무한으로 입력받음
				System.out.print("숫자를 입력하세요 ("+(i+1)+"번째) : ");
				user[i] = sc.nextInt();
			}
			ball = 0;
			strike = 0;

			for(int i=0;i<computer.length;i++) {//ball strike 체크
				for(int j=0;j<user.length;j++) {
					if(computer[i]==user[j]) {
						if(i==j) {//strike check
							strike++;
						}else ball++;//ball check
					}
					if(strike==3) {
						answer = false;
					}
				}
			}
			
			if(strike==0 && ball==0) {
				out=3;//strike도 없고 ball도 없으면 3out 출력
				System.out.println("3 OUT 다시 시도하세요");
			}

			System.out.println("strike : "+strike+", ball : "+ball);
			System.out.println();
		} while(answer==true);
*/
		
		sc.close();
		

	}

}
