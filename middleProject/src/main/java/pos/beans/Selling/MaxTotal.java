package pos.beans.Selling;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import pos.beans.FileMethod;

public class MaxTotal { //통계기능 
	//필드
	private SellInfo sellInfo;
	private FileMethod fm;

	//요일별 판매총액 통계
	public int totalCal() { //판매일 들어오면 각 날짜별 판매 누적 총액 계산해서 리턴
		sellInfo.OriginalData();
		Map<String, Object[]> info = sellInfo.getData();
		
		Scanner sc = new Scanner(System.in);
		System.out.println(">>> 총 판매액이 궁금한 날짜를 [**-**] 형식으로 입력해주세요. ------------------");
		String dateTotal = sc.next();
		int Dtotal = 0;
		int total = 0;
		
		//실험용 코드
		 for( String key : info.keySet() ){
	            //Map의 Object []를 가져와서 다시 String[]으로 바꿔주고, 각 인덱스값에 대응하는 value 를 가져옴
	            String[] A = Arrays.copyOf(info.get(key), info.get(key).length, String[].class);
	            if(A[0].equals(dateTotal)) {
	            	Dtotal = Integer.parseInt(A[3]); // 값 옮겨놓고 
	            }	  
	            total += Dtotal;
		 }
		 System.out.println(">>> " + dateTotal + " 판매총액은 " + total + " 원 입니다. " );
		 
		 return total;
	}

	//get/set() 
	public SellInfo getSellInfo() {
		return sellInfo;
	}

	public void setSellInfo(SellInfo sellInfo) {
		this.sellInfo = sellInfo;
	}

	public void setFm(FileMethod fm) {
		this.fm = fm;
	}
	
	
	
}
