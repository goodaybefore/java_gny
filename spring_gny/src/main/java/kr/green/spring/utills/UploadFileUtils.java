package kr.green.spring.utills;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	// /+ *** 하면 밑에 매개변수들 나옴
	/***
	 * 
	 * @param uploadPath : 파일이 업로드될 경로
	 * @param originalName : 실제 파일 이름
	 * @param fileData : 실제 파일 데이터
	 * @return : 서버에 업로드된 파일 경로와 파일 이름이 합쳐진 문자열
	 * @throws Exception : 
	 */
	/* 
	 * 파일을 업로드 할 떄 업르드한 날짜를 기준으로, 폴더가 있으면 그냥쓰고 없으면 만들어서 넣어줌 => 서버의 성능 향상
	 * 경로에있는 \를 문자열로 인식시키기위해서 \\로 써줌
	 * uploadPath : D:\\JAVA
	 * originalName : a.jpg
	 * 실제 경로 => D:\\JAVA\\2022\\01\\14\\550e8400-e29b-41d4-a716-446655440000_a.jpg
	 * 실제 return 값 => /2022/01/14/550e8400-e29b-41d4-a716-446655440000_a.jpg
	 * 
	 * */
	public static String uploadFile(String uploadPath, String originalName,
			byte[] fileData)throws Exception{
		
		//UUID를 발급.  파일 이름이 중복되어도 해당 파일이 유일하게 되도록 발급되는 일련번호
		UUID uid = UUID.randomUUID();
		
		//파일명 앞에  UUID를 추가하는 코드
		String savedName = uid.toString() +"_" + originalName;
		
		//savedPath :  현재 날짜를 기준으로 된 폴더 경로 문자열
		//2022/01/14
		String savedPath = calcPath(uploadPath);
		
		//uploadPath와 savedPath로 이루어진 경로에 파일이름이 savedName인 빈 파일을 생성
		File target = new File(uploadPath + savedPath, savedName);
		//파일 복사. fildeData에 있는 파일을 target에 복사
		FileCopyUtils.copy(fileData, target);
		
		//savedPath와 savedName을 이용하여 문자열을 만듦.
		//\\2022\\01\\14\\550e8400-e29b-41d4-a716-446655440000_a.jpg
		String uploadFileName = makeIcon(savedPath, savedName);
		return uploadFileName;
	}
	
	
	
	
	public static String calcPath(String uploadPath, String me_id) {
		String idPath = File.separator+me_id;
		//년도정보
		//separator : 파일 경로 구분자. 파일 경로 구분시 /, \ 사용에 따라 넣어줌.
		//uploadPath에 me_id로 된 폴더가 없으면 만들어줌 만들어줌. 있으면 그대로씀
		makeIdDir(uploadPath, idPath);
		return idPath;
	}
	
	//trip 파일
	//uploadPath를 기준으로 현재 날짜 경로를 알려주는 메소드
	//이 때, 현재 날짜 경로에 맞는 폴더가 없으면 폴더를 생성
	public static String calcPath(String uploadPath) {
		//현재날짜와 현재 시간 정보를 가져옴
		Calendar cal = Calendar.getInstance();
		//년도정보
		//separator : 파일 경로 구분자. 파일 경로 구분시 /, \ 사용에 따라 넣어줌.
		//=> \\2022로 만들어짐
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		//=> \\2022\\01
		//DecimalFormat 한자리면 앞에 0 붙여주기
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		//=> \\2022\\01\\14
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		//uploadPath에 yearPath폴더, monthPath폴더, datePath폴더가 없으면 만들어줌 만들어줌. 있으면 그대로씀
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
	}
	
	//프로필사진
	public static void makeIdDir(String uploadPath, String paths) {
		//paths[paths.length-1] : 마지막에 입력된 datePath
		//해당된 폴더를 만들어서 폴더가 있는지 없는지 체크
		if(new File(uploadPath + paths).exists())
			return;
		File dirPath = new File(uploadPath + paths);
		//해당 경로에 임시 폴더와 같은 폴더가 없으면
		if( !dirPath.exists())
			//해당 폴더를 실제로 만듦
			dirPath.mkdir();
	}
	
	//trip 파일 저장
	public static void makeDir(String uploadPath, String... paths) {
		//paths[paths.length-1] : 마지막에 입력된 datePath
		//해당된 폴더를 만들어서 폴더가 있는지 없는지 체크
		if(new File(uploadPath + paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			//폴더 경로를 가진 임시 폴더를 생성
			File dirPath = new File(uploadPath + path);
			//해당 경로에 임시 폴더와 같은 폴더가 없으면
			if( !dirPath.exists())
				//해당 폴더를 실제로 만듦
				dirPath.mkdir();
		}
	}
	
	//최종적으로 가져올 때 \를 최종적으로 /로 바꿔주는 역할을 함
	public static String makeIcon(String path, String fileName)
        	throws Exception{
		
		String iconName = path + File.separator + fileName;
		return iconName.replace(File.separatorChar, '/');
	}
}
