package pos.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pos.beans.Auth;
import pos.beans.Manage;
import pos.beans.Sell;
import pos.beans.posSystem;
import pos.config.PosConfigClass;

public class MainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PosConfigClass.class);
		posSystem po = ctx.getBean("posSystem", posSystem.class); //pos 기계용 객체
		po.AuthTitle();
		Scanner sc = new Scanner(System.in);
		
		//계정기능 사용 
		Auth auth = ctx.getBean("auth", Auth.class);	
		auth.Login();
		
		//재고관리 기능 사용
		Manage mg = ctx.getBean("manage", Manage.class); 
		
		//판매 기능 사용 
		Sell sell = ctx.getBean("sell", Sell.class);		
		//판매 카드 or 현금 ??
		
		
		po.posTitle();
		
		if(sc.nextInt() == 1) {
			po.ManageTitle();
			mg.ManageExcel();
			po.posTitle();
		}
		if(sc.nextInt() == 2) {
			po.SellTitle();
			int a = sc.nextInt();
			if(a == 1) {
				System.out.println("카드 결제합니다.");
			}else {
				System.out.println("현금 결제합니다.");
			}
			
			sell.SellExcel();
		}
		
		po.postBottom();
			
		ctx.close(); //컨테이너 객체 닫음 
	}
}


