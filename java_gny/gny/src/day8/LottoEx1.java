package day8;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx1 {

	public static void main(String[] args) {
		/*  1~45사이의 6개의 로또 번호 생성
		 * 
		 * 
		 * */
		
		int[] lotto;
		int bonus;
		
		//당첨번호 출력
		int size = 6, max = 45, min = 1;
		lotto = lottoArray(size, max, min);
		System.out.println("lotto "+Arrays.toString(lotto));
		bonus = createBonus(max, min, lotto);
		System.out.println("bonus num : "+bonus);
		
		//사용자가 1~45사이 숫자 6개를 중복X로 입력
		
		
		System.out.println("숫자 "+size+"개를 입력");
		int userNum[] = userLotto(size);
		Scanner sc = new Scanner(System.in);
		System.out.println("보너스 번호 1개를 입력");
		int userBonus = sc.nextInt();
		System.out.println(Arrays.toString(userNum)+" "+userBonus);
		sc.close();
//		
		int cnt = containLottoUser(lotto, userNum);
		boolean bCnt = isBonus(bonus, userBonus);
		//등수를 출력 : swith 
		/* 1등 : 6개 전부일치
		 * 2등 : 5개+보너스 번호 일치
		 * 3등 : 당첨번호 5개 일치
		 * 4등 : 당첨번호 4개 일치
		 * 5등 : 당첨번호 3개 일치
		 * 꽝 : 나머지 */
		
		System.out.println("당신의 당첨결과는 "+lottoRank(cnt, bCnt)+" 입니다");

	}
	//당첨번호 중복없는 6개의 숫자 생성
	//1. 중복을 체크하는 메소드 : arr의 0부터 n번까지 중에서 num이 있는지 없는지 체크함
	public static boolean containsArray(int arr[], int n, int num) {
		n = arr.length<n?arr.length:n;
		for(int i=0;i<n;i++) {
			if(arr[i] == num) return true;//num이 있으면 true반환
		}
		return false;//없으면 false반환
	}

	//2. 로또번호를 중복없이 만들기(containsArray사용) => 강사님 버전 함수이름) randomArray
	public static int[] lottoArray(int size, int max, int min) {
		int arr[] = new int[size];
		
		for(int cnt=0;cnt<size;) {
			int rand = (int)(Math.random()*(max-min+1)+min);
			if(!containsArray(arr, cnt, rand)) arr[cnt++] = rand;//두 줄로 적을 수 있지만 한 줄로 처리가능(cnt++해서)
		}
		return arr;
	}
	
	
	//보너스번호 랜덤으로 생성
	public static int createBonus(int max, int min, int[] lotto) {
		int bonus;
		while(true) {
			int rand= (int)(Math.random()*(max-min)+min);
			if(!containsArray(lotto, lotto.length, rand)) {
				bonus = rand;
				break;
			}
		}
		return bonus;
	}
	
	//보너스번호 맞는지 확인
	public static boolean isBonus(int lottoBonus, int userBonus) {
		if(lottoBonus==userBonus) return true;
		else return false;
	}
	
	//사용자가 숫자 size개를 중복없이 입력
	public static int[] userLotto(int size) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[size];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		return arr;
	}
	
	//몇개가 맞는지 확인(containsArray사용해보자)
	public static int containLottoUser(int lotto[], int userNum[]) {
		int cnt = 0;
		for(int i=0;i<lotto.length;i++) {//로또번호 0 1 2 3 4 5 순서로 체크
			if(containsArray(userNum, userNum.length, lotto[i])) cnt++;
		}
		//향상된 for문
//		for(int tmp:lotto) {
//			if(containsArray(userNum, tmp, userNum.length)) cnt++;
//		}
		return cnt;
	}
	
	//맞는 개수에 따라 등수 출력
	public static String lottoRank(int cnt, boolean isBonus) {
		String rank;
		if(cnt==6) {
			rank = "1등";
		}else if(cnt==5&&isBonus==true) {
			rank = "2등";
		}else if(cnt==5&&isBonus==false) {
			rank = "3등";
		}else if(cnt==4) {
			rank = "4등";
		}else if(cnt==3) {
			rank = "3";
		}else rank = "꽝";
		return rank;
	}
	
	
	//맞는 개수에 따라 등수 출력(방법2)
	public static void rank(int []lotto, int bonus, int[] user) {
		int cnt = containLottoUser(lotto, user);
		String res = "";
		switch(cnt) {
		case 6: res = "1등당첨"; break;
		case 5:
			res = containsArray(user, bonus, user.length)?"2등당첨":"3등당첨";
			break;
		case 4: res = "4등당첨"; break;
		case 3 : res = "5등당첨";break;
		default:
			res="꽝";
		}
	}
	
}
