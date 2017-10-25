package pl.put.poznan.plantsguard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
				.antMatchers("/assets/**","assets/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.headers()
//	    		.contentTypeOptions();
//		http
//			.csrf().disable()
//			.authorizeRequests()
//				.antMatchers("/api/**").permitAll()
//				.anyRequest().authenticated()
//				.and()
//	        .formLogin()
//	            .loginPage("/login")
//	            .permitAll()
//	            .and()
//	        .logout()
//	            .permitAll();
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("admin").password("password").roles("ADMIN");
	}
	

}
