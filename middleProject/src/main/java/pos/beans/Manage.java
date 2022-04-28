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

	public class Manage { //재고관리 클래스 - 제품별 코드/가격 지정, 날짜별 제품입고 수량 관리 등
		
		//필드 
		public static final int CELL_TYPE_NUMERIC = 0; 
		public static final int CELL_TYPE_STRING = 1;

		private ArticleInfo articleInfo;

		//생성자
		public Manage(ArticleInfo articleInfo) {
			this.articleInfo = articleInfo;
		}
		
		//메소드
		//사용자 입력처리 
		public void Input() {  //물품 입고 기능 
			Scanner sc = new Scanner(System.in);	

			System.out.println("입고물품 날짜 입력");
			articleInfo.setInputDate(sc.next());
			
			System.out.println("상품명 입력");
			articleInfo.setPName(sc.next());
			
			System.out.println("입고물품 코드 입력");
			articleInfo.setCode(sc.next());
			
			System.out.println("입고물품 가격 입력");
			articleInfo.setPrice(sc.next());
			
			System.out.println("입고물품 수량 입력");
			articleInfo.setCount(sc.next());
		}
		
		//입고한 물품 파일에 쓰기
		public void InputExcel() throws Exception{
			 	String fileName = "managerInfo.xlsx";
			
		        //빈 Workbook 생성
		        XSSFWorkbook workbook = new XSSFWorkbook();
		        
		        //빈 Sheet 생성
		        XSSFSheet sheet = workbook.createSheet("물품 재고 정보 파일");
		        
		        //Sheet 채우기 위한 데이터를 Map에 저장 
		        Map<String, Object[]> data = new TreeMap<>();
		        data.put("1", new Object[] {"날짜", "상품명", "코드", "가격", "수량"}); 
		        data.put("2", new Object[] {"04-28", "콜라", "P1234", "1200", "100"});
		        data.put("3", new Object[] {"04-28", "오뚜기카레", "P1280", "2100", "99"});
		        data.put("4", new Object[] {"04-28", "카카오", "P3124", "1100", "70"});
		       
		        data.put("5", new Object[] {articleInfo.getInputDate(), articleInfo.getPName(),articleInfo.getCode(), articleInfo.getPrice(), articleInfo.getCount()});
		       
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
		
		//재고 리스트 가져오기
		public void OutputManage() {
			try {
	            FileInputStream file = new FileInputStream(new File("managerInfo.xlsx"));

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
	            System.out.println(">> 재고파일 가져오기 성공!");
	            
	            file.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		

		

}
