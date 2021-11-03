package day6;

public class ArraySumEx1 {

	public static void main(String[] args) {
		// 1부터 10 사이짝수를 배열에 저장하고, 저장된 값의 합을 출력하는 코드 작성
		
		
		//방법1
		int [] arr = new int[5];
		int cnt=0;
		int sum=0;
		for(int i=2;i<=10;i++) {
			if(i%2==0) {
				arr[cnt] = i;
				cnt++;
				sum += i;
			}
		}
		for(int i=0;i<5;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("sum = "+sum);
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//방법2 ★★★★★이런생각을하자
		int arr2[] = new int[5];
		for(int i=0;i<5;i++) {
			arr2[i] = 2*i +2;
		}
		
		for(int i=0,sum2=0;i<5;i++) {
			sum2 += arr2[i];
		}
		System.out.println("2부터 10까지의 합 : "+sum);
		
	}

}
