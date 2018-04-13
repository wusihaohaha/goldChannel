<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录</title>
		<script src="${pageContext.request.contextPath}/resources/goldchannel/js/jquery.min.js"></script>
	</head>

	<body>
		<div class="mui-content-hyl">
			<div class="hyl-input-group">
				<div class="hyl-input-row">
					<input type="tel" class="clearfix hyl-input" id="telephone" name="telephone" placeholder="请输入手机号码" />
				</div>
				<div class="hyl-input-row">
					<input type="password" class="hyl-input-clear hyl-input" id="password" name="password" placeholder="请输入密码" />
				</div>
				<button class="hyl-btn" type="button" onclick="login();" value="登&nbsp;录">登&nbsp;录</button>
			</div>
		</div>
		
		<script type="text/javascript">
			function login(){
				var telephone = document.getElementById("telephone").value;
				var password = document.getElementById("password").value;

				$.ajax({
					type: "POST",
		             url: "${pageContext.request.contextPath}/login",
		             data: {
		            	 telephone:telephone,
		            	 password:password
		             },
		             dataType: "json",
		             success: function(data)
		             {
		            	var returnCode = data.returnCode;
		            	if(returnCode == '200')
		            	{
		            		alert('登录成功');
		            		//window.location = '${pageContext.request.contextPath}/login/allnumStatistics';
		            	} else if(returnCode == '201')
		            	{
		            		alert('用户名或者密码错误');
		            	} else if(returnCode == '400')
		            	{
		            		alert('连接服务器失败,请重试!');
		            	}
		             },
					 error: function()
					 {
						 alert('连接服务器失败,请重试!');
		             }
				});
			}
		</script>
	</body>
</html>