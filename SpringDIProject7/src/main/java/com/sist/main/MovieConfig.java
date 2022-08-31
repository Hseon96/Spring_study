package com.sist.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//<context:component-scan base-package=>요거랑 같은거..!! 
// xml 대신 사용
// spring5 => 순수 자바로만 생성
@Configuration // 환경설정하는 파일 // 17page
@ComponentScan(basePackages = {"com.sist.main"})
public class MovieConfig {
	
}
