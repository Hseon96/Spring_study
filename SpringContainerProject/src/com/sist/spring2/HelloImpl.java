package com.sist.spring2;

public class HelloImpl implements Hello{

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("인터페이스 이동");
		
		// 여기서 메소드를 변경하면 어느클래스 쪽에 영향을 미치는가.. => 클래스 독립적으로 .. 영향 안 미치게 
	}
	
}
