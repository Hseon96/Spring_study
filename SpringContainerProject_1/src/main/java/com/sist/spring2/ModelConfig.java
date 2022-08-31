package com.sist.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이건 뭔데 
public class ModelConfig {
	@Bean("a")
	public AModel aModel()
	{
		return new AModel();
	}
	
	@Bean("b")
	public BModel bModel()
	{
		return new BModel();
	}
	
	@Bean("c")
	public CModel cModel()
	{
		return new CModel();
	}
}
