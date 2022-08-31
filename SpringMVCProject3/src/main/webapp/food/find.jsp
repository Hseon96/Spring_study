<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Vue 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
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
	   <input type="text" size=20 class="input-sm" v-model="loc">
	   <input type="button" value="검색" class="btn btn-sm btn-primary" v-on:click="find()">
	 </div>
	 <div style="height: 20px"></div>
	 <div class="row">
	   <div class="col-md-4" v-for="vo in list"> <!-- 반복문 이렇게 씀! -->
			    <div class="thumbnail">
			      <a href="#"> <!-- ?는 GET !!  -->
			        <img src="vo.poster" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p>{{vo.name }}</p>
			        </div>
	      	      </a>
		    </div>
		</div>
	 </div>
	 <script>
	 	new Vue({
	 		el: '.container',
	 		data:{
		 			loc:'강남',
		 			list:[],
		 			curpage:1,
		 			totalpage:0
	 		},
	 		mounted:function(){  // $(function())  영역지정..?
	 			axios.get('http://localhost:8080/web/food/food_find_vue.do',{
	 				params:{
		 					page:this.curpage,
		 					loc:this.loc // 값만 넘어간다  // ?뒤에 들어가는 값임 이 두개가
	 				}
	 			}).then(res=>{
	 					  this.list=res.data
	 			})
	 		},
	 		methods:{
	 			find:function(){
	 				axios.get('http://localhost:8080/web/food/food_find_vue.do',{
		 				params:{
		 						page:this.curpage,
		 						loc:this.loc // 값만 넘어간다  // ?뒤에 들어가는 값임 이 두개가
		 				}
		 			}).then(res=>{
		 					this.list=res.data
		 			})

	 			}
	 		}
	 	})
	 </script>
	</div>
</body>
</html>





































