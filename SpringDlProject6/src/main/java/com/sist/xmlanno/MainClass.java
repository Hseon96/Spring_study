package com.sist.xmlanno;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class MainClass {
	@Autowired
	private MovieDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app3.xml");
		Map map=new HashedMap();
		map.put("start", 1);
		map.put("end", 20);
		//MovieDAO dao=(MovieDAO)app.getBean("movieDAO"); // 디폴트 id "" 첫자를 소문자로!
		MainClass mc=(MainClass)app.getBean("mc");// autowird쓰고 이렇게 쓰면  정석
		List<MovieVO> list=mc.dao.movieListData(map);
		for(MovieVO vo:list)
		{
			System.out.println(vo.getMno()+"."+vo.getTitle());
		}
	}
}