package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
@RequestMapping("goods/") // 공통 경로 따로 빼기  // 53page => 중복적인 경로명을 제거
public class GoodsController {
	@Autowired
	private GoodsService service;
	
	@GetMapping("main.do")
	public String goods_main()
	{
		return "goods/main";
	}
	
	@GetMapping("goods_all.do")
	// 리턴형 / 매개변수 잘 보기!! 
	public String goods_all_list(String page,Model model)
	{
		// 결과값 전송 객체 : Model
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage*12)-11);
		map.put("end", curpage*12);
		List<GoodsVO> list=service.goodsAllListData(map);
		for(GoodsVO vo:list)
		{
			String name=vo.getName();
			if(name.length()>20)
			{
				name=name.substring(0,20)+"...";
				vo.setName(name);
			}
			else
			{
				vo.setName(name);
			}
		}
		int totalpage=service.goodsAllTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		/*
		 * 	  startPage
		 *       1         11          21          31
		 *    curpage [1]~[10]
		 *       11
		 *    curpage [11]~[20]
		 *    
		 */
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		// 전송
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		// model => request
		/*
		 * 		public void addAttribute(String key,Object obj)
		 * 		{
		 *  		request.setAttribute(key,obj);
		 * 		} 
		 * 		request를 사용을 하지말라 권장
		 * 		Model 전송 객체
		 */
		
		return "goods/goods_all";
	}
	//goods_all_detail.do?no=${vo.no }
	@GetMapping("goods_all_detail.do") // 어떤 jsp를 보내서 보여줄껀지
	public String goods_all_detail(int no,Model model)
	{
		System.out.println("no="+no);
		GoodsVO vo=service.goodsAllDetailData(no);
		model.addAttribute("vo", vo);
		return "goods/goods_all_detail";
	}
	
	@GetMapping("goods_best.do")
	
		public String goods_best_list(String page,Model model)
		{
			if(page==null)
				page="1";
			int curpage=Integer.parseInt(page);
			Map map=new HashMap();
			int rowSize=9;
			int start=(rowSize*curpage)-(rowSize-1);
			int end=rowSize*curpage;
			map.put("start", start);
			map.put("end", end);
			List<GoodsVO> list=service.goodsBestListData(map);
			for(GoodsVO vo:list)
			{
				String name=vo.getName();
				if(name.length()>20)
				{
					name=name.substring(0,20)+"...";
					vo.setName(name);
				}
				else
				{
					vo.setName(name);
				}
			}

			int totalpage=service.GoodsBestTotalPage();
			model.addAttribute("curpage", curpage);
			model.addAttribute("list",list);
			model.addAttribute("totalpage",totalpage);
			
			return "goods/goods_best";
		}
	
	@GetMapping("goods_best_detail.do") // 어떤 jsp를 보내서 보여줄껀지
	public String goods_best_detail(int no,Model model)
	{
		System.out.println("no="+no);
		GoodsVO vo=service.goodsBestDetailData(no);
		model.addAttribute("vo", vo);
		return "goods/goods_best_detail";
	}
	
	
	}

