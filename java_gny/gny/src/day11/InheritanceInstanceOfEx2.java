package day11;

public class InheritanceInstanceOfEx2 {

	public static void main(String[] args) {
		P3 p1 = new P3();//객체하나 만들어주기
		System.out.println(p1 instanceof C3);
		P3 p2 = new C3();
		System.out.println(p2 instanceof C3);
		C3 child = null;
		P3 parent = new P3();
		if(parent instanceof C3) {
			child = (C3)parent;
		}
		//형변환이 가능해서 parent와 공유하면 이상한값인 ㅏ오고, 아니면 null이 나올것
		System.out.println(child);
	}

}
class P3{
	
}
class C3 extends P3{
	
}
