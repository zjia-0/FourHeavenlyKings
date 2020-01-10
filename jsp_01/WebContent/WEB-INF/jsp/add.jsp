<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>新增页面</h3>
<form action="goods?method=add" name="fm" method="post">
	<input type="hidden"  name=id>
	商品名称：<input type="text" name="name"><br><br>
	商品型号：<input type="text" name="type"><br><br>
	商品分类：<select name="className">
	<c:forEach items="${cList }" var="obj">
		<option value="${obj.id }">${obj.name }</option>
	</c:forEach>
	</select><br><br>
	商品单价：<input type="text" name="price"><br><br>
	<input value="保存" type="submit">
</form>

</body>
<script type="text/javascript" src="/jsp_01/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	if("${cz}"=="upd"){
		$("h3").html("修改页面");
		$("[name=name]").val("${gs.goodsName}");
		$("[name=type]").val("${gs.type}");
		$("[name=price]").val("${gs.price}");
		$("[name=id]").val("${gs.goodsId}");
		$("[name=className]").val("${vl}");
		$("[name=fm]").attr("action","goods?method=upd");
	}
</script>
</html>