<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<link rel="stylesheet" href="static/css/bootstrap.min.css"
	type="text/css" />
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="ctx">
		<div class="container-fluid">
			<div class="row">

				<div class="col-md-3">
					<tree :modules="list"></tree>
				</div>

				<div class="col-md-9">
					<div class="nav">
						<ul class="nav nav-tabs me-tabs">
							<li class="active"><a href="#index" data-toggle="tab">
									首页</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div class="tab-pane active" id="index">index</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/vue.js"></script>
	<script type="text/javascript">

Vue.component('tree',{
	props:["modules"],
	template:`
	<ul>
		<li v-for="item in modules" class="nav nav-pills nav-stacked">
			<a @click="handler(item)" href="javascript:void(0)">{{item.name}}</a>
			<tree :modules="item.list"></tree>
		</li>
	</ul>
		`,methods:{
						handler:function(item){
							var id = $("#module_"+item.id)[0];
							if(id){
								$(".me-tabs").children().removeClass("active");
								$(".tab-content").children().removeClass("active");
								$(id).addClass("active");
								$("[href='#module_"+item.id+"']").parent().addClass("active"); 
								return;
							}
							var tab = `<li role="presentation" class="active"><a href="#module_${'${item.id}'}" data-toggle = "tab">							
							${"${item.name}"}</a></li>`;
							var pane=$(`<div id="module_${'${item.id}'}" class="active tab-pane">${"${item.name}"}</div>`) 
							var ifr=$("<iframe>");
							ifr.attr("src",item.path);
							pane.append(ifr);
							
							$(".me-tabs").children().removeClass("active").end().append(tab);
							$(".tab-content").children().removeClass("active").end().append(pane);
						}
			}
})

			var vm=new Vue({
				el:"#ctx",
				data(){
					return{
						list:[]
					}
				}
			})
			$(function(){
				$.ajax({
					url:"model/query",
					data:{id:0},
					success:function(result){
						vm.list=result;
					}
				})
			})

</script>
</body>
</html>
