package day12;

public class ExbEqualsEx1 {

	public static void main(String[] args) {
	ExbTestA a1 = new ExbTestA(1, 1);
	ExbTestA a2 = new ExbTestA(1, 1);
	if(a1.equals(a2)) System.out.println("두 객체의 멤변값이 같음");//ExbTestA에 Object를 O.R하지 않으면 equals는 주소를 비교 ==> 다르다는 결과값을 냄
	else System.out.println("달랏");
	//equals로 오버라이딩하면 같다고 뜸
	//근데 ExbTestA에서 오버라이딩 한건데 ExbTestA를 따로 안 불렀음에도 ExbTestA의 equals를 불러오는건 왜??
	//==>a1이 ExbTestA라서 거기꺼 불러온거임 ㅇㅇ

	System.out.println(a1);//toString 사용법
	ExbTestB b = new ExbTestB(1,3);
	System.out.println(b);
	
	}
}
class ExbTestA{
	public int num1;
	public int num2;
	
	public ExbTestA(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	//equals Override하기
	@Override
	public boolean equals(Object obj){
		//비교할 객체가 없는 경우
		if(obj==null) {
			return false;
		}
		//비교 대상과 내가 같은 객체를 공유하는 경우
		//this : 내 객체 => 내 객체의 주소
		//obj : 비교 대상의 주소
		//=> 주소가 같다는건 같은 객체를 공유하는 것 ==>당연히 멤버변수도 같음
		//else if 쓰면 안되나?
		if(this == obj) {
			return true;
		}
		
		//여기까지 위에두개는 고정임 ㅇㅇ
		//근데 위에 this==obj 이해못함 ㅜㅜ
		
		
		
		
		//비교 대상이 최소한 내 클래스로 형변환이 가능해야함.
		//이게 true면 비교 대상이 내 자식클래스의 객체이거나 나와 같은 클래스의 객체라는 뜻
		//클래스끼리로의 멤버변수를 비교하려면 상대방 멤버변수가 뭐가 있는지 알아야 하기 때문
		if(obj instanceof ExbTestA) {
			ExbTestA tmp = (ExbTestA)obj;//가능하면 형변환 해줌
			if(this.num1 == tmp.num1 && this.num2==tmp.num2) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "num1 : "+ num1+", num2 : "+num2;
	}
}

class ExbTestB{
	private int num1;
	private int num2;
	public ExbTestB(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	
	//이클립스는 equals를 쉽게 만들게 제공함
	//1 생성자 만들기
	//2 우클릭 Source Genetrate hasnCode() and equals() 를 generate해주면
	//아까 위에서 한 equals 코드가 자동으로 만들어짐
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())//클래스가 서로 같은지 비교(instanceof로 대체가능)
			return false;
		ExbTestB other = (ExbTestB) obj;//형변환을 하고서
		if (num1 != other.num1)//num1,num2비교
			return false;
		if (num2 != other.num2)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ExbTestB [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
	
	
	
	
	
	
}