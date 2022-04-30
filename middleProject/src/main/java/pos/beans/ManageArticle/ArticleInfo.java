package pos.beans.ManageArticle;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import pos.beans.InfoInterface;

public class ArticleInfo implements InfoInterface{ //'각 물품 정보' 묶음 클래스 
	
	//필드
	Map<String, Object[]> data = new TreeMap<>();
	
	// 기존 데이터 세팅
	@Override
	public void OriginalData() {
		// TODO Auto-generated method stub  // TITLE 부분 [0]날짜 [1]상품명 [2]코드 [3]가격 [4]수량
		data.put("1", new Object[] { "날짜", "상품명", "코드", "가격", "수량" }); 
		data.put("2", new Object[] { "04-28", "콜라", "P1234", "1200", "100개" });
		data.put("3", new Object[] { "04-28", "오뚜기카레", "P1280", "2100", "99개" });
		data.put("4", new Object[] { "04-28", "카카오", "P3124", "1100", "70개" });
		data.put("5", new Object[] { "04-29", "초코우유", "P3101", "1700", "100개" });
	}
	
	@Override
		public void Input() {
			// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------------------------------");
		
		System.out.println(">> 입고물품 날짜 입력");
		String date = sc.next();
		
		System.out.println(">> 입고물품 상품명 입력");
		String pName = sc.next();		
		
		System.out.println(">> 입고물품 코드 입력");
		String code = sc.next();
		
		System.out.println(">> 입고물품 가격 입력");
		String price = sc.next();
		
		System.out.println(">> 입고물품 수량 입력");
		String count = sc.next();
		
		DataManage(date, pName,code, price, count);		
		}
	
	//데이터 추가용 메소드 
	public Map<String, Object[]> DataManage(String date, String pName, String code, String price, String count ) {

		OriginalData(); //기존 데이터 불러놓고 
		
		String num = Integer.toString(data.size() + 1); //현재 Map의 크기 + 1를 num으로
		
		data.put(num, new Object[] {date, pName, code, price, count});  //추가처리 
        
        return data;
	}
	
	//get/Setter()	
	
	@Override
	public Map<String, Object[]> getData() {
		return data;
	}

	public void setData(Map<String, Object[]> data) {
		this.data = data;
	}
	

}
