package pos.mainClass;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pos.beans.posSystem;
import pos.beans.AuthUser.Auth;
import pos.beans.ManageArticle.Manage;
import pos.beans.Selling.MaxTotal;
import pos.beans.Selling.Sell;
import pos.config.PosConfigClass;

public class MainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PosConfigClass.class);
		posSystem po = ctx.getBean("posSystem", posSystem.class); 
		Scanner sc = new Scanner(System.in);

		//계정기능 사용 
		Auth auth = ctx.getBean("auth", Auth.class);

		//재고관리 기능 사용
		Manage mg = ctx.getBean("manage", Manage.class); 
		
		//판매 기능 사용 
		Sell sell = ctx.getBean("sell", Sell.class);		
		
		//통계 기능 사용 
		MaxTotal mt = ctx.getBean("maxTotal", MaxTotal.class);

		// 주요 처리 로직
		po.AuthTitle();
		int a = sc.nextInt();
		if (a == 1) { // 로그인 기능
			auth.Login();
			int i = 0;
			while (i < 5) { // 반복
				po.posTitle(); // POS 시스템 선택 타이틀
				int b = sc.nextInt();
				if (b == 1) { // 사용자 재고관리 기능 선택 시
					po.ManageTitle();
					int d = sc.nextInt();
					if(d == 1) { //입고 처리 
						mg.ManageExcel();	
					}else if( d == 2) { //물품 가격 조회 처리
						mg.manageArticle();
					}else if(d == 3) { //단순 파일 보기용 
						mg.SeeExcel();
					}
					
				} else if (b == 2) { // 사용자가 판매 기능 선택 시
					po.SellTitle();
					int c = sc.nextInt();
					if (c == 1) {
						System.out.println("카드 결제합니다.");
						sell.SellExcel();
					} else if (c == 2) {
						System.out.println("현금 결제합니다.");
						sell.SellExcel();
					}
				} else if (b == 3) { // 사용자가 통계기능 선택 시
					po.MaxTitle();
					mt.totalCal();
				} else if (b == 0) { //강제종료 
					i = 10;
				}
				i++;
			}
		} else if (a == 2) { // 회원가입 기능
			auth.Join();
		} else if (a == 3) { //회원조회 기능 
			auth.Quser();
		}
		

		po.postBottom(); // POS 시스템 마지막 부분

		ctx.close(); // 컨테이너 객체 닫음
	}
}
