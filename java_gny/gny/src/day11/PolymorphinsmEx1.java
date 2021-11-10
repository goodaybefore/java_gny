package day11;

public class PolymorphinsmEx1 {

	public static void main(String[] args) {
		Phone p = new Phone();
		SmartPhone sp = new SmartPhone();
		FolderPhone fp = new FolderPhone();
		calling(p);
		calling(sp);
		calling(fp);
		
		Human h1 = new Human(p);
		Human h2 = new Human(sp);
		Human h3 = new Human(fp);
		//<매개변수의 다형성>
		//상속관계가 아닌 애들은 다형성을 따질 수 없음.
		//다형성 하면 바로 상속을 떠올려야함
		//사람들이 각각 다른 폰을 가지고 있어도 받는 기능을 실행할수있음
		
		h1.p.get();
		h2.p.get();
		h3.p.get();

	}
	
//	//매개변수의 다형성 
	//매개변수에 객체들의 공통된 부모로 설정하여 다양한 클랫의 객체들이 올 수 있게 하는 것
//	public static void calling(SmartPhone p) {
//		p.call();
//	}
	public static void calling(Phone p) {
		p.call();//이거 하나만 놔둬도 됨
	}
//	public static void calling(FolderPhone p) {
//		p.call();
//	}

}
class Human{
	Phone p;//밑에 세개를 한꺼번에 묶을수잇음
//	SmartPhone sp;
//	FolderPhone fp;
//	Phone p;
	public Human(Phone p) {
		this.p = p;//원래 복사생성자 통해서 해줘야하는데 당장편하려고대충이케씀
	}
	
	
}
class Phone{
	public String phoneNum;
	public void call() {
		System.out.println("전화를 거는 중");
	}
	public void get() {
		System.out.println("전화를 받는 중");
	}
}
class SmartPhone extends Phone{
	public void touch() {
		System.out.println("핸드폰 터치중");
	}
}
class FolderPhone extends Phone{
	public void fold() {
		System.out.println("핸드폰 접음");
	}
}

//class tt extends String{//String 클래스는 final클래스로 정의되어있어서 할수없음
//}

//class tt extends String{//String 클래스는 final클래스로 정의되어있어서 할수없음
//}