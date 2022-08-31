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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script> 
<script type="text/javascript">
$(function(){
	$('#writeBtn').on('click',function(){
		let name=$('#name').val();
		if(name.trim()=="")
			{
				$('#name').focus();
				return;
			}
		let subject=$('#subject').val();
		if(subject.trim()=="")
			{
				$('#subject').focus();
				return;
			}
		let content=$('#content').val();
		if(content.trim()=="")
			{
				$('#content').focus();
				return;
			}
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
			{
				$('#pwd').focus();
				return;
			}
		$('#frm').submit();
	})
})
</script>
</head>
<body>
	<div class="container">
	  <h1>수정하기</h1>
	  <div class="row">
	  <form method="post" action="update_ok.do" id=frm>
	    <table class="table">
	    	<tr>
	    	   <th width="20%" class="text-right">이름</th>
	    	   <td width="80%"><!-- name의 변수명과 ---- vo변수가 일치해야한다! -->
	    	     <input type="text" name=name id=name size=20 class="input-sm" value="${vo.name }">
	    	     <input type="hidden" name=no value="${vo.no }">
	    	     </td>  
	    	</tr>
	    	<tr>
	    	   <th width="20%" class="text-right">제목</th>
	    	   <td width="80%">
	    	   <input type="text" name=subject id=subject size=50 class="input-sm" value="${vo.subject }">
	    	   </td>
	    	</tr>
	    	<tr>
	    	   <th width="20%" class="text-right">내용</th>
	    	   <td width="80%">
	    	   <textarea rows="10" cols="50" name=content id=content>${vo.content }</textarea>
	    	   </td>
	    	</tr>
	    	<tr>
	    	   <th width="20%" class="text-right">비밀번호</th>
	    	   <td width="80%">
	    	   <input type="password" name=pwd id=pwd size=15 class="input-sm">
	    	   </td> <!-- 유효성 검사 때문에 name id값을 쓴것 -->
	    	</tr>
	    	<tr>
	    	  <td colspan="2" class="text-center">
	    	  <input type="button" value="수정하기" class="btn btn-sm btn-warning" id="writeBtn">
	    	  <input type="button" value="취소" class="btn btn-sm btn-info"
	    	  	onclick="javascript:history.back()">
	    	</tr>
	    </table>
	    </form>
	  </div>
	</div>
</body>
</html>








