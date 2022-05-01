package pos.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileMethod { // 파일 입출력 메소드 모음 객체
	//필드
	public static final int CELL_TYPE_NUMERIC = 0; 
	public static final int CELL_TYPE_STRING = 1;	
	
	// 엑셀 입력 메소드
	public void WriteResult(String fileName, InfoInterface info) throws Exception {

		// 빈 Workbook 생성
		XSSFWorkbook workbook = new XSSFWorkbook();

		// 빈 Sheet 생성
		XSSFSheet sheet = workbook.createSheet();

		info.OriginalData(); // 기존데이터 불러오기
		info.Input(); // 대상으로 사용자 입력값을 Input

		// Sheet 추가로 채우기 위한 데이터를 Map으로 받아옴
		Map<String, Object[]> data = info.getData(); 

		// data에서 keySet 가져온다. 이 Set값들을 조회하면서 데이터를 Sheet에 입력
		Set<String> keyset = data.keySet();
		int rownum = 0;

		// 알아야 할 점: TreeMap을 통해 생성된 keySet은 for() 조회 시 키값 오름차순 조회
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);

			Object[] objArr = data.get(key);

			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File(fileName));
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 엑셀 결과 출력 메소드
	public void ReadExcel(String fileName) {
		try {
			FileInputStream file = new FileInputStream(new File(fileName));

			// 엑셀 파일로 Workbook instance를 생성한다.
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// workbook의 첫번째 sheet를 가저온다.
			XSSFSheet sheet = workbook.getSheetAt(0);

			// 모든 행(row)들을 조회한다.
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// 각각의 행에 존재하는 모든 열(cell)을 순회한다.
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// cell의 타입 확인 후, 값을 가져온다.
					switch (cell.getCellType()) {
					case CELL_TYPE_NUMERIC:
						System.out.print((int) cell.getNumericCellValue() + "\t");

						break;

					case CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t");

						break;
					}
				}
				System.out.println();
			}

			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
