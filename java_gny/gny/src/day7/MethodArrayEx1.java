package day7;

import java.util.Arrays;

public class MethodArrayEx1 {

	public static void main(String[] args) {
		/*매개변수가 참조변수(배열)인 경우
		 * 
		 * 예제 내용) 정수형 배열이 주어지면 해당 배열의 모든 값을 콘솔에 출력하는 메소드
		 * 매개변수는 함부로 바꾸면안된당
		 * */
//		int num = 5;
		int arr[] = {5,9,7,5,8,2,3,33,4};
//		System.out.println("arr[0] : "+arr[0]);
//		printArr(arr);
		System.out.println("arr[0] : "+arr[0]);
		sortArr(arr);
		printArr(arr);
		arr = initArray(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void printArr(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
		
	}
	
	//주어진 정수배열을 모두 0으로 초기화하는 메소드
	public static int[] initArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = 0;
		}
		return arr;
	}
	
	
	/*주어진 정수형 배열을 정렬하는 메소드(틀림)*/
	public static int[] sortArr_(int arr[]) {
		
		return arr;//리턴 안해도됨.... 왜냐하면 배열은 원본익 ㅏㅌ이 바뀌니까
	}
	//정답
	public static void sortArr(int arr[]) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	

}
