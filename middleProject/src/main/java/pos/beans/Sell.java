package pos.beans;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sell { //판매기능 클래스 - 손님이 가져온 물건 종류/수량 입력 후 계싼
	//- 물건 종류, 수량 입력하고 계산 출력 
	
	//필드 
	String code = "111"; //판매 물품 종류 코드
	Integer Count = 7 ; //판매 물품 수량 
	Integer price = 2300; //판매 물품 가격

	//생성자
	public Sell () {
		
	}
	//메소드 - 계산기능 
	
	//메소드 - 계산 결과를 txt파일에 쓰기
	public void WriteResult() {  //결과를 sell.txt파일에 쓰기

	}
	

}
