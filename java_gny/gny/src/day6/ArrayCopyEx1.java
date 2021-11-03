package day6;

public class ArrayCopyEx1 {

	public static void main(String[] args) {//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		int num1=10;
		/* 정수형변수 num2 선언 하고 num2에 num1의 값을 저장
		 * 
		 * 일반(기본자료형)변수는 = 이용하여 값을 복사하더라도
		 * 이후 원본값이 바뀌어도 복사본의 값이 같이 바뀌지 않음
		 */
		
		int num2=num1;
		System.out.println("num1 "+num1);
		System.out.println("num2 "+num2);
		
		
		num1=20;
		System.out.println("num1 "+num1);
		System.out.println("num2 "+num2);
		
		
		/* 참조변수는 = 을 이용하여 복사를 하면 값이 복사되는게 아니라 ★주소를 공유★한다
		 * 따라서 값이 바뀌면 함께 바뀐다.
		 * ★★★★★서로 값이 다르게 하고싶으면 for문을 이용하여 복사한 후 원본값을 바꿔준다.*/
		
		//arr2에 arr1을 복사
		int arr1[] = {1, 2, 3};
		int arr2[] = arr1;
		
		arr1[0] = 10;
		
		System.out.print("arr1 : ");
		for(int tmp:arr1) {
			System.out.print(tmp+" ");
		}
		
		System.out.print("arr2 : ");
		for(int tmp:arr2) {
			System.out.print(tmp+" ");
		}
		//결과 : 둘다 1 2 3 으로 같음
		//★★★★★★★★★★★★★★★★★★arr1[0]의 값을 바꿀 경우 arr2의 값도 같이 바뀜
		
		
		
		
		/* 배열을 제대로 복사하기 위해선 모든 번지에 있는 값을 하나씩 복사(for문 사용)*/
		
		
		
		
		
		
		
	}

}
