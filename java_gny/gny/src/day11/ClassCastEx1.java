package day11;

public class ClassCastEx1 {

	public static void main(String[] args) {
		/* 일반적으로 =을 기준으로 양옆은 같은 타입이어야한다.
		 * 같은 타입 : 같은 자료형 Or 같은 클래스
		 * 예를들면..*/
		int num=2;
		P2 p1 = new P2();
		P2 p2 = p1;
		
		/*
		 * 상황에 따라서는 = 을 기준으로 타입이 같지 ㅇ않아도
		 * 자동으로 변환이 되어 사용할 수 있다
		 * 예를들면..
		 * int눈 double로 자동형변환이된다.
		 */
		double num2 = num;
		
		//num과 num2가 다른 자료형이고, 넘2의 자료형인 더블이 인트로
		//자동형변환이 불가능하여 명시적 형변호나을 통해 인트로 일시적으로 변환
		num = (int)num2;
		
		
		
		//클래스와 일치하는 객체를 생성하여 저장하는게 당연함
		//예를들면
		C2 c = new C2();
		P2 p = new P2();
		
		//자식클래스를 부모 클래스로 형변환 할 수 있다.(형변환 표시를 따로 안해줘도됨.)
		//오른쪽의 것을 형변환하는것.
		P2 parent = new C2();
		parent.print();
//		parent.hello();
		/*	C2를 이용하여 객체를 만들었지만 P2에는 hello메소드가 없기때문에
		 * hello기능을사용할 수 없다. */
		C2 child1 = new C2();
		P2 parent2 = child1;//자식클랙스 ㄱ개체를 부모클래스 객체로 형변환가능해서 에러가 안나는거임
		parent2.print();
		
		
		//부모클래스의 객체를 자식 클래스의 객체로 클래스형변환 하려면 조건부(명시적)로 가능
		//안되는 경우 : 부모클래스로 객체를 만들어서 형변환하는경우(바로 밑에잇는줄들)
//		C2 child3 = (C2)new P2(); //이거 ㅎㅎ//
//		P2 parent3 = new P2();
//		C2 child4 = (C2)parent3;
//		child3.print();
		
		
		//조건부로 가능한 경우 : 자식 클래스로 객체를 만들어서 부모 클래스로 
		//형변환한 부모 객체의 경우 명시적으로 가능
		P2 parent5 = new C2();//부모가 일단 자식객체 크기만큼 크게 만들어져있어서 명시적으로 형변환이 가능
		C2 child5 = (C2)parent5;//(C2)로 명시해줌
		child5.hello();
		

	}

}

class P2{
	void print() {
		System.out.println("부모입니다");
	}
}

class C2 extends P2{
	void hello() {
		System.out.println("안녕하세요.");
	}
	
}