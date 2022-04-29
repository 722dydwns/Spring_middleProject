package pos.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Auth { //계정기능 - 사용자 ID/PASSWORD 
	
	//의존받을 객체들 필드로 선언 
	private UserInfo userInfo;
	private FileMethod fm;

	//생성자로 의존주입 받음
	public Auth(UserInfo userInfo, FileMethod fm) {
		this.userInfo = userInfo;
		this.fm = fm;
	}
	
	//로그인 기능 
	public void Login() {
		//사용자 입력값 얻기 
		Scanner sc = new Scanner(System.in);
		System.out.println("ID 입력");
		String id = sc.next();
		
		System.out.println("PA 입력");
		String pa = sc.next();

		//파일 다시 읽기 
		fm.ReadExcel("userInfo.xlsx");
		System.out.println("--------------------------------------");
	}
	
	//회원가입 기능
	public void Join() throws Exception {
		fm.ReadExcel("userInfo.xlsx");
		System.out.println("존재하는 회원인지 확인해주세요");
		
		fm.WriteResult("userInfo.xlsx", userInfo);
		//추가된 상태 엑셀 다시 출력
		fm.ReadExcel("userInfo.xlsx");
	
	}
	
}
	
	
	
	




	
	
	
	
