package day12;

import day10.Ellipse;

//Ex1에선 super, override 활용
//Ex2에선
public class ExaTestEx2 {

	public static void main(String[] args) {
		/* 1 사각형과 타원을 여러개 저장할 수 있는 배열 만들기
		 * 2 사각형과 타원을 합쳐서 최대 10개까지 저장하는 배열*/
//		int size = 3;
//		ExaRect r[] = new ExaRect[size];
//		Ellipse e[] = new Ellipse[size];
		
		int size = 10;
		ExaShape sList[] = new ExaShape[size];
		//타원 1개, 사각형 2개를 생성하여 배열에 저장해보기
		//클래스형변환, 자식=>부모클래스로 형변환, 자동클래스형변환
		sList[0] = new ExaEllipse(0,0,10,10);
		sList[1] = new ExaRect(10,10,20,20);
		sList[2] = new ExaRect(10,20,20,30);
		sList[3] = new ExaShape(10,10,0,0);
		
		
		//배열에 저장된 도형들을 그려보세요
		//NullPointerException : 객체가 비어있는데 객체의 기능을 사용하려고 할 때 나타나는 에러
//		for(int i=0;i<sList.length-1;i++) {
//			//배열 항목에 null이 있으면 반복문 탈출
//			if(sList[i]==null) break;
//			sList[i].print();
//		}
		
		
		//강사님)
//		for(int i=0;i<sList.length;i++) {
//			/* 도형이 있으면 print()로 출력,
//			 * 없으면 아무것도 안함=>아무것도 안하니까 else를 만들 필요가 없다.
//			 * 도형에 아무것도 없으면 null인 이유 : 
//			 * - 배열은 생성이 되면 타입에 맞는 초기값으로 초기화를 한다.
//			 * - 참조변수는 null로 초기화
//			 * - 도형이 없다 = 도형이 생성되어 저장되지 않았다 = 초기값*/
//			if(sList[i]!=null){
//				sList[i].print();
//			}
//		}
		
		/* 저장된 도형이 타원이면 testE()를 호출하고, 사각형이면 testR()을 호출하세요
		 * 반복문을 이용*/
//		for(int i=0;i<sList.length;i++) {
//			if(sList[i]==null)break;
//			//생성자에 접근해서 testR이나 E가 있는지 확인
//			sList[i].testR();
//		}
		
		
		
		//틀린예제
		//객체==클래스이름 할수없음
		/*
		for(ExaShape tmp : sList) {
			if(tmp !=null) {
				if(tmp ==ExaEllipse)
			}
		}*/
		/*
		for(ExaShape tmp : sList) {
			if(tmp !=null) {
				if(tmp instanceof ExaEllipse)
				tmp.tesetE();//tmp는 shape이라 형변환이안됨
			}
		}*/
		for(ExaShape tmp : sList) {
			if(tmp!=null) {
//				tmp.print();
				//클래스형변환
				if(tmp instanceof ExaRect) {
					//도형 tmp를 사각형으로 형변환 시킨 후 testR()출력
					((ExaRect) tmp).testR();
					//위에껄 풀어서 쓰면
					/*ExaRecte = (ExaRect)tmp;//tmp를 사각형으로 변환한 후
					e.testR(); //testR를 출력한것*/
				}else if(tmp instanceof ExaEllipse) {
					((ExaEllipse) tmp).testE();
					/*ExaEllipse e = (ExaEllipse)tmp;//tmp를 타원으로 변환한 후
					e.testE(); //testE를 출력한것*/
				}
			}
		}
		
		System.out.println("=======================");
		for(ExaShape tmp : sList) {
			if(tmp == null) continue;//null이면 넘겨버리고 다음꺼돌아
			print(tmp);
		}
		
	}
	/* 기능 : 매개변수가 사각형이면 사각형 출력. 매개변수가 타원이면 타원이라 출력, 매개변수가 도형이면 도형이라고 출력하는 메소드
	 * 매개변수 : ExaShape s
	 * 리턴타입 : void
	 * 메소드명 : print
	 */
	
	
	//public static 붙여줘야함!
	//이유) 이 메소드를 메인에서 테스트해야하는데 main은 static(클래스)메소드로 되어있음
	//<클래스 변수/메소드와 객체변수/메소드> 참고
	public static void print(ExaShape s) {//도형클래스를 상속받은 애들이기 때문에 무조건 도형을 기준으로 들어옴 ㅇㅅㅇ
		if(s instanceof ExaRect) {
			System.out.println("사각형입니다");
		}else if(s instanceof ExaEllipse) {
			System.out.println("타원입니다");
		}else {
			System.out.println("도형");
		}
	}
	
	

}
//주말과제

