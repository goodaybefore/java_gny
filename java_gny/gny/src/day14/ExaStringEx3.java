package day14;

import java.util.Arrays;

public class ExaStringEx3 {

	public static void main(String[] args) {
		/* 확장자를 포함한 파일명 5개를 배열에 저장하고,
		 * 저장된 파일에 이미지 파일이 있는지 확인하는 코드
		 * jpeg, bmp, gif, png
		 * */
		
		String[] files = new String[5];
		int cnt = 0;
		files[0] = "hello.jpeg";
		files[1] = "hello.text";
		files[2] = "hello.png";
		files[3] = "hello.md";
		files[4] = "hello.pdf";
		for(String file:files) {
			if(file.endsWith(".jpeg")||file.endsWith(".bmp")||file.endsWith(".gif")||file.endsWith(".png")) {
				cnt++;
				System.out.println(file);
			}
		}
		
		System.out.println("파일에 이미지 파일은 "+cnt+"개 존재함");
		
		
		//강사님
		cnt = 0;
		String fileNames[] = {"test1.jpg", "test2.bmp", "test3.gif", "test4.png", "test5.exe"};
		String imgSuffixString = "jpg, bmp, gif, png";
		String[] imgfSuffixArray = imgSuffixString.split(", ");
//		System.out.println(Arrays.toString(imgfSuffixArray));
		
		
		for(String fileName : fileNames) {
			boolean isImg = false;
			for(String imgSuffix:imgfSuffixArray) {
				//fileName의 i번째 배열의 
				if(fileName.endsWith(imgSuffix)) {
					System.out.println(fileName+"은 이미지 입니다");
					cnt++;
					isImg = true;
					break;
				}//여기다가 else 붙이면 안됨(체크가 끝나기 전이기 때문)
			}
			if(!isImg) {
				System.out.println(fileName+"는 이미지가 아닙니다.");
			}
		}
		//메소드이용
		System.out.println("======================");
		for(String fileName:fileNames) {
			if(checkSuffix(imgfSuffixArray,fileName)) {
				System.out.println(fileName+"은 이미지입니다");
			}else {
				System.out.println(fileName+"은 이미지가 아닙니다");
			}
		}
	}
	
	
	/* 기능 : 확장자들과 파일명이 주어지면, 해당 파일이 확장자에 맞는지 알려주는 메소드
	 * 매개변수 : 확장자들, 파일명 => String[]  suffixArray, String fileName
	 * 리턴타입 : 확장자에 맞는 파일 명이 맞는지 아닌지 => true/false => boolean
	 * 메소드명 : checSuffix
	 * */
	
	public static boolean checkSuffix(String[] suffixArray, String fileName) {
		for(String suffix : suffixArray) {
			if(fileName.endsWith(suffix)) {
				return true;
			}
		}
		return false;
	}

}
