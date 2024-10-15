package com.kh.test.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.test.common.interceptor.CategoryInterceptor;


@Configuration // 서버 실행 시 내부 메서드 모두 실행
public class InterceptorConfig implements WebMvcConfigurer{

	// CategoryInterceptor 클래스를 Bean으로 등록
	
	@Bean // 스프링 컨테이너에 @Bean 추가 메서드에서 반환된 객체를 Bean으로 등록
	public CategoryInterceptor categoryInterceptor() {
		return new CategoryInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor( categoryInterceptor() )
		.addPathPatterns("/**")
		.excludePathPatterns("/css/**", "/js/**", "/images/**", "/favicon.ico"); 
		
	}
}