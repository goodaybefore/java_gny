package day13;
/* 도형의 크기 변경, 도형 이동, 도형 그리기 기능을 가진 Draw 인터페이스를 만드세요 */

//abstract쓸필요 없음	기본으로 붙어있음
public interface ExfDraw {
	public void resize(int width, int height);
	public void move(int x, int y);
	public void draw();

}
