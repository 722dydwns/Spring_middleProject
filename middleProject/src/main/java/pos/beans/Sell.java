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

public class Sell { //판매기능 클래스 - 손님이 가져온 물건 종류/수량 입력 후 -> 계산
						//- 물건 종류, 수량 입력하고 계산 쓰기
	//의존객체 필드로 선언 
	private ArticleInfo articleInfo;
	private FileMethod fm;
	private SellInfo sellInfo;
	
	//생성자
	public Sell (ArticleInfo articleInfo, FileMethod fm, SellInfo sellInfo) {
		this.articleInfo = articleInfo;
		this.fm = fm;
		this.sellInfo = sellInfo;
	}
	
	//엑셀파일에 쓰기
	public void SellExcel() throws Exception {
		//판매 전 파일 출력 
		System.out.println("---------<판매 전 파일 출력>------------------------------------------------");
		fm.ReadExcel("sellingInfo.xlsx");
		System.out.println("-----------------------------------------------------------------------");
		
		//판매내용 쓰기 
		fm.WriteResult("sellingInfo.xlsx", sellInfo);
		System.out.println("-----------------------------------------------------------------------");
		
		//쓴 내용 확인 파일 출력
		System.out.println("---------<판매 후 파일 출력>------------------------------------------------");
		fm.ReadExcel("sellingInfo.xlsx");
		System.out.println("-----------------------------------------------------------------------");
	}

}
