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

public class Manage { // 재고관리 클래스 - 제품별 코드/가격 지정, 날짜별 제품입고 수량 관리 등

	// 필드
	private ArticleInfo articleInfo;
	private FileMethod fm;

	// 생성자
	public Manage(ArticleInfo articleInfo, FileMethod fm) {
		this.articleInfo = articleInfo;
		this.fm = fm;
	}
	
	//입고물품 엑셀파일에 쓰기 
	public void ManageExcel() throws Exception {
		fm.ReadExcel("managerInfo.xlsx"); //실행 전 읽기
		
		fm.WriteResult("managerInfo.xlsx", articleInfo);
		
		System.out.println(" *** 물품 입고 결과 출력 ***");
		
		//추가한 물품 다시 읽기
		fm.ReadExcel("managerInfo.xlsx"); //추가 후 읽기
	}

}
