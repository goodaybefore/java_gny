package day17;

import java.util.*;


public class ExeBaseBallEx1 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크를 이용하여 숫자 야구 게임을 구현해보세요. */
		Scanner sc = new Scanner(System.in);
		
		//컴퓨터 숫자 3개 출력 및 저장
		ArrayList<Integer> com = new ArrayList<Integer>();
		ArrayList<Integer> user = new ArrayList<Integer>();
//		computerNum(com);
		
//		강사님
		int min = 1, max = 9;
		int count = 3;
		int ball = 0, strike = 0;
		try{
			createRandomList(com, min, max, count);
		}catch(Exception e) {
			System.out.println("============================");
			System.out.println("예외 발생 : " + e.getMessage());
			System.out.println("============================");
			System.out.println("숫자 생성에 실패하여 게임을 종료합니다.");
			return;
		}
		System.out.println(com);//컴퓨터의 숫자
		System.out.print("숫자 입력(예 : 1 2 3) : ");
		while(strike < count) {
			int inputResult = inputList(user, min, max, count, sc);
			switch(inputResult) {
			case -1:
				System.out.println("중복된 값을 입력했습니다.");
				break;
			case 1 : 
				System.out.println("잘못된 범위의 점수를 입력");
				break;
			}
			
			//스트라이크 개수 확인
			strike = getStrike(com, user);
			//볼의 개수 확인 : 같은 숫자의 개수 - 스트라이크개수 = 볼의 개수
			ball = getBall(com, user);
			printRes(strike, ball);
			
		}
		
		System.out.println("프로그램 종료");
		
//		while(true) {
//			//사용자 숫자 3개 입력받기
//			ArrayList<Integer> user = new ArrayList<Integer>();
//			System.out.println("중복되지않은 숫자 3개를 입력하세요 : ");
//			getUserNum(user,sc); //사용자숫자
//			System.out.println(user);
//			
//			for(int i=0;i<com.size();i++) {
//				if(isBall(com,user,i)) {
//					if(isStrike(com, user, i)) {
//						strike++;
//					}else {
//						ball++;
//					}
//					
//				}
//			}
//			
//			System.out.println("ball : "+ball+", strike : "+strike);
//			
//			if(strike == 3) {
//				System.out.println("정답! "); break;
//			}
//			else System.out.println("정답이 아닙니다.");
//			System.out.println();
//		}

	}
	//컴퓨터의 리스트를 랜덤으로 뽑는곳
	//수정전
	public static void computerNum(ArrayList<Integer> comArr) {
		Set<Integer> tmp = new HashSet<Integer>();
		int min=1, max=9;
		while(tmp.size()<3) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean isAdd = tmp.add(r);
			//isAdd == true이면 tmp에 숫자가 추가된 경우이기 때문에 리스트에 추가
			if(isAdd == true) {
				comArr.add(r);
			}
		}
	}
	/* 강사님꺼보고 수정한 후 */
	public static void createRandomList(ArrayList<Integer> list, int min, int max, int count) {
		if(list==null) {
			//return ; //리스트가 비어서 파업
			throw new NullPointerException("list가 null 입니다"); //리스트 비어서 에러발생 
		}
		if(min>max) {
			int tmp = min;
			min = max;
			max = min;
		}
		if(count > max-min+1) {
			throw new ArrayIndexOutOfBoundsException("배열에 들어갈 수 있는 숫자 범위가 수가 리스트 크기보다 적습니다.");
		}
		Set<Integer> tmp = new HashSet<Integer>();
		
		while(list.size()<count) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean isAdd = tmp.add(r);
			if(isAdd == true) list.add(r);
		}
		
	}
	
	
	public static void getUserNum(ArrayList<Integer> user, Scanner sc) {
		for(int i=0;i<3;i++) {
			user.add(sc.nextInt());
		}
	}
	
	/* 기능 : 정수 리스트가 주어지면 해당 정수 리스트에 min~max사이의 중복없는 값을 Scanner로 count개 입력받아
	 * 		 제대로 입력했는지 안했는지 알려주는 메소드
	 * 		 0 리턴 : 제대로 입력, 1 리턴 : 범위 잘못, -1 리턴 : 중복
	 * 매개변수 : List, 범위, 갯수, 스캐너
	 * 리턴타입 : int
	 * 메소드명 : inputList*/
	public static int inputList(ArrayList<Integer> list, int min, int max, int count, Scanner sc) {
		
		if(list==null) throw new NullPointerException("list가 null입니다.");
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(count>max-min+1) {
			throw new RuntimeException("범위가 리스트의 크기보다 작아서 만들 수 없습니다");
		}
		if(sc == null) {
			throw new NullPointerException("스캐너가 비어있습니다");
		}
		
		
		int i = 0;
		//clear 없으면 계속 누적됨
		list.clear();
		
		Set<Integer> userSet  = new HashSet<Integer>();
		boolean isOutOfBounds = false;//true = 범위 벗어남 , false = 범위 벗어나지X
		while(i<count) {
			int tmp = sc.nextInt();
			userSet.add(tmp);
			list.add(tmp);
			//범위를 벗어난 숫자일 때
//			if(tmp>max || tmp<min) return 1;
			isOutOfBounds = tmp>=min && tmp<=max?isOutOfBounds:true; 
			
			i++;
		}
		//중복
		if(userSet.size() != count) {
			return -1;
		}
		
//		return isOutOfBounds?1:0;//범위를 벗어났으면 1 벗어나지않았으면 0
		if(isOutOfBounds) return 1;
		else return 0;
	}
	
	/* 기능 :  두 정수 리스트가 주어졌을 때, 두 정수의 같은 번지에 자리한 같은 숫자가 몇개인지 알려주는 메소드
	 * 매개변수 : list1, list2
	 * 리턴타입 : int
	 * 메소드명 : getStrike
	 * */
	public static int getStrike(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		int strike = 0;
		for(int i=0;i<list1.size();i++) {
			if(list1.get(i).equals(list2.get(i))) {
				strike++;
			}
		}
		return strike; 
	}
	public static int getBall(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		int ball = 0;
		for(int i=0;i<list2.size();i++) {
			if(list1.contains(list2.get(i))) {
				ball++;//strike까지 포함시킨  ball의 개수
			}
		}
		ball = ball - getStrike(list1, list2);
		return ball;
	}
	
	public static void printRes(int strike, int ball) {
		if(strike != 0) System.out.println(strike+"S");
		if(ball != 0) System.out.println(ball+"O");
		if(strike ==0 && ball == 0) System.out.println("3O");
		System.out.println("ball : "+ball+", strike : "+strike);
	}
	
	
	
	public static boolean isStrike(ArrayList<Integer> com, ArrayList<Integer>user, int i) {
		if(com.get(i).equals(user.get(i))) {
			return true;
		}
		return false;
	}
	public static boolean isBall(ArrayList<Integer> com, ArrayList<Integer> user, int i) {
		if(com.contains(user.get(i))) {
			return true;
		}
		return false;
	}
}
