package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// BI => DAO 여러개 통합해서 사용
@Service
public class GoodsService {
	@Autowired
	private GoodsAllDAO adao;
	@Autowired
	private GoodsBestDAO bdao;
	@Autowired
	private GoodsSpecialDAO sdao;
	@Autowired
	private GoodsNewDAO ndao;
	
	
	public List<GoodsVO> goodsAllListData(Map map)
	{
		return adao.goodsAllListData(map);
	}
	public GoodsVO goodsAllDetailData(int no)
	{
		return adao.goodsAllDetailData(no);
	}
	
	public List<GoodsVO> goodsBestListData(Map map)
	{
		return bdao.goodsbestListData(map);
	}
	public GoodsVO goodsBestDetailData(int no)
	{
		return bdao.goodsbestDetailData(no);
	}
	
	public List<GoodsVO> goodsSpecialListData(Map map)
	{
		return sdao.goodsspecialListData(map);
	}
	public GoodsVO goodsSpecialDetailData(int no)
	{
		return sdao.goodsspecialDetailData(no);
	}
	
	public List<GoodsVO> goodsNewListData(Map map)
	{
		return ndao.goodsNewListData(map);
	}
	public GoodsVO goodsNewDetailData(int no)
	{
		return ndao.goodsNewDetailData(no);
	}
	public int goodsAllTotalPage()
	{
		return adao.goodsAllTotalPage();
	}
	public int GoodsBestTotalPage()
	{
		return bdao.GoodsBestTotalPage();
	}
	
}
