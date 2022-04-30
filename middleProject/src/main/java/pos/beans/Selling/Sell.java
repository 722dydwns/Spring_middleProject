package pos.beans.Selling;

import java.util.Arrays;

import pos.beans.FileMethod;
import pos.beans.ManageArticle.ArticleInfo;

public class Sell { //판매기능 클래스 - 손님이 가져온 물건 종류/수량 입력 후 -> 계산
						//- 물건 종류, 수량 입력하고 계산 쓰기
	//의존객체 필드로 선언 
	private FileMethod fm;
	private SellInfo sellInfo;
	
	//생성자
	public Sell ( FileMethod fm, SellInfo sellInfo) {
		this.fm = fm;
		this.sellInfo = sellInfo;
	}
		
	//판매 내용 -> 엑셀파일에 쓰기용 메소드 
	public void SellExcel() throws Exception {
		//판매 전 파일 출력 
		System.out.println("---------[ 재고 정보 파일 ] 참고해서 판매하세요 ----------------------------------");
		fm.ReadExcel("managerInfo.xlsx");
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
