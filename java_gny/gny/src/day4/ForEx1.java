package day4;

public class ForEx1 {

	public static void main(String[] args) {//오버플로우, 언더플로우
		// TODO Auto-generated method stub
		/* For문 사용 시 유의사항
		 * 
		 */
		
		//for문 뒤에 ; 붙이지 않기
		//조건식 정확히 설정하기
		
		
		//조건식 부정확 : 무수히 많이 실행됨(무한루프는 아님)
//		System.out.println("1부터 5까지 출력");
//		for(int i=1;i<=5;i--) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
		
		
		System.out.println("INT최대값" + Integer.MAX_VALUE);//INT로 표현가능한 가장큰수
		System.out.println("INT최소값" + Integer.MIN_VALUE);//INT로 표현가능한 가장작은수
		
		int maxNum = Integer.MAX_VALUE +1;
		int minNum = Integer.MIN_VALUE -1;
		
		System.out.println("INT최대값 +1 " + maxNum);// 오버플로우
		System.out.println("INT최소값 -1 " + minNum);//언더플로우
		
		
		
		
		

	}
	

}
