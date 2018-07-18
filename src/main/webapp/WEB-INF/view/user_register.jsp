<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; 
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/reg.css">
<title>用户注册</title>
</head>
<body>
	<div class="data-reg">
		<h3>新增用户</h3> 
		<form action="user/insert" method="post">
			<div>
				<label class="title">手机号：</label>
				<input type="text" name="mobile" placeholder="请输入手机号"/>
			</div>
			<div>
				<label class="title">密码：</label>
				<input type="password" name="password" placeholder="密码"/>
			</div>
			<div>
				<label class="title">用户名：</label>
				<input type="text" name="name" placeholder="用户名"/>
			</div>
			<div>
				<label class="title">昵称：</label>
				<input type="text" name="nickname" placeholder="昵称"/>
			</div>
			<input type="submit" value="新  增">
		</form>
	</div>
</body>
</html>