package day4;

public class ContinueEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* continue가 if문과 같이 나와야하는 이유를 보여주는 예제
		 * 
		 */
		
		//단독으로 나오면 컨티뉴 밑에있는게 의미가 없어짐
//		for(int i=1;i<=5;i++) {
//			continue;
//			System.out.println("HELLO");//continue때문에 실행할 일이 없어서 에러발생
//			
//		}
		
		for(int i=1;i<=5;i++) {
			if(i==2) {
				System.out.println("WORLD");
				continue;
			}
			System.out.println("HELLO");
			
		}
		
		

	}

}
