package day2;

public class UnaryEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=10, num2=10;
		System.out.println("증가 전:num1="+num1+", num2="+num2);
		System.out.println("증가 중:num1="+ ++num1+", num2="+num2++);
		System.out.println("증가 후:num1="+num1+", num2="+num2);
		
		
		++num1;//12
		num2++;//11
		
		System.out.println("증가 후2:num1="+num1+", num2="+num2);//12 12
		
		

	}

}
