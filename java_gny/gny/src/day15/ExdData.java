package day15;
//제네릭 타입으로 올 수 있는 클래스는..???
//제네릭클래스 와일드카드
public class ExdData<T extends Number>{
	T data;//강사님은 pirvate 안햇는데 왜 private 안하셧지?
	
	public void print() {
//		System.out.println(data+1);//에러남 : 더하기는 숫자변수만 가능하기때문
		System.out.println(data.getClass().getName()+" : "+data);
		//클래스랑 이름 가져
	}
	public ExdData(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public void test(ExdData<?> data) {//?가 double이든 int든 상관없이 data에 double, int string 다 오게 하고싶을때
		System.out.println(data);
		
	}
}

