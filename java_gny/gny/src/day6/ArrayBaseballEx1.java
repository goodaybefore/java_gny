package day6;

import java.util.Scanner;

public class ArrayBaseballEx1 {

	public static void main(String[] args) {
		/* 숫자 야구 게임
		 * 컴퓨터가 랜덤으로 1~9사이의 중복되지 않은 세 수를 선택
		 * 사용자는 컴퓨터가 선택한 수 세 개를 맞추는 게임
		 * ==> 사용자가 선택한 세 수를 컴퓨터가 만든 수라고 가정하고 출력하기
		 * * 규칙
		 * 숫자가 맞으면 ball, 위치까지 맞으면 Strike로 출력
		 * 맞는 숫자가 하나도 없으면 3O, 3S는 게임종료
		 * 
		 * 
		 * 예시)
		 * 컴퓨터 : 1 9 5
		 * 사용자 : 1 2 3
		 * => 1S
		 * 
		 * 사용자 : 1 4 5
		 * => 2S
		 * 
		 * 사용자 : 1 5 8
		 * =>1S 1B
		 * 
		 * 사용자 : 5 7 8
		 * =>1B
		 * 
		 * 사용자 : 4 7 8
		 * =>3O
		 * 
		 * 사용자 : 1 9 5
		 * 3S
		 * 
		 * 게임종료
		 * */
		
		
		
		/* 
		 * 1. 사용자가 컴퓨터 숫자 3개를 입력
		 * 2. 
		 */
		
		
		int computer[] = {1,9,5};
		
		
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
