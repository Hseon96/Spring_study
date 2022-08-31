package com.sist.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml"); //클래스 다 모아놓는 곳
		
		AModel a=(AModel)app.getBean("a"); // getBean을 쓰면 해당 클래스 불러올수 있다
		a.display();
		
		BModel b=(BModel)app.getBean("b"); // getBean을 쓰면 해당 클래스 불러올수 있다
		b.display();
		
		
	}
}
