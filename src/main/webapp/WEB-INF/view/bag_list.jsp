<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; 
%> 
<!DOCTYPE html>
<html>
<head>
<title>我的书包</title>
<base href="<%=basePath %>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jQuery-v1.11.2.min.js"></script>
</head>
<body>
	<div class="data-list">
		<ul>
			<li><input type="text" id="key" value="" placeholder="请输入关键字"></li>
			<li><input class="btn btn-primary" type="button" value="查询" onclick="query();"/></li>
		</ul>
		<table class="data-tab">
			<tr class="title">
				<th>序号</th>
				<th>书籍编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>简介</th>
				<th>位置</th>
				<th>状态</th>
			</tr>
		</table>
	</div>
</body>
</html>