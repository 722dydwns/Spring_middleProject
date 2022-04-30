package pos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pos.beans.FileMethod;
import pos.beans.posSystem;
import pos.beans.AuthUser.Auth;
import pos.beans.AuthUser.UserInfo;
import pos.beans.ManageArticle.ArticleInfo;
import pos.beans.ManageArticle.Manage;
import pos.beans.Selling.MaxTotal;
import pos.beans.Selling.Sell;
import pos.beans.Selling.SellInfo;

@Configuration
public class PosConfigClass { //자바 설정 클래스 
 
	@Bean 
	public FileMethod fileMethod() {
		return new FileMethod();
	}
	@Bean
	public UserInfo userInfo() {
		return new UserInfo();
	}
	@Bean
	public Auth auth() {
		Auth auth = new Auth(userInfo(), fileMethod()); //생성자로 DI 주입 
		return auth;
	}	
	@Bean
	public ArticleInfo articleInfo() {
		return new ArticleInfo();
	}
	@Bean
	public Manage manage()	{
		return new Manage(articleInfo(), fileMethod()); //생성자로 DI 주입 
	}
	@Bean
	public Sell sell() {
		return new Sell(fileMethod(), sellInfo()); //생성자로 DI 주입 
	}
	@Bean
	public SellInfo sellInfo() {
		SellInfo info = new SellInfo();
		info.setArticleInfo(articleInfo()); //setter()로 DI 주입
		return info;
	}
	@Bean
	public MaxTotal maxTotal() {
		MaxTotal max = new MaxTotal();
		max.setSellInfo(sellInfo());  //setter() 로 DI 주입 
		max.setFm(fileMethod());
		return max;
	}
	@Bean
	public posSystem posSystem() {
		return new posSystem();
	}
	
}
