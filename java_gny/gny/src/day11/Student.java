package day11;

public class Student {
	private int garde, classNum, num;
	private String name;
	public int getGarde() {
		return garde;
	}
	public void setGarde(int garde) {
		this.garde = garde;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [garde=" + garde + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}
	
	

}
