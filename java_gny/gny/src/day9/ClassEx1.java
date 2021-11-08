package day9;

import java.util.Scanner;

public class ClassEx1 {

	public static void main(String[] args) {
		/* 
		 * 
		 */
		Car shCar = new Car(4, "기아", "SUV");
		shCar.brand = "기아";
		shCar.type = "SUV";
		System.out.println("브랜드 : "+shCar.brand);
		shCar.turnOn();
		
		Car car2 = new Car(6, "현대", "SUV");
		System.out.println("브랜드 : "+car2.brand);
		//클래스 객체도 배열처럼 참조변수
		Car car3 = shCar;
		System.out.println("브랜드 : "+car3.brand);
		car3.type = "대형";
		System.out.println("SH's car의 type: "+shCar.type);
		
		System.out.println(shCar.count+"인승");
		
		//기본생성자를 제공하지 않는 Scanner 클래스
//		Scanner sc  = new Scanner(System.in);
	}

}

class Car{//자동차라는 설계도
	//자동차를 만들 때 필요한(관련된) 정보들 => 멤버변수
	String brand;//기아, 현대 등
	String type;//소형차, SUV, 대형 등
	int count;//최대 탑승인원
	int power;//시동
	int speed;//속력
	
	//자동차와 관련된 기능들=>멤버메소드
	//1. 시동 켜는 기능
	void turnOn() {
		System.out.println("시동 On");
	}
	void turnOff() {
		System.out.println("시동 OFF");
	}
	
	
//	Car(){//클래스의 초기값 설정가능
//		//최대 탑승인원
//		count = 1;//최소 1인승
//		brand = "";
//		type = "소형";
//	}
	
	Car(int cnt1, String brand1, String type1){
		count = cnt1;
		brand = brand1;
		type = type1;
	}
	
}