package pos.beans;

public class ArticleInfo { //'각 물품 정보' 묶음 클래스 
	
	//필드
	String inputDate; //제품 입고 날짜
	String PName; //물품명
	String code; //물품 코드
	String price; //물품 가격 
	String Count; //물품 수량
	
	//Setter()	
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}


}
