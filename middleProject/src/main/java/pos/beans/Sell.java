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
	
	public static final int CELL_TYPE_NUMERIC = 0; 
	public static final int CELL_TYPE_STRING = 1;
	//필드 
	private ArticleInfo articleInfo;
	
	String sellDate; //판매날짜
	int sellCount; //판매 수량
	int totalPrice;	 //총판매액
	
	//생성자
	public Sell (ArticleInfo articleInfo) {
		this.articleInfo = articleInfo;
	}

	//메소드 - 계산기능 (물품 가격 가져와서 * 수량)
	public void Calculator() {
		//사용자 입력값 처리
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜입력");
		sellDate = sc.next();
		System.out.println("상품명 입력");
		String Pname = sc.next();
		
		System.out.println("수량 입력");
		sellCount = sc.nextInt();
		
		//계산
		totalPrice = 1700 * sellCount;
		
		System.out.println("총액: " + totalPrice);
		
		System.out.println("카드 계산 1 or 현급 계산 2");
		int data = sc.nextInt();
		if(data == 1) {
			System.out.println("총액 " + totalPrice + "원 카드 결제 완료");
		}else if(data == 2) {
			System.out.println("총액 " + totalPrice + "원 현금 결제 완료");
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	//메소드 - 계산 결과를 SaleInfo.xlsx 엑셀 파일에 쓰기
	public void WriteResult()  throws Exception{
		 	String fileName = "sellingInfo.xlsx";
		
	        //빈 Workbook 생성
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        
	        //빈 Sheet 생성
	        XSSFSheet sheet = workbook.createSheet("물품 재고 정보 파일");
	        
	        //Sheet 채우기 위한 데이터를 Map에 저장 
	        Map<String, Object[]> data = new TreeMap<>();
	        data.put("1", new Object[] {"판매날짜", "상품명", "가격", "수량"}); 
	        data.put("2", new Object[] {"04-28", "콜라", 3, 3600});
	        data.put("3", new Object[] {"04-28", "오뚜기카레",4,8400});
	        data.put("4", new Object[] {"04-28", "카카오", 1, 1100});
	        data.put("5", new Object[] {"04-28", "초코우유",8, 13600});
	        data.put("6", new Object[] {"04-28", "카카오", 5, 5500});	
	        
	        data.put("7", new Object[] {sellDate, articleInfo.getPName(), Integer.toString(sellCount), Integer.toString(totalPrice)});
	       
	        //data에서 keySet 가져온다. 이 Set값들을 조회하면서 데이터를 Sheet에 입력
	        Set<String> keyset = data.keySet();
	        int rownum = 0;
	        
	        //알아야 할 점: TreeMap을 통해 생성된 keySet은 for() 조회 시 키값 오름차순 조회
	        for(String key : keyset) {
	        	Row row = sheet.createRow(rownum++);
	        	Object[] objArr = data.get(key);
	        	int cellnum = 0;
	        	for(Object obj : objArr) {
	        		Cell cell = row.createCell(cellnum++);
	        		if(obj instanceof String) {
	        			cell.setCellValue((String)obj);
	        		}else if (obj instanceof Integer) {
	        			cell.setCellValue((Integer)obj);
	        		}
	        	}
	        }
	        try {	        
	        	FileOutputStream out = new FileOutputStream(new File(fileName));
	        	workbook.write(out);
	        	out.close();
	        }catch (IOException e) {
	        	e.printStackTrace();
	        }
	}
	//판매 결과 출력
	public void OutputSell() {
		try {
            FileInputStream file = new FileInputStream(new File( "sellingInfo.xlsx"));

            // 엑셀 파일로 Workbook instance를 생성한다.
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // workbook의 첫번째 sheet를 가저온다.
            XSSFSheet sheet = workbook.getSheetAt(0);

            // 모든 행(row)들을 조회한다.
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //각각의 행에 존재하는 모든 열(cell)을 순회한다.
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    // cell의 타입 확인 후, 값을 가져온다.
                    switch (cell.getCellType()) {
                        case CELL_TYPE_NUMERIC:
                        	
                        	System.out.print((int)cell.getNumericCellValue() + "\t"); 
                        
                            break;
                            
                        case CELL_TYPE_STRING:
                        	
                        	System.out.print(cell.getStringCellValue() + "\t"); 
                        		
                            break;
                    }                                  
                }
                System.out.println();               
            }           
            System.out.println(">> 판매 정보 입력 성공!");
            
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
