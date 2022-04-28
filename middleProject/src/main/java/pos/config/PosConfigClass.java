package pos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pos.beans.ArticleInfo;
import pos.beans.Auth;
import pos.beans.Manage;
import pos.beans.Sell;
import pos.beans.UserInfo;

@Configuration
public class PosConfigClass { //자바 설정 클래스 
 
	@Bean
	public UserInfo userInfo() {
		return new UserInfo();
	}
	@Bean
	public Auth auth() {
		Auth auth = new Auth(userInfo());
		return auth;
	}	
	@Bean
	public ArticleInfo articleInfo() {
		return new ArticleInfo();
	}
	
	@Bean
	public Manage manage()	{
		return new Manage(articleInfo());
	}
	@Bean
	public Sell sell() {
		return new Sell(articleInfo());
	}
	
}
