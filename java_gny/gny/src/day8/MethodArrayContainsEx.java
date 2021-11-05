package day8;

import java.util.Arrays;

public class MethodArrayContainsEx {

	public static void main(String[] args) {
		/* 배열이 다음과같이 주어지고, 정수가 주어졌을때 정수가 배열에있ㄲ는 값인지 아닌지 확인하는 메소드를 만들기
		 * ★★★★★★★★★★★★★★방법2 잘 보기
		 * 
		 * 
		 * 1~45사이 랜덤한 수 생성하여 저장하는 코드
		 * */
		int lotto[] = {5,18,23,35,40,1};
		int num = 35;
		//num가 배열에 잇는지 없는지 확인하는 메소드
		int myNum[] = {5, 1, 37, 35, 23, 6};
		
		//방법1
		boolean check;
//		check = checkNum(lotto, num);
//		if(check==true) System.out.println("lotto번호에 "+num+"이 존재함");
//		else System.out.println("lotto번호에 "+num+"이 존재하지 않음");
		
		
		//방법2
		
//		check = containsArray(lotto, num, 2);//num=35일때 여기서는 존재하지 않는다고 뜸(5,18중엔 35가 없기때문에)
//		if(check==true) System.out.println("lotto번호에 "+num+"이 존재함");
//		else System.out.println("lotto번호에 "+num+"이 존재하지 않음");
		
		
		System.out.println();
		int lotto2[] = lottoArray(6, 1, 45);
		System.out.println(Arrays.toString(lotto2));
		
	}
	public static boolean checkNum(int arr[], int num) {
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i]==num) return true;//맞는 숫자 있으면 바로 true 출력
//		}
		//위에꺼 향상된 for문 사용하기
		
		for(int tmp:arr) {
			if(tmp == num) return true;
		}
		return false;//끝까지 true가 안나오면 false출력
	}
	
	
	/*방법2
	 * ★★★★★★★★★★★★★★★★배열과 정수가 주어지면 배열 0번지부터 n 번지중에 num이 있는지 없는 지알려주는 메소드
	 * */
	public static boolean containsArray(int[] arr, int num, int n) {
		n = arr.length<n?arr.length:n;//★★★★요거중요 : arr의 길이가 n 보다 작으면 n은 arr의 길이가 됨★
		for(int i=0;i<n;i++) {
			if(arr[i] == num) return true;//같은게 있으면 true반환
		}
		return false;
	}
	
	
	//1~45 사이의 중복없는 난수를 생성 후 저장
	
	
	public static int[] lottoArray(int size, int min, int max) {
		//size만큼 배열 생성
		int arr[] = new int[size];
		
		//ㅏ선생님방법
		for(int cnt = 0;cnt<size;) {
			int rand = (int)(Math.random()*(max-min+1)+min);
			if(!containsArray(arr, rand, cnt)) arr[cnt++] = rand;//arr배열의 0번지부터 cnt번지 중에 rand숫자가 있는지 확인 : 없으면 false반환
		}
		
		
		
		/*내꺼... 0 0 0 0 0 0 만 나옴...ㅠㅠ
		 * for(int i=0;i<arr.length;i++) {
			while(true) {
				int rand = (int)(Math.random()*(max-min+1)+min);
				check = containsArray(arr, rand, i);//같은게 있으면 true반환
				if(check == false) {
					arr[i] = rand;
				}else break;
				
			}
		}*/		
		
		return arr;
	}
	

}
