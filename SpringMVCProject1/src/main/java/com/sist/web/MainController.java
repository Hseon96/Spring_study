package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 모델이 여기..! input type 데이터값은 여기로 모임

// 모델 알림
@Controller
@RequestMapping("main/") // 이렇게 두면 경로명의 중복을 제거할때 쓴다 
public class MainController {
	
	@RequestMapping("input.do")
	public String main_input(HttpServletRequest request,HttpServletResponse response)
	{
		return "main/input";
	}
	
	@RequestMapping("output.do")
	public String main_output(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			
		}catch(Exception ex) {}
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String loc=request.getParameter("loc");
		String content=request.getParameter("content");
		String[] hobby=request.getParameterValues("hobby");
		
		request.setAttribute("name", name); // 값을 넘길때는 setAttribute
		request.setAttribute("sex", sex);
		request.setAttribute("loc", loc);
		request.setAttribute("content", content);
		request.setAttribute("hobby", hobby);
		return "main/output";   // .jsp를 생략한다 *** 다른점!! // 데이터 값 받는 곳 name값으로 받는다
		//     ------------여기서 받는다
	}
	
	@RequestMapping("output1.do") // .do는 처리 (요청 처리)   2.5버전
	public String main_output1(String name,String sex,String loc,String content,String[] hobby,Model model) // 전송객체 : model꼭 넣어줘야한다  받아오는 변수는 동일해야한다. 순서상관x
	{
		// Model ==> 데이터 전송 객체 (request가 첨부) 
		// request를 사용하지 않고 매개변수를 이용해서 데이터를 DispatcherServlet으로부터 받을 수 있다
		// request, response는 사용하지 않고 => 매개변수를 이용해서 데이터값을 받는다 ***
		/*
		 *    request 사용 ======> Cookie사용할때는 직접받아야해서 써야한다
		 *    response 사용 =====> 파일 업로드, Cookie
		 */
		model.addAttribute("name", name); // =request.setAttribute("name", name);랑 같다
		/*
		 *    public void addAttribute(String key,Object obj)
		 *    {
		 *    		request.setAttribute("key", obj);
		 *    }
		 */
		// ==> 주로 매개변수를 이용한다     == 값 받을때!! 
		model.addAttribute("sex", sex); 
		model.addAttribute("loc", loc); 
		model.addAttribute("content", content); 
		model.addAttribute("hobby", hobby); 
		return "main/output"; // 요청 처리에 대한 결과값 받는 곳
	}
	
	@RequestMapping("output2.do")  //3.0버전
	// 주의점 => 커맨드 객체로 받는다 (가장많이 사용) == name값이랑 vo안에있는 변수명이랑 반드시 일치해야 한다! 없는건 따로 받아야한다!!!!
	public String main_output2(MemberVo vo,Model model) // 3.0버전
	{
		model.addAttribute("vo",vo); // 전송 끝..아주 간단
		return "main/output1";
	}
	// ${vo.name}이렇게 받아야하니깐 output에선 못받음
	
	/*
	 * 		Spring 4.3
	 * 		=========== 구분
	 * 		@RequestMapping  ===> GET/POST 동시에 처리 (검색,페이징)
	 *        = @GetMapping ==> GET
	 *        = @PostMapping ==> POST
	 */
}





























