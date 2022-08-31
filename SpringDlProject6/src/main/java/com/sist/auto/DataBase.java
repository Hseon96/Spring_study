package com.sist.auto;

public interface DataBase {
	@Override
	public void getConnection();
	{
		System.out.println("mysql 연결");
	}
	@Override
	public void disConnection();
	{
		System.out.println();
	}
}
