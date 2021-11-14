package day13;

public class ExgStringLengthEx1 {

	public static void main(String[] args) {
		/* int length() : 문자열 길이를 알려주는 메소드*/
		String str = "Hello world";
		System.out.println(str+"의 문자열 길이 "+str.length());//배열의 length는 괄호가 없는데 String은 괄호가 있음!
		
		 System.out.println(str.toString());//String은 toString안써두됨
		 System.out.println(str);
		 
		 
		 /* 문자열이 몇개있는지 확인하는 예제  */
		 String str1 = "abcdababaabbabab";
		 String search = "ab";
		 
		 int index = 0;
		 int cnt = 0;
		 do {
			 index = str1.indexOf(search,index);
			 if(index>=0) {
				 cnt++;
				 index += search.length();
			 }
		 }while(index != -1);
		 
		 System.out.println(str1+"에 "+search+"의 개수:"+cnt);
	}

}
