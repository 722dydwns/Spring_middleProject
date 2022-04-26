package pos.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pos.beans.Sell;
import pos.config.PosConfigClass;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Sell sell = new Sell();
		sell.WriteResult();
		
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PosConfigClass.class);
	
		
		
		//ctx.close(); //컨테이너 객체 닫음 
	}

}
