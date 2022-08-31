package com.sist.web;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 *  app.xml은 src/main/java안에 만들어야 한다!  패키지 밖에!
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao"); // 리턴형이 Object라 형변환해야되는데 이렇게
		System.out.println("dao="+dao);
		EmpDAO dao1=(EmpDAO)app.getBean("dao1"); 
		System.out.println("dao="+dao);
		EmpDAO dao2=(EmpDAO)app.getBean("dao2"); // 싱글턴 => 메모리 아무리 생성해도 주소값이 다 동일 
		System.out.println("dao="+dao);
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmp()+" "+vo.getEname()+" "+vo.getJob()+" "
					+vo.getHiredate().toString()+" "+vo.getSal());
		}
	}

}
