package com.sist.xmlanno;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MovieDAO extends SqlSessionDaoSupport{
	
	public List<MovieVO> movieListData(Map map)
	{
		return getSqlSession().selectList("movieListData",map);
	}
}
