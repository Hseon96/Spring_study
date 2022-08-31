<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width: 700px;
}
h1 {
	text-align: center
}
</style><!-- js 라이브러리 유효성 검사 -->  
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script> 
<script type="text/javascript">
$(function(){
	$('#delBtn').on('click',function(){
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
			{
				$('#pwd').focus();
				return;
			}

		$('#frm').submit();
	})
})
</script> -->
</head>
<body>
	<div class="container">
	  <h1>삭제하기</h1>
	  <div class="row">
	  <form method="post" action="delete_ok.do" id=frm>
	    <table class="table">
	    	<tr>
	    	<td>
	    	  <p>비밀번호:</p><input type="password" class="input-sm" name=pwd id="pwd" size=20>
	    	  <input type="hidden" name=no value=${no }>
	    	  </td>
	    	</tr>
	    	<tr>
	    	  <td colspan="2" class="text-center">
	    	 <input type="button" value="삭제" class="btn btn-sm btn-warning" id="delBtn">
	    	  <input type="button" value="취소" class="btn btn-sm btn-info"
	    	  	onclick="javascript:history.back()">
	    	</tr>
	    </table>
	    </form>
	  </div>
	</div>
</body>
</html>









