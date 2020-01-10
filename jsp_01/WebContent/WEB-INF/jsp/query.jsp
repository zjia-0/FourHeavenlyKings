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
	<a href="goods?method=toAdd">新增商品</a>
	<table border="1">
		<tr>
			<td>商品名称</td>
			<td>分类</td>
			<td>型号</td>
			<td>单价</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.goodsName }</td>
				<td>${item.className }</td>
				<td>${item.type }</td>
				<td>${item.price }</td>
				<td><a href="goods?method=del&id=${item.goodsId}">删除</a>&nbsp;<a href="goods?method=toUpd&id=${item.goodsId}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>