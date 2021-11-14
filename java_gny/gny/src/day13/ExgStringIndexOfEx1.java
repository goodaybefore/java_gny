package day13;

public class ExgStringIndexOfEx1 {

	public static void main(String[] args) {
		/* int indexOf(int ch) : ch 문자가 몇번지에 있는지 알려주는 메소드
		 * 						 없으면 -1을 알려줌*
		 * int indexOf(String str : str이 몇번지에서 시작하는지 알려주는 메소드
		 * 							없으면 -1을알려줌
		 * int indexOf(int ch, int from) : from번지부터 검색해서 ch가 몇번지에 있는지 알려주는 메소드
		 * 								   없으면 -1 알려줌
		 * int indexOf(String str, int from) : from번지부터 검색해서 str이 몇번지에서 시작하는지 알려주는 메소드
		 * 								   없으면 -1 알려줌
		 * int lastIndexOf(int ch) : 마지막부터 검색해서 ch가 몇번지에 있는지 알려주는 메소드
		 * 							 없으면 -1*/ 
		String str1 = "Hello world";
		System.out.println(str1.indexOf('w'));//스페이스는 문자로 포함을 안시키나?
		System.out.println(str1.indexOf("wo"));//
		
		
		/* str에 l이 몇개 있는지 확인하는 예제*/
		int index = 0;
		int cnt = 0;
		int ch = 'l';
		do {
			index = str1.indexOf(ch, index);//0번째부터 시작해서 l이 어디에 있는지 찾기
			if(index>=0) {//찾았다는거
				cnt++;
				index++;
			}
		}while(index!=-1);
		System.out.println((char)ch+"의 개수 : "+cnt);
	}

}
