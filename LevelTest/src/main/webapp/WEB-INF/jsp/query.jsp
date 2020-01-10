<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.request.contextPath }/">
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="static/css/bootstrap.min.css" />
	<style type="text/css">
		#ctx>table>ul>li>table{
/*  			display:none;  */
		}
	</style>
</head>
<body>
<!-- 	<div id="ctx"> -->
<!-- 			<compon :date = "date"></compon> -->
<!-- 	</div> -->
	<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					
<!-- 						<li class="active" data-id = "goods"><a href="#">商品管理</a></li> -->
<!-- 						<li data-id = "order"><a href="#">订单管理</a></li> -->
<!-- 						<li data-id = "user"><a href="#">用户管理</a></li> -->
							<div id="ctx">
								<compon :date = "date"></compon>
							</div>
					
				</div>
				
				<div class="col-md-9">
					<div class="nav">
						<ul class="nav nav-tabs" id="menu2">
							<li class="active"><a href="#goods" data-toggle="tab">首页</a></li>
						</ul>
					</div>
					<div class="=tab-content" id="menu3">
						内容
					</div>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript" src="static/js/jquery-1.12.4.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/vue.js"></script>
<script type="text/javascript">

	//默认收起菜单栏
// 	$(function(){
// 		$("#ctx>table>ul>li>table").hide();
	
// 	})
// $(".aa[data-num=0]").find().hide()
$(document).on(".aa[data-num=0]",function(){
	
})

// 	$("#ctx>table>ul>li>span").click(function(){
// 		alert(2113)
// 	})

	Vue.component('compon',{
		props:["date"],
		template:'<table><ul><li v-for="item in date"><a class="aa" :data-num="item.parentid" href="javascript:void(0)">{{item.name}}</a><compon :date = "item.list"></compon></li></ul></table>'
	})
	var vm=new Vue({
		el:"#ctx",
		data(){
			return{
				date:[]
			}
		}
	})
	$(function(){
		$.ajax({
			url:"model/query", 
			data:{"id":0},
			success:function(result){
				vm.date=result
				console.log(result)
			},
			error:function(result){
				alert("报错")
			}
		})
	})
	
	
	$("#menu1 li").click(function(){
				var name=$(this).text();
				var data=$(this).attr("data-id");
				var id=$("#menu2 a[href='#"+data+"']")[0];
				
				
				if(id){
					$("#menu2 a[href='#"+data+"']").parent().addClass("active").siblings().removeClass("active");
					$("#menu3>div").removeClass("active");
					$("#menu3>div[id='"+data+"']").addClass("active");
					$(this).addClass("active").siblings().removeClass("active");	
				}else{
					$("#menu3>div").removeClass("active");
					$("#menu3>div[id='"+data+"']").addClass("active");
					$("#menu2 li").removeClass("active");
					$(this).addClass("active").siblings().removeClass("active");
					$("#menu2").append(`<li class="active"><a href="#${data}" data-toggle="tab"> ${name}</a></li>`);
				}
								
			})
</script>
</html>