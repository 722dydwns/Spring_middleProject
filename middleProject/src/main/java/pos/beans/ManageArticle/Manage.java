package pos.beans.ManageArticle;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import pos.beans.FileMethod;

public class Manage { // 재고관리 클래스 - 제품별 코드/가격 지정, 날짜별 제품입고 수량 관리 등

	// 필드
	private ArticleInfo articleInfo;
	private FileMethod fm;

	// 생성자
	public Manage(ArticleInfo articleInfo, FileMethod fm) {
		this.articleInfo = articleInfo;
		this.fm = fm;
	}
	
	//상품명 별로 정보 조회 기능 
	public void manageArticle() { //상품명 입력받으면 가격을 내보냄
		articleInfo.OriginalData();
		Map<String, Object[]> at = articleInfo.getData();	
		Scanner sc = new Scanner(System.in);
		System.out.println(" >>> Q. ---[조회할 상품명을 입력해주세요.]--------------------------------------------------");
		String name = sc.next(); //사용자에게 입력받은 물품명
		//실험용 코드
		 for( String key : at.keySet() ){
	            String[] A = Arrays.copyOf(at.get(key), at.get(key).length, String[].class);
	            
	            if(A[1].equals(name)) {	            	//TITLE 부분 [0]날짜 [1]상품명 [2]코드 [3]가격 [4]수량
	            	System.out.println(">>> A. 선택한 [" + A[1]+ "] 제품");
	            	System.out.println(">>> 상품코드 : [ "+A[2]+" | 가격 : "+A[3]+"| 재고량 :"+A[4]);
	            	System.out.println("-----------------------------------------------------------------------");
	            }
		 }
	}
	//단순 재고물품 파일 전체 확인용 메소드 
	public void SeeExcel() {
		fm.ReadExcel("managerInfo.xlsx");
	}
	
	
	//입고물품 처리용 엑셀 메소드 
	public void ManageExcel() throws Exception {
		//실행 전 파일 읽기
		System.out.println(">>> [실행 전 재고관리 파일 Load ]  ");
		fm.ReadExcel("managerInfo.xlsx"); 
		
		//입고물품 쓰기 
		fm.WriteResult("managerInfo.xlsx", articleInfo);	
		
		//추가한 물품 확인용 결과 읽기
		System.out.println(" *** [물품 입고 결과 출력] *** ");		
		fm.ReadExcel("managerInfo.xlsx"); //추가 후 읽기
	}
	
	
}