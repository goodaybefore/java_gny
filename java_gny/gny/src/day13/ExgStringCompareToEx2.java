package day13;

import java.util.Arrays;

public class ExgStringCompareToEx2 {
	public static void main(String[] args) {
		/*문자열 4개를 한 곳에서 관리할 수 있도록 코드를 작성하세요*/
		int size = 4;
		String str[] = new String[size];
		
		//배열에 b d a c 순으로 저장하세요
		str[0] = "b";
		str[1] = "d";
		str[2] = "a";
		str[3] = "c";
		
		//반복문과 compareTo를 이용하여 사전순으로 정렬해보기
		
		for(int i=0;i<str.length-1;i++) {
			System.out.print(i+" ");
			System.out.println(str[i]+"는 "+str[i+1]+"보다 "+str[i].compareTo(str[i+1]));
		}
		
		boolean check = true;
		while(check) {
			
			int cnt=0;//양수카운트(양수가 하나라도 있으면 다시 while문 돈다
			//compareTo결과가 양수이면 두 글자의 순서 바꿔버리기
			for(int i = 0;i<str.length-1;i++) {
				if(str[i].compareTo(str[i+1])>0) {
					String tmp = str[i];
					str[i] = str[i+1];
					str[i+1] = tmp;
					cnt++;
				}	
			}
			for(String tmp : str) {
				System.out.print(tmp+" ");
			}
			System.out.println();
			if(cnt==0) check = false;
			
		}
		
		
		
		
	}

}
