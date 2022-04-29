package pos.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pos.beans.Auth;
import pos.beans.Manage;
import pos.config.PosConfigClass;

public class MainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PosConfigClass.class);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------------------------------");
		System.out.println("  >> | 편의점 POS system [START] | >>");
		System.out.println("-------------------------------------");
		//계정기능 사용
		Auth auth = ctx.getBean("auth", Auth.class);	
		auth.Login();
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("회원가입 1 , 기존 회원 로그인 2 ");
		int a = sc.nextInt();
		
		if(a == 1) {
			auth.Join(); //회원가입 
			System.out.println("-------------------------------------");
		}else if(a == 2) {
			auth.Login(); //로그인 
			System.out.println("-------------------------------------");
		}else {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("-------------------------------------");
		}
		
		
		
		//재고관리 기능 사용
		Manage mg = ctx.getBean("manage", Manage.class);
		System.out.println("-------------------------------------");
		System.out.println(" >>> [바로가기 기능 안내] ");
		System.out.println(" 1: 재고관리 기능 | 2: 판매 기능 ");
		System.out.println("-------------------------------------");
		int b = sc.nextInt();
		
		if(b == 1) {
			System.out.println(" [ 입고할 물품 추가하기 ] ");
			System.out.println("-------------------------------------");
			mg.ManageExcel(); //추가 입고기능
		}else if(b == 2) {
			//판매기능
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}  */

		//판매기능 사용 
		//Sell sell = ctx.getBean("sell", Sell.class);
		//System.out.println("[ 판매를 시작합니다. ]");
		//sell.Calculator();
		//System.out.println("--------------------------------------");
		//sell.WriteResult("sellingInfo.xlsx");
		//System.out.println("--------------------------------------");
		//sell.OutputResult();
		//System.out.println("--------------------------------------");  
		
		//통계기능 사용
		
		ctx.close(); //컨테이너 객체 닫음 
	}

}
