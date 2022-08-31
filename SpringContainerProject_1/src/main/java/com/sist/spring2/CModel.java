package com.sist.spring2;

import org.springframework.stereotype.Component;

@Component("c") // 메모리 할당하는 과정이 3개인데 다 똑같다. 
public class CModel {
	public void display()
	{
		System.out.println("CModel:display Call..");
	}
}
