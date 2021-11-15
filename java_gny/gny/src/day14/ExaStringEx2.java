package day14;

public class ExaStringEx2 {

	public static void main(String[] args) {
		/* 다섯명의 이름을 저장하고 저장된 이름 중 홍길동이 있는지 확인*/
		
		String[] names = new String[5];
		String str = "홍길동";
		String str1 = "홍";
		String str2 = "길";
		String str3 = "동";
		
		names[0] = "홍길동";
		names[1] = "김홍길동";
		names[2] = "김연홍";
		names[3] = "홍길동이";
		names[4] = "홍영희";
		
		

		//아 대충 그렇게 보이게만 하자고 ㅋㅋ
		//당연히 틀렸죠?딱걸렸죠?
//		int cnt=0;
//		for(int i=0;i<names.length;i++) {
//			if(names[i].startsWith(str1)&&names[i].endsWith(str3)&&names[i].contains(str2)) {
//				cnt++;
////				System.out.println(str+" 찾음");
//			}
//		}
//		System.out.println("배열에 "+str+"은 "+cnt+" 명 존재");
		
		
		
		/* indexOf	: 이용 가능하나 추가작업이 필요
		 * contains	:이용가능하나 추가작업이 필요
		 * starWith, endsWith : 이용가능하나 추가작업이 필요
		 * equals : 이용가능
		 * */
		
		
		int cnt = 0;
		
		//equals
		cnt = 0;
		for(int i =0;i<names.length;i++) {
			if(names[i].equals(str)) cnt++;
		}
		if(cnt!=0)System.out.println("배열에 "+str+"은 "+cnt+" 명 존재");
		else System.out.println("배열에 "+str+"이 존재하지 않습니다");
		
		
		
		
		//indexOf
		System.out.println("====indexOf====");
		cnt = 0;
		for(String name : names) {
			if(name.indexOf(str)==0 && name.length() ==str.length()) {
				cnt++;
				}
			}
		if(cnt!=0)System.out.println("배열에 "+str+"은 "+cnt+" 명 존재");
		else System.out.println("배열에 "+str+"이 존재하지 않습니다");
		
		//startWith, endsWith
		System.out.println("====startWith, endWith====");
		cnt = 0;
		for(String name : names) {
			if(name.startsWith(str) && name.length() ==str.length()) {
				cnt++;
				}
			}
		if(cnt!=0)System.out.println("배열에 "+str+"은 "+cnt+" 명 존재");
		else System.out.println("배열에 "+str+"이 존재하지 않습니다");
		
		
		//contains
		System.out.println("====contains====");
		cnt = 0;
		for(String name : names) {
			if(name.contains(str) && name.length() ==str.length()) {
				cnt++;
				}
			}
		if(cnt!=0)System.out.println("배열에 "+str+"은 "+cnt+" 명 존재");
		else System.out.println("배열에 "+str+"이 존재하지 않습니다");
		
	}
	

}
