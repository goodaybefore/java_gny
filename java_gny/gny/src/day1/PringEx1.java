package day1;

public class PringEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		int num1 = 10;
		System.out.println(num1);
		System.out.println("num1 : "+num1);
		int num2 = 20;
		char operator = '+';
		System.out.println(num1+operator+num2+"="+num1+num2);//73=1020 이 나옴
		System.out.println(""+num1+operator+num2+"="+num1+num2);//10+20=1020이 나옴
		System.out.println(""+num1+operator+num2+"="+(num1+num2));//10+20=30이 나옴
	}

}
