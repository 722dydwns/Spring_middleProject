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


public class Auth { //계정기능 - 사용자 ID/PASSWORD 관리기능 

	//필드
	public static final int CELL_TYPE_NUMERIC = 0; 
	public static final int CELL_TYPE_STRING = 1;
	
	//사용자 정보 담는 클래스 객체
	private UserInfo userInfo;
	
	String id;
	int pa;
	
	//생성자
	public Auth(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	//사용자 입력값 얻기
	public void UserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ID 입력");
		id = sc.next();
		
		System.out.println("PA 입력");
		pa = sc.nextInt();

	}

	//로그인 시, 사용자 입력값과 파일정보 읽고 값 비교 후 승인 처리
	public void Login() {
		
		try {
            FileInputStream file = new FileInputStream(new File("UserInfo.xlsx"));

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
                        	userInfo.setUserPA((int)cell.getNumericCellValue());
                        	System.out.print((int)cell.getNumericCellValue() + "\t"); 
                        
                            break;
                            
                        case CELL_TYPE_STRING:
                        	userInfo.setUserID(cell.getStringCellValue());
                        	System.out.print(cell.getStringCellValue() + "\t"); 
                        		
                            break;
                    }                                  
                }
                System.out.println();               
            }           
            System.out.println(">> 로그인 성공!");
            
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
	
	
	
	




	
	
	
	
