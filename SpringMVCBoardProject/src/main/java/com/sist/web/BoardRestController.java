package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
// JavaScript, 일반 데이터, JSON을 전달 
// update.do, update_ok.do(x) ==> Boot
import com.sist.dao.*;
@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	/*
	 *  	HTML (JavaScript) : text/html
	 *  	JSON			  : text/plain  보낼때 쓰는 방식 달라진다
	 */
	
	@PostMapping(value="board/update_ok.do",produces = "text/html;charset=UTF-8")
	// 			======						===================================== 한글변환 할때 꼭쓰기!!
	// 단점  => 크롬에서만 사용이 가능
	public String board_update_ok(BoardVO vo)
	{
		// 자바 스크립트 전송   // 비밀번호검색 .. 수정하기
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>" // 파일명을 주면 파일명을 그대로 가져와버림.. script 꼭 줘야한다
					+"location.href=\"detail.do?no="+vo.getNo()+"\";" // 여기 "" 주는거 어떻게 쓰는지 기억하기~ 너무어렵!!
					+"</script>";
		}
		else
		{
			result="<script>"
					+"alert(\"비번이 틀려요 = Password Fail~!\");" // 한글쓰면 깨짐..
					+"history.back();"
					+"</script>";
		}
		return result;
	}
	
	@PostMapping(value="board/delete_ok.do",produces = "text/html;charset=UTF-8")
	public String board_delete_ok(int no,String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(no,pwd);
		if(bCheck==true)
		{
			result="<script>" 
					+"location.href=\"list.do\";" 
					+"</script>";
		}
		else
		{
			result="<script>"
					+"alert(\"비번이 틀려요 = Password Fail~!\");" // 한글쓰면 깨짐..
					+"history.back();"
					+"</script>";
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
