package com.sist.spring5;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// xml 대신 사용
// spring5 => 순수 자바로만 생성
@Configuration // 환경설정하는 파일
public class MovieConfig {
	@Bean
	public DataSource dataSource()
	{
		
	}
}
