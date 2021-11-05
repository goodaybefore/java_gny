package day8;

import java.util.Arrays;

public class MethodRandomArrayEx1 {

	public static void main(String[] args) {//강사님 방법 1번 2번 중 뭐가 더 괜찮을까
		/* 1~45사이의 랜덤한 수를 6개 생성하여 배열에 저장하고 출력하는 코드
		 * 메소드 생성하고 호출할것
		 * */
		
		//내방법
		int size = 6, min = 1, max = 45;
		int arr[] = makeRandArray(size, min, max);
		System.out.println(Arrays.toString(arr));
		
		int arr2[] = makeArray(size);
//		System.out.println(makeArrayRand(arr2, 1, 45));
		makeArrayRand(arr2, min, max);
		System.out.println(Arrays.toString(arr2));
		
		
		
		
		
		
		//강사님방법1)
		int array1[] = new int[size];
		exRandArray(array1, min, max);
		
		
	}
	//length : 배열길이, min-max : 숫자범위
	public static int[] makeRandArray(int length, int min, int max) {
		int[] arr = new int[length];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*(max-min+1) +min);
		}
		return arr;
	}
	
	//특정 길이의 배열을 선언하는 메소드
	public static int[] makeArray(int length) {
		int arr[] = new int[length];
		return arr;
	}
	
	//배열을 받고 범위에 따라 숫자 삽입
	//makeArrayRand를 void로 선언해도 되나? => YES 대신 println은 못씀
	public static void makeArrayRand(int arr[], int min, int max) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
//		return arr;
	}
	
	
	
	
	
	
	
	
	
	//강사님방법1)
	//미리 배열을 만들어둠
	//int 안해도됨 void해도 충분함 => 참조변수는 원본값이 같이 바뀌기 때문.
	public static void exRandArray(int arr[], int min, int max) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
	}
	
	
	//방법2 : 메소드가 배열을 만들어주고 return 
	public static int[] exRandArray2(int min, int max, int size) {
		int [] arr = new int[size];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
		return arr;
	}
		
		
	
	

}
