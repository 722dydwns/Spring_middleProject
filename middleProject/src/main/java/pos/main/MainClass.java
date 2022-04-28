package pos.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pos.beans.Auth;
import pos.beans.Manage;
import pos.config.PosConfigClass;

public class MainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PosConfigClass.class);
	
		//계정기능 사용
		Auth auth = ctx.getBean("auth", Auth.class);
		auth.UserInput(); //사용자 입력
		System.out.println("--------------------------------------");
		auth.Login();  //로그인 처리 
		System.out.println("--------------------------------------");  
		
		//재고관리 기능 사용
		Manage mg = ctx.getBean("manage", Manage.class);
		mg.Input();
		System.out.println("--------------------------------------");
		mg.InputExcel();
		System.out.println("--------------------------------------");
		mg.OutputManage();
		
		//판매기능 사용 
		
		
		
		ctx.close(); //컨테이너 객체 닫음 
	}

}
