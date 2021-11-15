package day14;

import java.io.FileNotFoundException;

public class ExdThrowEx1 {

	public static void main(String[] args) {


		//Exception은 RuntimeException의 자손클래스가 아니기 때문에 예외를 발생시키면 반드시 예외 처리를 해야함
//		throw new Exception("예외발생");
		
//		throw new RuntimeException("런타임 예외 발생");//얘는 런타임 에러라 예외처리를 안해도 상관 X
//		throwException();//아직 예외처리를 안함 - 그냥실행시키면 여기서 걸림
		
		try {
//			throwException2();
			throwException3(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}//나는 예외 던져주고 끝냈는데 main은 아직 안끝남. 해결하려면 try~catch문을 해주든지 메인뒤에 throws Exception해줘야함

	}
	public static void throwException() throws RuntimeException{ //<<=이것도 실행됨
//	public static void throwException() {
		
		//throw 일을 다 인끝냈는데 하다가 문제 생겼음. 그래서 문제 생겼다고 알려주는거
		//=> return이랑 다름
		throw new RuntimeException();
	
	}
	
	public static void throwException2() throws Exception{//throws Exception : 예외를 해결하는 부분
		
		//throw 일을 다 인끝냈는데 하다가 문제 생겼음. 그래서 문제 생겼다고 알려주는거
		//=> return이랑 다름
		throw new Exception();
		//throw는 예외 발생만 시키고
		//throws가 예외 처리해줌
	
	}
public static void throwException3(int num) throws Exception{
		
		if(num==0) {//NUM==0이면 그냥 예외발생
			throw new Exception("num가 0");
		}
		if(num<0) {
			throw new FileNotFoundException("num는 음수");
		}
		if(num>0) {
			throw new ArithmeticException("num는 양수");
		}
		
		
	
	}


}
