package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
/*
 * 		모델 제작 (요청에 처리)
 * 		
 * 		사용자 요청 ============== DispatcherServlet ================ HandlerMapping
 * 									  |									 |
 * 								ViewResolver (경로명, 확장자)				Model클래스를 찾아준다 (요청처리=프로그래머)
 * 								============= View(JSP) : 화면출력
 * 
 * 	1. @Controller : Model을 못찾거나 (404)일 경우 
 * 					 @Controller 유무 확인
 * 					  return => 설정된 JSP가 있는지 확인 
 *  2. 요청 처리에 필요한 모든 객체를 스프링으로 받아서 저장
 *  	==================================== @Autowired
 *  3. 요청 URI를 받는다 => 405
 *     @RequestMapping
 *     @GetMapping
 *     @PostMapping
 *  
 *  4. 요청 처리 메소드를 만든다 
 *  	================
 *     1) 리턴형 (String) , void
 *     2) 매개변수 (사용자 보내준 모든 데이터형 처리) , VO단위, List단위, []단위
 *        ======================================================= 내장 객체를 요청
 *        		    request, response, session, Model , RedirectAttributes
 *     3) 매개변수로 등록된 모든 데이터는 DispatcherServlet에서 값을 주입해준다 
 *     4) 순서는 관계 없다
 *     5) 잘못된 데이터형을 입력한 경우 => 400
 *   ====================================== Spring-boot 
 *     
 */
@Controller // 메모리할당은 controller와 dao 만!
public class FoodController {
	@Autowired // 자동 주입
	private FoodDAO dao; 
	// 필요한 객체를 멤버로 생성해서 주소값을 받는다 .. @autowired
	// 스프링에서 생성된 객체를 받아서 사용 => 자동으로 주소값을 얻어 온다
	@GetMapping("food/list.do")
	public String food_list(String page,Model model,HttpServletRequest request)
	{		//              사용자 요청값         전송 객체
		//                  ======================== 여기만 바뀌었다 /////이거랑
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list=dao.foodListData(map);
		int totalpage=dao.foodTotalPage();
		//////////////////////////////////
		Cookie[] cookies=request.getCookies();
		List<FoodVO> fList=new ArrayList<FoodVO>();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("food"))
				{
					String fno=cookies[i].getValue(); 
					FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
					fList.add(vo);
					
				}
			}
		}
		//////////////////////////////////
		model.addAttribute("curpage", curpage);
		model.addAttribute("list", list);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("fList", fList);
		model.addAttribute("size" , fList.size()); // 이건 왜..?
		///////////////////////////////////////////
		return "list";
	}
	// detail.do?fno=${vo.fno }
	@GetMapping("food/detail.do")
	public String food_detail(int fno,Model model) // 출력해놓고 클릭은 int 맨처음에 출력부터면 string
	{
		//DAO 연결 
		FoodVO vo=dao.foodDetailData(fno);
		model.addAttribute("vo", vo);
		return "detail";
	}
	
	@GetMapping("food/detail_before.do")
	public String food_detail_before(int fno,HttpServletResponse response)
	{
		Cookie cookie=new Cookie("food"+fno, String.valueOf(fno));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		return "redirect:detail.do?fno="+fno;
	}
	
	@GetMapping("food/cookie_all_delete.do")
	public String food_cookie_all_delete(HttpServletRequest request,HttpServletResponse response)
	{
		Cookie[] cookies=request.getCookies();
		for(int i=cookies.length-1;i>=0;i--)
		{
			if(cookies[i].getName().equals("food"))
			{
				cookies[i].setPath("/");
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
		return "redirect:list.do";
	}
	@GetMapping("food/find.do")
	public String food_find() // 출력해놓고 클릭은 int 맨처음에 출력부터면 string
	{
		//DAO 연결 
		
		return "find";
	}
}
