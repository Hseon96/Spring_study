package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext app= //여기만 달라졌음..스프링 5버전
				new AnnotationConfigApplicationContext(MovieConfig.class);
		MovieManager m=(MovieManager)app.getBean("movieManager");
		Scanner scan=new Scanner(System.in);
		System.out.println("======메뉴======");
		System.out.println("1. 일일박스오피스");
		System.out.println("2. 실시간 예매율");
		System.out.println("3. 좌석 점유율");
		System.out.println("4. 온라인 상영관");
		System.out.println("================");
		System.out.println("메뉴 선택:");
		int menu=scan.nextInt();
		List<MovieVO> list=m.movieListData(menu);
		for(MovieVO vo:list)
		{
			System.out.println(vo.getTitle()+" "+vo.getDirector());
		}
	}

}
