package day2;

public class IfNumEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//num>0 이면 양수출력 0이면 0출력, 음수면 음수출력
		int num = -1;
		if(num>0) {
			System.out.println("양수");
		}else if(num==0){
			System.out.println("0");
		}else {
			System.out.println("음수");
		}
		
		if(num>0) {
			System.out.println("양수");
		}

	}

}
