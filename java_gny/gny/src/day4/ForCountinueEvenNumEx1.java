package day4;

public class ForCountinueEvenNumEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 1~10이하의 짝수를 출력하는 코드를 continue 이용하여 작성
		 * 
		 */
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			}else {
				continue;
			}
			
		}

	}

}
