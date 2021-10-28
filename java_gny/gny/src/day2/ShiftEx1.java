package day2;

public class ShiftEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=12;// 00000000 00000000 00000000 00001100
		int leftShift = num1 << 2;
		int rightShift = num1 >> 2;
		System.out.println("leftShift "+leftShift+", rightShift "+rightShift);
		//leftShift => 00000000 00000000 00000000 00110000 : 16+32=48
		//rightShift => 00000000 00000000 00000000 00000011 : 2+1= 3
		

	}

}
