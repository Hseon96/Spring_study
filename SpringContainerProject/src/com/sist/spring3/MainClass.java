package com.sist.spring3;
/*
 * 		BeanFactory			DI
 * 			|
 * 		ApplicationContext  DI + AOP
 * 			|
 * 		WebApplicationContext
 */
public class MainClass {
	public static void main(String[] args) {
		Container c=new Container();
		A a=(A)c.getBean("a");
		a.display();
		System.out.println("a="+a);
		
		A a1=(A)c.getBean("a");
		a.display();
		System.out.println("a1="+a1);
		
		A a2=(A)c.getBean("a");
		a.display();
		System.out.println("a2="+a2); // 주소 다 똑같다 .. container안에 라서
		
		B b=(B)c.getBean("b");
		b.display();
		
		C cc=(C)c.getBean("c");
		cc.display();
	}
}
