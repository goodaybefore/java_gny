package day17;
import java.util.*;
public class ExcSetEx1 {
//Set 사용
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		/* set의 기능
		 * 1 중복을 허용하지 않는다.
		 * 2 get 없음. set없음 => 왜냐? 특정번지에 접근할 수 없다.
		 *   => Iterator를 사용해야함
		 * */
		
		//중복을 허용하지 않는다
		//1 2 3 1을 add 했을 때, 중복을 허용하지 않기 때문에 마지막 1을 넣지않는다.
		set1.add(1); set1.add(2); set1.add(3); set1.add(1);
		System.out.println(set1);
		
		int min =1, max=9;
		while(set2.size()<3) {
			int r = (int)(Math.random()*(max-min+1)+min);
			set2.add(r);
		}
		System.out.println(set2);
		
		Iterator<Integer> it = set2.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp+" ");
		}
		

	}

}
