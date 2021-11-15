package day14;

public class ExaStringReplaceEx1 {

	public static void main(String[] args) {
		/* String replace(char oldCh, char newCh
		 * 문자열에 oldCh라는 문자가 있으면 newCh로 바꾸고, 바뀐 문자열을 알려주는 메소드
		 * ***기존 문자열은 바뀌지 않음*/

		String str = "I love JAVA";
		System.out.println(str.replace('A', 'a'));
		System.out.println(str);
		
		//썼을 때 바뀌었으면 하면?
		str = str.replace('A', 'a');
		str = str.replace("JaVa", "Spring");
		System.out.println(str);
		
	}

}
