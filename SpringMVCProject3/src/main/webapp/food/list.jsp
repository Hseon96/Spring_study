<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top:  50px;
}
.row{
	margin: 0px auto;
	width:  100%
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
		  <c:forEach var="vo" items="${list }">
		    <div class="col-md-3">
			    <div class="thumbnail">
			      <a href="detail_before.do?fno=${vo.fno }"> <!-- ?는 GET !!  -->
			        <img src="${vo.poster }" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p>${vo.name }</p>
			        </div>
			      </a>
			    </div>
			  </div>
		  </c:forEach>
		</div>
		<div class="row">
			<div class="text-center">
			  <a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
			  ${curpage } page / ${totalpage } pages
			  <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-danger">다음</a>
			</div>
		</div>
		 <div style="height: 50px"></div>
		<div class="row">
       <h3>최근 방문 상품</h3>
       <a href="cookie_all_delete.do" class="btn btn-xs btn-danger">쿠키 전체삭제</a>
        <hr>
        <c:if test="${size<1 }">
          <span style="color: blue"> 방문기록이 없습니다</span>
        </c:if>
        <c:if test="${size>0 }">
          <c:forEach var="vo" items="${fList }" varStatus="s"> <!-- 트랜잭션 : 일괄 처리 -->
         <c:if test="${s.index<6 }">  <!--쿠키 6개이상 출력안되게  -->
          	<div class="col-md-2">
		      <div class="thumbnail">
		        <a href="#">
		          <img src="${vo.poster }" alt="Lights" style="width:100%">
		        </a>
		      </div>
		    </div>
		    </c:if>
          </c:forEach>
       </c:if> 
		</div>
	</div>
</body>
</html>