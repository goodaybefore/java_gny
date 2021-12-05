package homework3;
import java.util.*;
public class hw3Main {

	public static void main(String[] args) {
		
		//랜덤으로 컴퓨터 숫자 출력(1~100)사이
		//up down 판별 프로그램
		int max= 100, min=1;
		int com = (int)(Math.random()*(max-min+1)+min);
		System.out.println("컴퓨터의 숫자 : "+com);
		
		
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		boolean loop = true;
		while(loop) {
			//숫자 입력받는 메소드
			//public int getNumber(Scanner sc)
			
			int user = getNumber(sc);
			
			//계산프로그램
			//public static boolean upDown()
			int compare= user - com;
			System.out.println(user+" - "+com+" = "+compare);
			if(compare>0) {//사용자가 제시한 숫자가 컴퓨터의 숫자보다 크면 
				System.out.println("down");
				cnt++;
			}else if(compare<0) {
				System.out.println("up");
				cnt++;
			}
			else if(compare==0) {
				cnt++;
				System.out.println("정답입니다! 게임을 종료합니다\n"+cnt+"번째에 성공하였습니다.");
				loop = false;
			}
			
		}
		
	}
	public static int getNumber(Scanner sc) {
		System.out.println("숫자를 입력하세요");
		int num = sc.nextInt();
		return num;
	}

}
