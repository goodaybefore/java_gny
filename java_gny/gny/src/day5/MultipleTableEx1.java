package day5;

public class MultipleTableEx1 {

	public static void main(String[] args) {
		// 2단에서 9단까지 구구단을 출력하는 코드
		
//		for(int i=2;i<=9;i++) {
//			for(int j=1;j<=9;j++) {
//				System.out.println(i+" * "+j+" = "+(i*j));
//			}
//			System.out.println();
//		}
		
		
		//for문 + while으로
		int i=2,j;
		for(i=2;i<=9;i++) {
			j=1;
			while(j<=9) {
				System.out.println(i+" * "+j+" = "+(i*j));
				j++;
			}
		}
		
		//이중while으로
		i=2;
		while(i<=9) {
			j=1;
			while(j<=9) {
				System.out.println(i+" * "+j+" = "+(i*j));
				j++;
			}
			i++;
		}
		
		
		
		

	}

}
