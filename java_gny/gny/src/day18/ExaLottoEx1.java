package day18;
import day17.ExeBaseBallEx1;
import java.util.*;
//★★★★★실행하면 한번만 실행함 ㅡㅡ 머임
public class ExaLottoEx1 {

	public static void main(String[] args) {
		/* 로또 프로그램을 day17 패키지의 야구게임을 활용하여 만들기*/
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		ArrayList<Integer> user = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int max = 45, min = 1; 
		int bonus = 0;
		int cnt = 6;//번호개수
		int total = 0;//몇개 맞았는지
		char ch = 'y';//로또번호 계속 입력할건지 말건지
		
		
		//당첨번호 생성 및 출력
		ExeBaseBallEx1.createRandomList(lotto, min, max, cnt);
		System.out.println("로또번호 : "+lotto);
		
		//보너스 번호 출력
		while(true) {
			bonus = (int)(Math.random()*(max-min+1)+min);
			if(!lotto.contains(bonus)) {
				break;
			}
		}
		
		
		 
//		createBonus(lotto, max, min);
		System.out.println("bonus : "+bonus);
		//반복
		while(ch=='y'||ch=='Y') {
			//사용자가 로또번호 입력		
			/* 1등 : 6개 전부일치
			 * 2등 : 5개+보너스 번호 일치
			 * 3등 : 당첨번호 5개 일치
			 * 4등 : 당첨번호 4개 일치
			 * 5등 : 당첨번호 3개 일치
			 * 꽝 : 나머지 */
			System.out.print("로또번호를 입력하세요 : ");
			int inputResult= ExeBaseBallEx1.inputList(user, min, max, cnt, sc);
			
			switch(inputResult) {
			case -1:
				System.out.println("중복된 값을 입력했습니다.");
				break;
			case 1 : 
				System.out.println("잘못된 범위의 점수를 입력");
				break;
			}
			
			
			//당첨 갯수 확인
			total = ExeBaseBallEx1.getBall(lotto, user) + ExeBaseBallEx1.getStrike(lotto, user);
			
			switch(total) {
			case 6: System.out.println("1등당첨");break;
			case 5:
				if(user.contains(bonus)) {
					System.out.println("2등당첨");break;
				}else {
					System.out.println("3등당첨");break;
				}
			case 4: System.out.println("4등당첨");break;
			case 3: System.out.println("5등당첨");break;
			default : System.out.println("꽝");
			}
			
			System.out.println("더 하시겠습니까?(y/n)");
			ch = sc.next().charAt(0);
			
		}
			
	}
	public static boolean containsList(int random, ArrayList<Integer> list) {
		for(int i = 0;i<list.size();i++) {
			if(list.get(i).equals(random)) return true;
		}
		return false;
	}
	public static int createBonus(ArrayList<Integer> list, int max, int min) {
		int random = (int)(Math.random()*(max-min+1)+min);
		while(true) {
			if(!containsList(random, list)) {
				return random;
			}
		}
		
	}
}
