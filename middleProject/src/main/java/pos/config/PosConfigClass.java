package pos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pos.beans.ArticleInfo;
import pos.beans.Auth;
import pos.beans.FileMethod;
import pos.beans.Manage;
import pos.beans.Sell;
import pos.beans.SellInfo;
import pos.beans.UserInfo;
import pos.beans.posSystem;

@Configuration
public class PosConfigClass { //자바 설정 클래스 
 
	@Bean
	public UserInfo userInfo() {
		return new UserInfo();
	}
	@Bean
	public Auth auth() {
		Auth auth = new Auth(userInfo(), fileMethod());
		return auth;
	}	
	@Bean
	public ArticleInfo articleInfo() {
		return new ArticleInfo();
	}
	@Bean
	public Manage manage()	{
		return new Manage(articleInfo(), fileMethod());
	}
	@Bean
	public Sell sell() {
		return new Sell(articleInfo(), fileMethod(), sellInfo());
	}
	@Bean 
	public FileMethod fileMethod() {
		return new FileMethod();
	}
	@Bean
	public SellInfo sellInfo() {
		return new SellInfo();
	}
	@Bean
	public posSystem posSystem() {
		return new posSystem();
	}
	
}
