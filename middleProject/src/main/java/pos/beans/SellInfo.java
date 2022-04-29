package pos.beans;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SellInfo implements InfoInterface{  //'판매 정보' 데이터 클래스  
	//필드
	Map<String, Object[]> data = new TreeMap<> ();
	
	//기존 데이터 세팅
	@Override
	public void OriginalData() {
		// TODO Auto-generated method stub
		data.put("1", new Object[] { "판매날짜", "상품명", "가격", "수량" });
		data.put("2", new Object[] { "04-28", "콜라", 3, 3600 });
		data.put("3", new Object[] { "04-28", "오뚜기카레", 4, 8400 });
		data.put("4", new Object[] { "04-28", "카카오", 1, 1100 });
		data.put("5", new Object[] { "04-28", "초코우유", 8, 13600 });
		data.put("6", new Object[] { "04-28", "카카오", 5, 5500 });
	}


	@Override
	public void Input() { //사용자 입출력
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜입력");
		String date = sc.next();

		System.out.println("상품명 입력");
		String name = sc.next();
		//상품 조회 

		System.out.println("수량 입력");
		String count = sc.next();
		
		System.out.println("총액: ");
		
		String total = sc.next();

		DataManage(date, name, total, count); // 추가
	}

	//판매 데이터 추가 저장용 메소드 
	public Map<String, Object[]> DataManage( String date, String pName, String price, String count ) {		
		
		String num = Integer.toString(data.size() + 1); //현재 Map의 크기 + 1를 num으로
		data.put(num, new Object[] {date, pName, price, count}); 
        
        return data;
	}
	
	//get set()
	@Override
	public Map<String, Object[]> getData() {
		return data;
	}
	public void setData(Map<String, Object[]> data) {
		this.data = data;
	}


}
