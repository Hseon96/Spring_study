package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsSpecialMapper;

@Repository
public class GoodsSpecialDAO {
	private GoodsSpecialMapper mapper;
	
	public List<GoodsVO> goodsspecialListData(Map map)
	{
		return mapper.goodsspecialListData(map);
	}
	public GoodsVO goodsspecialDetailData(int no)
	{
		return mapper.goodsspecialDetailData(no);
	}
}
