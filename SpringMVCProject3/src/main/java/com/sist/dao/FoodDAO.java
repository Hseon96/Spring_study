package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
@Repository  // == dao 와 같은말..
public class FoodDAO {
	@Autowired // 자동 주입 
	private FoodMapper mapper; // 구현된 주소값 넘김..***** 여기 하는 방식 *****return값도 잘보기  
	
	public List<FoodVO> foodListData(Map map)
	{
		return mapper.foodListData(map); // 핵심 코딩
	}
	
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
	
}
