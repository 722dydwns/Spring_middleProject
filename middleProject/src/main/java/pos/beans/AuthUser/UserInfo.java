package pos.beans.AuthUser;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import pos.beans.InfoInterface;

public class UserInfo implements InfoInterface{ // 사용자 정보 데이터 관리 객체
	// 필드
	Map<String, Object[]> data = new TreeMap<>();
	
    @Override
	public void OriginalData() {  //기존 데이터 세팅 
		// TODO Auto-generated method stub
		data.put("1", new Object[] { "ID", "PA", "STATUS", "NAME"}); //title [0]: ID / [1] : PA / [2] : 직급
		data.put("2", new Object[] { "we0722", "1234", "매니저", "서용주"});
		data.put("3", new Object[] { "se999", "1234", "직원1", "정바보"});
		data.put("4", new Object[] { "ao1234", "1234", "직원2", "홍길동"});
		data.put("5", new Object[]{ "pie33", "1234", "직원3", "유재석"});
		data.put("6", new Object[]{ "AA123", "1234", "직원4", "김종국"});
	}
    
	@Override
	public void Input() { //회원가입용 사용자 Input
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);	

		System.out.println(">> 회원가입 ID 입력");
		String ID = sc.next();
		
		System.out.println(">> 회원가입 PA 입력");
		String PA= sc.next();	
		
		System.out.println(">> 직급 STATUS 입력");
		String st= sc.next();
		
		System.out.println(">> 이름 NANE 입력");
		String name = sc.next();

		DataManage(ID, PA, st, name);
		
	}
    
	//데이터 추가용 메소드 
	public Map<String, Object[]> DataManage( String id, String pa, String status, String name) {
			
		String num = Integer.toString(data.size() + 1); //현재 Map의 크기 + 1를 num		
		data.put(num, new Object[] { id, pa, status , name});

		return data;
	}

	//get/set()
	@Override
	public Map<String, Object[]> getData() {
		return data;
	}

	public void setData(Map<String, Object[]> data) {
		this.data = data;
	}

    
}
