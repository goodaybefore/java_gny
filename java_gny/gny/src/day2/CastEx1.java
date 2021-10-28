package day2;

public class CastEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//자동 자료형변환이 일어남
		
		//정수를 실수에 저장하는 경우 자동자료형변환
		double num1=0;
		
		//크기가 작은 정수를 크기가 큰 정수에 저장하는 경우 자동자료형변환
		byte num2=1;
		int num3=num2;
		
		char ch='a';
		int num4=ch;
		System.out.println("int num4="+num4);
		
		int num5 = (int)0.0;//자동자료형변환이 안되는 경우 명시적형변환을 해줘야함
//		float num6 = 1.23;//에러발생 =>1.23은 double형이기 때문. 1.23뒤에 f붙여줘야함
		
		

	}

}
