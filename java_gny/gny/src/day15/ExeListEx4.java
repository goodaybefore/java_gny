package day15;
import java.util.*;
public class ExeListEx4 {

	public static void main(String[] args) {
		int size = 5;
		Scanner sc = new Scanner(System.in);
		
		//방법2
		//contains indexOf, remove 등을 안써서 equlas 오버레이 안해줘도 되는데 걍일단하삼
		ArrayList<ExeToDo> todoList2 = new ArrayList<ExeToDo>();
		for(int i=0;i<size;i++) {
			
			System.out.println((i+1)+"번째 할일의 시간 : ");
			String time = sc.nextLine();
			System.out.println((i+1)+"번째 할일 : ");
			String todo = sc.nextLine();
//			ExeToDo todoObj = new ExeToDo(time, todo);
//			todoList2.add(todoObj);
			todoList2.add(new ExeToDo(time, todo));
			
//			todoList2.add(new ExeToDo(sc.nextLine(), sc.nextLine()));//내가원래했던건데....time이 추가될줄 몰랏엇어 ㅎ
		}
		System.out.println(todoList2);
		
		sc.close();

	}

}
//오늘의 할일을 관리하는 class 만들어서 진행
class ExeToDo{
	String time;//접근제한자 그냥 머 대충 디폴트로
	String todo;
	
	@Override
	public String toString() {
		return "ExeToDo [시간=" + time + ", 내용 =" + todo + "]\n";
	}
	
	public ExeToDo(String time, String todo) {
		this.time = time;
		this.todo = todo;
		
	}
	public ExeToDo(ExeToDo t) {
		time = t.time;
		todo = t.todo;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExeToDo other = (ExeToDo) obj;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (todo == null) {
			if (other.todo != null)
				return false;
		} else if (!todo.equals(other.todo))
			return false;
		return true;
	}
	
}