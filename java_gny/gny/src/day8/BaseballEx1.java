package day8;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballEx1 {

	public static void main(String[] args) {
		/*7일차 야구게임과 lotto 예제로 메소드를 활용한 야구게임 만들어보기
		 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ball 구하는법 완전신박해
		 * 그리고 완전히 틀린거같으니까 집에서 한번 연습해보기... 미쳤나봐 제대로 되는게 없어 특히 Ball 부분
		 * */
		Scanner sc = new Scanner(System.in);
		
		
		
		//computer에게 랜덤한 숫자 세개 주기
		int size = 3, min = 1, max = 9;
		int computer[] = ComputerArray(size, min, max);
		
		System.out.println(Arrays.toString(computer));
		
		//1.사용자가 컴퓨터 숫자 3개를 입력
		int user[] = new int[3];
		
		
		int strike = 0;
		int ball = 0;
		int out = 0;
		boolean answer = true;
		
		while(answer) {//다 맞을 때까지 계속 도는 무한루프
			//숫자입력받기
			inputArray(user, sc);
			
			//스트라이크 개수 계산
			strike = getStrike(computer, user);
			if(strike==3) answer=false;
			
			//볼 개수 계산
			ball = getBall(computer, user);
			
			//스트라이크/볼 개수 출력
			printRes(strike, ball);
			System.out.println();
		}
		
		sc.close();

	}
	
	//중복을 체크하는 메소드
	public static boolean containsArray(int arr[], int n, int num) {
		n = arr.length<n?arr.length:n;
		for(int i=0;i<n;i++) {
			if(arr[i] == num) return true;//num이 있으면 true반환
		}
		return false;//없으면 false반환
	}
	
	//컴퓨터의 야구공 번호를 중복없이 만들기
	public static int[] ComputerArray(int size, int max, int min) {
		int arr[] = new int[size];
		
		for(int cnt=0;cnt<size;) {
			int rand = (int)(Math.random()*(max-min+1)+min);
			if(!containsArray(arr, cnt, rand)) arr[cnt++] = rand;//두 줄로 적을 수 있지만 한 줄로 처리가능(cnt++해서)
		}
		return arr;
	}

	//사용자가 숫자 size개를 중복없이 입력
	public static int[] userBaseballNum(int size) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[size];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		return arr;
	}
	
	/* 기능
	 * 두 배열이 주어지면 스트라이크 개수를 알려주는 메소드
	 * 이름 : getStrike
	 */
	public static int getStrike(int comArr[], int userArr[]) {//이거다시 해보기;;;
		int strike = 0;
		for(int i=0;i<comArr.length;i++) {
			if(comArr[i]==userArr[i]) strike++;
		}
		return strike;
	}
	
	public static int getBall(int comArr[], int userArr[]) {//★★★★★★★★★★★★와 완ㄴ전간단하다.....
		int cnt = 0; // 볼 + 스트라이크 갯수
		for(int tmp:comArr) {
			if(containsArray(userArr, tmp, userArr.length)) cnt++;//같은게 있으면 strike, ball 상관없이 일단 cnt
			
		}
		int ball = cnt - getStrike(comArr, userArr);
		if(ball<=0) return 0;
		else return ball;
		
		//return cnt - getStrike(comArr, userArr);
	}
	
	/* 스트라이크와 볼의 개수가 주어지면 결과를 출력하는 메소드
	 * */
	public static void printRes(int strike, int ball) {
		if(strike==0&&ball==0) System.out.println("3OUT");
		else System.out.println(strike+"Strike, "+ball+"ball");
	}
	
	/* Scanner와 배열이 주어지면 Scanner를 통해 주어진 배열의 길이만큼 배열에 정수를 입력하는 메소드
	 * 매개변수 : Scanner, int[] arr, Scanner sc
	 * 
	 * inputArray*/
	public static void inputArray(int arr[], Scanner sc) {
		System.out.print("숫자를"+arr.length+"개 입력하세요 : ");
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println();
	}
}
