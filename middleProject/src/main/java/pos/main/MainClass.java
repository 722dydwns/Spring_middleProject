package pos.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pos.beans.Auth;
import pos.beans.Manage;
import pos.beans.Sell;
import pos.config.PosConfigClass;

public class MainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PosConfigClass.class);
	
		
		//계정기능 사용
		Auth auth = ctx.getBean("auth", Auth.class);
		System.out.println("[ 로그인을 시도합니다. ]");
		auth.UserInput(); //사용자 입력
		System.out.println("--------------------------------------");
		auth.Login();  //로그인 처리 
		System.out.println("--------------------------------------");  
		
		//재고관리 기능 사용
		Manage mg = ctx.getBean("manage", Manage.class);
		System.out.println("[ 재고관리를 시작합니다. ]");
		mg.Input();
		System.out.println("--------------------------------------");
		mg.InputExcel();
		System.out.println("--------------------------------------");
		mg.OutputManage();
		System.out.println("--------------------------------------");  
		
		//판매기능 사용 
		Sell sell = ctx.getBean("sell", Sell.class);
		System.out.println("[ 판매를 시작합니다. ]");
		sell.Calculator();
		System.out.println("--------------------------------------");
		sell.WriteResult();
		System.out.println("--------------------------------------");
		sell.OutputSell();
		System.out.println("--------------------------------------");
		
		ctx.close(); //컨테이너 객체 닫음 
	}

}
