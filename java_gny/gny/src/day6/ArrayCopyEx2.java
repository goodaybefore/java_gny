package day6;

public class ArrayCopyEx2 {

	public static void main(String[] args) {
		/* 배열을 제대로 복사하기 위해 배열을 새로 생성하여 for문으로 복사해주기
		 * */
		
		int arr1[] = {1, 2, 3};
		int arr2[] = new int[arr1.length];
		
//		for(int i=0;i<arr1.length;i++) {//향상된 for문 쓰면 안됨! 
//			arr2[i]=arr1[i];//자바에서 제공해주는 기능으로 대체가능!
//		}
		
		//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★대체된 배열복사기능 ArrayCopy기능
		/* src : 원본, scrPos : 원본에서 복사할 시작위치 (source/ destination(목적지))
		 * dest : 복사본, destPos:복사본에서 복사될 시작위치
		 * length : 복사할 길이
		 * arr1의 0번째부터를 arr2의 0번째부터 붙여넣기. 어느만큼? arr1의 길이만큼!
		 * */
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
//		System.arraycopy(arr1, 0, arr2, 0, arr1.length-1); //-1하면 1, 2만 복사됨
		
		arr1[0] = 10;
		
		System.out.println("arr1");
		for(int tmp:arr1) {
			System.out.print(tmp+" ");
		}
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("arr2");
		for(int tmp:arr2) {
			System.out.print(tmp+" ");
		}
		
		
		
	}

}
