<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; 
%> 
<!DOCTYPE html>
<html>
<head>
<title>书籍列表</title>
<base href="<%=basePath %>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jQuery-v1.11.2.min.js"></script>
<script type="text/javascript">
function query(){
	var key = $("#key").val();
	$.post("book/query.json",
			{
				"bookNo" : key
			},
	function(data){
		var total = data.total;
		alert("总行数为：" + total);
		if($(".content").length > 0){
			$(".content").remove();
		}
		
		if($.trim(total) == '0'){
			$(".data-tab").append("<tr class='content'><td></td><td><span font='red'>* 没有您查询的数据！</span></td></tr>")
		}else{
			var d = data.rows;
			for(i = 0,len=d.length; i < len; i++) {
				var obj = d[i]; 
				var div = "<tr class='content'> <td> " + obj.id +" </td> " + 
							   "<td> " + obj.bookNo +" </td> " +
							   "<td> " + obj.bookName +" </td> " +
							   "<td> " + obj.author +" </td> " +
							   "<td> " + obj.publisher +" </td> " +
							   "<td> " + obj.synopsis +" </td> " +
							   "<td> " + obj.location +" </td> " +
							   "<td> " + obj.status +" </td> " +
						 "</tr>";
				$(".data-tab").append(div);
			}
		}
	}
	)
}
</script>
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