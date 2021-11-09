package day10;
import java.lang.Math;//사용하는 클래스 변수랑 메소드들이 생성됨
import java.util.Random;

public class ClassStaticEx1 {

	public static void main(String[] args) {
		//
		//객체 아직 안만들었음. 이 때 클래스변수num2는 생성되었ㄴ지만 객체변수 num1은 ㄴ생성이 안됨
		Test1 t;
//		Test1.print1();//이건안됨(객체메소드니깐)
		Test1.print2();
		Test1 t1 = new Test1();
		System.out.println(t1.num1);
		System.out.println(t1.num2);//노란색경고창 뜸. static이기 때문에 static으로 접근하라는 경고.
		System.out.println(Test1.num2);
//		System.out.println(Test1.num1);//에러뜸. 객체변수인데 객체를 생성하지 않고 클래스를 통해 호출했기 때문.
		Test1 t2 = new Test1();
		t1.num1 = 20;
		t1.num2= 40;
		System.out.println("t1객체변수 n1 : "+t1.num1);
		System.out.println("t1클래스변수 n2 : "+t1.num2);
		System.out.println("t2객체변수 n1 : "+t2.num1);
		System.out.println("t2클래스변수 n2 : "+t2.num2);
		System.out.println(Math.E);
		System.out.println(Math.PI);
		//0~1사이의 랜덤한 실수를 알려주는 클래스메소드
		System.out.println(Math.random());
		//0~10미만의 랜덤한 정수를 알려주는 객체메소드
		Random r = new Random();
		System.out.println(r.nextInt(10));
	}

}
class Test1{
	public int num1=1; //객체변수
	public static int num2=2;//클래스변수
	
	public void print1() {//객체메소드
		System.out.println("num1 : "+num1);//1번 가능
		System.out.println("num2 : "+num2);//1번 가능
		method1();//3번가능
		method2();//4번 가능
		System.out.println("객체메소드");
	}
	public static void print2() {//클래스메소드
//		System.out.println("num1 : "+num1);//5번 불가능
		System.out.println("num2 : "+num2);//1번 가능
//		method1();//3번 불가능
		method2();//4번 가능
		System.out.println("클래스메소드");
	}
	public void method1() {}//객체메소드
	public static void method2() {}//클래스메소드
	
}