package pos.beans.Selling;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import pos.beans.InfoInterface;
import pos.beans.ManageArticle.ArticleInfo;

public class SellInfo implements InfoInterface{  //'판매 정보' 데이터 클래스  
	//필드
	Map<String, Object[]> data = new TreeMap<> (); //데이터 처리용 묶음 Map
	
	private ArticleInfo articleInfo; //각 물건 객체 DI 
	
	@Override
	public void OriginalData() {//기존 판매 데이터 세팅
		// TODO Auto-generated method stub
		data.put("1", new Object[] { "판매날짜", "판매상품명", "판매수량", "판매금액" }); //title [0]:날짜, [1]:상품명 [2]:수량 [3] 판매금액
		data.put("2", new Object[] { "04-28", "콜라",  "3", "3600"});
		data.put("3", new Object[] { "04-28", "오뚜기카레", "4", "8400" });
		data.put("4", new Object[] { "04-28", "카카오", "1", "1100" });
		data.put("5", new Object[] { "04-28", "초코우유", "3", "3100" });
		data.put("6", new Object[] { "04-31", "카카오", "6", "6600" });
	}
	
	// 사용자가 Input() 입력한 상품명 X 수량 곱한 Total 값을 리턴해주면 됨
	public String TotalCal(String name, String cnt) { 
		articleInfo.OriginalData();
		Map<String, Object[]> at = articleInfo.getData();	
		
		int ct =Integer.parseInt(cnt); //구매 수량
		int total = 1;
		//실험용 코드
		 for( String key : at.keySet() ){
	            String[] A = Arrays.copyOf(at.get(key), at.get(key).length, String[].class);
	            
	            if(A[1].equals(name)) {
	        	    System.out.println("-----------------------------------------------------------------------");
	            	total = Integer.parseInt(A[3]) * ct; //선택한 총 total 값 
	            	System.out.println(">>> 선택하신 " + A[1]+ " 제품 [" + cnt + " 개 구매] -> || [$ " + total + " 원 결제힙니다. ]");
	            }
		 }		 		 
		 return Integer.toString(total); //String타입으로 total 값 반환 		 
	}
	
	@Override
	public void Input() { // 사용자 데이터 입출력
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println(">> [판매 날짜 입력]");
		String date = sc.next();

		System.out.println(">> [판매할 상품명 입력]");
		String name = sc.next();

		System.out.println(">> [판매 수량 입력]");
		String count = sc.next();

		String total = TotalCal(name, count); //계산한 값 반환받음 

		DataManage(date, name, count, total); // 판매 데이터 추가처리 
	}

	//판매 데이터 추가 저장용 메소드 
	public Map<String, Object[]> DataManage( String date, String pName, String count, String total ) {		
		
		String num = Integer.toString(data.size() + 1); //현재 Map의 크기 + 1를 num
		data.put(num, new Object[] {date, pName, count, total}); 
        
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
	
	//판매 시 각 물건 객체의 정보 접근 가능해야 하므로 의존 주입 위해 setter() 
	public void setArticleInfo(ArticleInfo articleInfo) {
		this.articleInfo = articleInfo;
	}

}
