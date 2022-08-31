package com.sist.main;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.net.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
@Component
public class MovieManager {
	public static void main(String[] args) {
		MovieManager m=new MovieManager();
		m.movieListData(1);
	}
	public List<MovieVO> movieListData(int no)
	{
		List<MovieVO> list=new ArrayList<MovieVO>();
		try
		{
			String strUrl="";
			if(no==1)
				strUrl="";
			else if(no==2)
				strUrl="";
			else if(no==3)
				strUrl="";
			else if(no==4)
				strUrl="";
			
			URL url=new URL(strUrl);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection(); // 웹사이트 연결
			StringBuffer sb=new StringBuffer();
			if(conn!=null) // 연결되었다면
			{
				BufferedReader in=
						new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				while(true)
				{
					String data=in.readLine();
					if(data==null)
						break;
					//System.out.println(data);
					sb.append(data);
				}
				in.close();
			}
			System.out.println(sb.toString());
			
			String json=sb.toString();
			JSONParser jp=new JSONParser();
			JSONArray arr=(JSONArray)jp.parse(json);
			for(int i=0;i<arr.size();i++)
			{
				JSONObject obj=(JSONObject)arr.get(i);
				System.out.println("제목:"+obj.get("movieNM"));
				System.out.println("장르:"+obj.get("genre"));
				System.out.println("등급:"+obj.get("watchGradeNM"));
				System.out.println("감독:"+obj.get("director"));
				System.out.println("===============================");
				MovieVO vo=new MovieVO();
				vo.setTitle((String)obj.get("movieNm"));
				vo.setGenre((String)obj.get("genre"));
				vo.setGrade((String)obj.get("watchGradeNm"));
				vo.setDirector((String)obj.get("director"));
				list.add(vo);
			}

		}catch(Exception ex) {}
		return list;
	}
}
