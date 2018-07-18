<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; 
%> 
<!DOCTYPE html>
<html>
<head>
<title>图书馆</title>
<base href="<%=basePath %>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-v1.12.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		var msg = "${msg}";
		if(msg != ''){
			$(".error_msg").append("<span>*${msg}</span>");
			$("#username").val("${username}");
			$("#pwd").val("${username}");
		}
	});
</script>
</head>
<body>
	<div class="nav">
		<div class="personal">
				<img src="img/black.png" alt="">
				<span id="" class="Person">个人用户</span>
		</div>
		<form id="loginForm" action="user/login" method="post">
			<div class="data-username">
				<p class="username-img"></p>
				<input type="text" id="username" name="username" placeholder="请输入身份证号\账户名" />
			</div>
			<div class="data-pwd">
				<p class="pwd-img"></p>
				<input type="password" id="pwd" name="pwd" placeholder="请输入密码" />
			</div>
			<input class="btn" onclick="doLogin();" value="登  录"/>
			<a href="user/register" class="reg_bt">注 册</a>
			<a href="user/page/forget" class="forget_bt">忘记密码</a>
		</form>
		<div class="error_msg">
			
		</div>
		<div class="footer">
			<p style="height: 40px">Copyright 2017-2018 浦东图书馆 .</p>
		</div>
	</div>
</body>
<script type="text/javascript">
	function doLogin(){
		if($(".error_msg>span").length > 0){
			$(".error_msg>span").remove();
		}
		var u = $("#username").val();
		var p = $("#pwd").val();
		if($.trim(u) == ''){
			$(".error_msg").append("<span>*账号不能为空！</span>");
			return
		}
		if($.trim(p) == ''){
			$(".error_msg").append("<span>*密码不能为空！</span>");
			return
		}
		$("#loginForm").submit();
	}
</script>
</html>