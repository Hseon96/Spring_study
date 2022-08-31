package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO                   NUMBER         
	GOODS_NAME           VARCHAR2(1000) 
	GOODS_SUB            VARCHAR2(1000) 
	GOODS_PRICE          VARCHAR2(50)   
	GOODS_DISCOUNT       NUMBER         
	GOODS_FIRST_PRICE    VARCHAR2(20)   
	GOODS_DELIVERY       VARCHAR2(20)   
	GOODS_POSTER         VARCHAR2(260)  
 */
@Getter
@Setter
public class GoodsVO {
	private int no,discount;
	private String name,sub,price,first_price,delivery,poster;
}
