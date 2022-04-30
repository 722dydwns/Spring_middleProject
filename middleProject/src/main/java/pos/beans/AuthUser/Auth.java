package pos.beans.AuthUser;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import pos.beans.FileMethod;

public class Auth { //계정기능 - 사용자 ID/PASSWORD 
	
	//의존받을 객체들 필드로 선언 
	private UserInfo userInfo;
	private FileMethod fm;

	//생성자로 의존주입 받음
	public Auth(UserInfo userInfo, FileMethod fm) {
		this.userInfo = userInfo;
		this.fm = fm;
	}
	
	//회원가입 기능 
	public void Join() throws Exception {
		System.out.println(" >>> 회원가입을 시도합니다. >>> ");

		fm.WriteResult("userInfo.xlsx", userInfo); //입력값을 파일에 쓰기 
		
		fm.ReadExcel("userInfo.xlsx"); //읽은 파일 띄우기 
		
	}
	
	//로그인 기능 
	public void Login() {
		//사용자 입력값 얻기 		
		Scanner sc = new Scanner(System.in);
		System.out.println(">>  ID 입력");
		String id = sc.next();
		
		System.out.println(">>  PA 입력");
		String pa = sc.next();
		
		//로그인 일치 여부 확인용 코드 추가 
		originalUser(id, pa);
		
		//파일 다시 읽기 
		fm.ReadExcel("userInfo.xlsx");
		System.out.println("--------------------------------------");
	}	
	
	//기존 회원 일치 여부 확인용 메소드	
	public void originalUser(String id, String pa) {
		
		userInfo.OriginalData(); //기존 회원 데이터 복원 
		Map<String, Object[]> b = userInfo.getData(); //데이터 getData() 
		
		System.out.println("로그인 시도합니다.");
		
		//일치여부 확인용 코드 
		 for( String key : b.keySet() ){ //키 하나씩 가져오면서 for 도는데 
	            //Map의 Object []를 가져와서 다시 String[]으로 바꿔주고, 각 인덱스값에 대응하는 value 를 가져옴
	            String[] A = Arrays.copyOf(b.get(key), b.get(key).length, String[].class);
	            
	            if(id.equals(A[0])) { // 현재의 key에 대응하는 String[]배열 0번 인덱스는 id 값인데. 들어온 id와 일치하면
	            	if(pa.equals(A[1])) {
	            		System.out.println(">>> ID/PA 모두 일치합니다. ");
	            		System.out.println(">>> 직급 [" + A[2] + " ] 님 POS 로그인 성공 !!!");
	            		System.out.println("*************[ 반 가 워 요 ]***********" );
	            		
	            		}else {
	            		System.out.println(" >>> PASSWORD 오류");
	            		break; // 종료 
	            	}
	            }
		 }		
	}
	
}
	
	
	
	




	
	
	
	
