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
   width: 900px;
}
h1 {
	text-align: center
}
</style>
</head>
<body>
	<div class="container">
	 <h1>검색결과</h1>
	  <div class="row">
	     <table class="table">
		    <tr class="success">
		      <th class="text-center" width="10%">번호</th>
		      <th class="text-center" width="10%">제목</th>
		      <th class="text-center" width="10%">이름</th>
		      <th class="text-center" width="10%">작성일</th>
		      <th class="text-center" width="10%">조회수</th>
		    </tr>
		    <c:forEach var="vo" items="${list }">
			<tr class="success">
		      <th class="text-center" width="10%">${vo.no }</th>
		      <th width="45%"><a href="detail.do?no=${vo.no }">${vo.subject }</a></th>
		      <th class="text-center" width="10%">${vo.name }</th>
		      <th class="text-center" width="10%">${vo.dbday }</th>
		      <th class="text-center" width="10%">${vo.hit }</th>
		    </tr>
		    </c:forEach>
		  </table>
	  </div>
	</div>
</body>
</html>