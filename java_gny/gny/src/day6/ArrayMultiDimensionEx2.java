package day6;

public class ArrayMultiDimensionEx2 {

	public static void main(String[] args) {
		/* 구구단 2단에서 9단 전체를 배열에 저장하여 출력
		 * */
		int [][] multiTable = new int[10][10];//[9][9]가 아닌 [10][10]의 이유는? <- 0번째를 안 쓰려고
		
		for(int i=2;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				multiTable[i][j] = i*j;
				System.out.println(i+" * "+j+" = "+ multiTable[i][j]);
			}System.out.println();
		}
		
		

	}

}
