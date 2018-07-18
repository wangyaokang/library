<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; 
%> 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/info.css">
<title>用户列表</title>
</head>
<body>
	<div class="info">
	<h3>个人基本信息</h3>
		<p>用户${user.mobile} 你好！</p>
		<a href="book/list">书籍列表</a>
		<a href="bag/list">我的书籍</a>
		<table class="data-list">
			<tr>
				<td>姓名：</td>
				<td><input type="text" id="name" value="${user.name}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><input type="text" id="mobile" value="${user.mobile}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>昵称：</td>
				<td><input type="text" id="name" value="${user.nickname} " readonly="readonly"></td>
			</tr>
			<tr>				
				<td>注册时间：</td>
				<td><input type="text" id="birthday" value="${user.regTime}" readonly="readonly"></td>
			</tr>
		</table>
	</div>
</body>
</html>