package homework1;

import java.util.Scanner;


public class DrawProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu=0;
		int size = 10;
		//Shape 리스트 선언
		ExaShape shape[] = new ExaShape[size];
		
		//등록 되어있는 도형들의 숫자를 세는 변수
		int cnt = shapeCnt(shape);	
		
		//프로그램 종료(숫자 5)를 입력할 때 까지 계속 동작하는 프로그램
		do {
			//메뉴 받아오기
			menu = printMenu(menu, sc);
			
			switch(menu) {
			//1 도형그리기
			case 1:
				if(cnt>size) {
					System.out.println("도형 배열이 꽉 찼습니다.");
					break;
				}
				//사각형 or 타원을 그리고 배열에 저장하는 메소드
//				shape = drawMenu(shape, sc, cnt);
				drawMenu(shape, sc, cnt);
				//현재까지 배열에 등록된 길이만큼의 cnt를 구하는 메소드
				cnt = shapeCnt(shape);
//				System.out.println("배열에 등록된 도형의 개수 : "+cnt);
				break;
				
				
			/* 2 다시 실행
			 * - 실행 취소한 도형을 다시 나타나게 하는 기능
			 * - 더이상 다시 실행할 수 없는 경우를 고려해야함
			 * - draw후 다시 draw할 경우 "다시실행"기능을 사용할 수 없다.(취소한 수행이 없기 때문) */
			case 2:				
				cnt = restore(cnt, shape);
				break;
			
			/* 3 실행 취소
			 * - 그려진 도형을 그리기 이전으로 돌아가게 하는 기능*/
			case 3:
				cnt = cancelMenu(cnt);
				break;
			
			/* 4 도형 확인
			 * - 첫번째 도형부터 순서대로 출력
			 * - 순서대로 print하기*/
			case 4:
				printMenu(shape, cnt);
				break;
			
			//5보다 큰 수를 입력하면 경고문 출력
			
			}
			
			
		}while(menu!=5);
		
	}

	//static이 왜 들어가야하는지..(자동으로 추가됐음..ㅠㅠ)
	public static int printMenu(int menu, Scanner sc) {
		System.out.println("1. 도형 그리기");
		System.out.println("2. 다시 실행");
		System.out.println("3. 실행 취소");
		System.out.println("4. 도형 확인");
		System.out.println("5. 프로그램 종료");
		menu = sc.nextInt();
		return menu;
	}
	
	public static void drawMenu(ExaShape[] shape, Scanner sc, int cnt) {
		//현재 가리키고 있는 cnt번지의 배열칸이 null인지 확인
		//(!null)인 경우, 실행취소하고 아직 지워지지 않은 도형이 남아있다는 것이므로 청소싹싹 해줘야함
		if(shape[cnt]!=null) {
			System.out.println("뒷부분이 null이 아닙니다!!!");
			//null이 아니라면 cnt 다음 번지부터 끝까지 null인지 아닌지 확인하면서 전부 null으로 변환해줌
			//계속 null인지 아닌지 확인하는 이유는 전체 배열의 사이즈가 클 때 반복을 최대한 덜 하기 위해서
			for(int i=cnt;i<shape.length-cnt+1;i++) {
				if(shape[i]==null) break;
				shape[i] = null;
			}
		}else {
			System.out.println("뒷부분에 추가해도 OK");
		}
		
		System.out.println("그릴 도형의 번호를 선택하세요(1 사각형 / 2 타원)");
		int drawShape = sc.nextInt();
		System.out.println("도형의 네 점을 입력하세요(ex. 10 10 0 0)");
		int left = sc.nextInt();
		int top = sc.nextInt();
		int right = sc.nextInt();
		int bottom = sc.nextInt();
		
		if(drawShape == 1) {
			shape[cnt] = new ExaRect(left, top, right, bottom);
			cnt++;
			System.out.println("사각형을 그렸습니다");
		}else if(drawShape == 2) {
			shape[cnt] = new ExaEllipse(left, top, right, bottom);
			cnt++;
			System.out.println("타원을 그렸습니다");
		}else {
			System.out.println("번호를 잘못 입력하였습니다.");
		}
//		return shape;
	}
	
	public static int shapeCnt(ExaShape[] shape) {
		int cnt = 0;
		for(int i=0;i<shape.length-1;i++) {
			if(shape[i] != null) cnt++;
		}
		return cnt;
	}

	public static int cancelMenu(int cnt) {
		//실행취소 한번만 하면, nowCnt(현재 나타내는 번지)는 등록된 도형의 개수 -1
		//nowCnt가 0보다 작아지는 순간 배열엔 아무것도 없는 것이기 때문에 실행 할 수 없게됨.
		
		//nowCnt : 내가 현재 도형 배열에서 가리키고 있는 번지 수를 나타내는 변수
		int nowCnt = cnt-1;
//		System.out.println("현재 가리키는 cnt : "+nowCnt);
//		System.out.println("실행취소");
		if(nowCnt<0) {
			System.out.println("더이상 실행취소 할 수 없습니다");
			return cnt;
		}
		
		return nowCnt;
	}
	

	public static void printMenu(ExaShape[] shape, int cnt) {
		if(shape[0]==null) {
			System.out.println("출력할 도형이 없습니다");
			return;
		}
		for(int i=0;i<cnt;i++) {
			shape[i].print();
		}
	}

	public static int restore(int cnt, ExaShape[] shape) {
		//현재 가리키고 있는 번지(그리기 메뉴로 도형을 그리면 새 도형을 저장할 번지)에 아무것도 존재하지 않을 때는 break;
		
		//System.out.println("현재 등록된 도형의 개수"+shapeCnt(shape));
		//System.out.println("현재 가리키고 있는 번지(cnt) : "+cnt);
		if(shape[cnt]==null) {
			System.out.println("다시 실행할 동작이 존재하지 않습니다");
			return cnt;
		}else {
			cnt++;
			System.out.println("그리기 취소한 도형을 다시 실행하였습니다");
		}
		
		return cnt;
	}
	
}
