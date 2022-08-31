package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// request에 값을 담아서 JSP로 전송 
import java.util.*;
import com.sist.dao.*;
@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao; // 주소값을 먼저
	
	// 목록
	@GetMapping("board/list.do") // 주소를 갖고 어떤 기능을 할지 적는곳
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage*10)-9);
		map.put("end", curpage*10);
		List<BoardVO> list=dao.boardListData(map);
		int totalpage=dao.boardTotalPage();
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list" , list);
		
		return "board/list"; //jsp붙이면 안됨
	}
	// 추가 => 입력 폼 보여주기
	@GetMapping("board/insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	// @RequestMapping => Get/Post를 구분 못하겠다면 쓰기!
	// 사용자가 전송하는 모든 데이터는 DispatcherServlet => 매개변수를 이용해서 데이터를 주입
	// 일반 데이터형 (int , String, double)
	// VO단위
	// 배열 []
	// List단위
	@PostMapping("board/insert_ok.do") // insert.jsp에서 <form method>가 post니깐 postMapping으로 받아야한다!!
	public String board_insert_ok(BoardVO vo)
	{//                           ----------- 매개변수 쓰는거 중요!!
		// vo 단위로 값을 받아봤는가 ==> 커맨드 객체***라 한다
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	
	//detail.do?no=${vo.no }
	@GetMapping("board/detail.do")
	public String board_detail(int no,Model model)
	{
		// dao에서 받아온다 상세보기..
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	
	//update.do?no=${vo.no}    ?는 Get방식
	@GetMapping("board/update.do")
	//@ResponseBody = 승격 @RestController
	// JavaScript => 어노테이션 
	public String board_update(int no,Model model)
	{
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
	
	@PostMapping("board/find.do")
	public String board_find(String[] fd,String ss,Model model)
	{
		Map map=new HashMap();
		map.put("fsArr", fd);
		map.put("ss", ss);
		List<BoardVO> list=dao.boardFindData(map);
		model.addAttribute("list" , list);
		return "board/find";
	}
	
	@GetMapping("board/delete.do")
	public String board_delete(int no,Model model)
	{
		model.addAttribute("no", no);
		return "board/delete";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
