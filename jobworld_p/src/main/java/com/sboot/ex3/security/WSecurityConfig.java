package com.sboot.ex3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//브라우저 실행 : p, 접속은 포트번호/kaja/login


//spring security = 보안security + 인증authentication 해주는 open platform

@Configuration 		//클래스 환경설정파일
@EnableWebSecurity  //spring security 활성화
public class WSecurityConfig extends WebSecurityConfigurerAdapter { //항상 그대로 쓰기
	
	protected void configure(HttpSecurity hs1) throws Exception {
	//메모리에 사용자의 저장소가 있는 in-memory 방식 : 계정 수가 적고 변경이 적을 때
	//db와 연관시 .datasource 사용
		
		//http기반 인증 및 사용자 인증이 된 요청만 허용
		hs1.httpBasic().and().authorizeRequests().antMatchers("/kaja/login").permitAll() //특정경로를 지정하여 접근허용
			.and().logout().permitAll() //로그아웃 설정 : 자동으로 제공. any user 접근 가능
			.and().formLogin().loginPage("/kaja/login").loginProcessingUrl("/loginHaja")
				 //폼 기반으로 로그인			//로그인url		//form action="/loginHaja" controller X
			.defaultSuccessUrl("/toResult", true)		//바로 result.jsp 작성해주면 됨
			//login sucsess --> 출력화면
			.and().csrf().disable();
			//basic auth 사용을 위해 csrf 보안 해제
	}
	
	//다중사용자
	@Autowired						//인증 관련 설정 클래스
	protected void configureGlobal(AuthenticationManagerBuilder amb1) throws Exception {
		amb1.inMemoryAuthentication().withUser("babo").password(passwordEncoder().encode("ondal")).roles("ADMIN");
		amb1.inMemoryAuthentication().withUser("pyungkang").password(passwordEncoder().encode("kongjoo")).roles("USER");
	}		//in-memory 사용자 저장소에 넣어준다
	
	//xml안 쓰고 자바 스타일로 객체 정의 : pw ondal --> 8738258254... 식의 암호가 만들어짐
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}			 //Bcrypt : blowfish 암호를 기반으로 한 해싱함수 암호화 (자바, .NET 언어에서 사용 가능)

}//end
