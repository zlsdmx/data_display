<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>upload</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<style>
html {
	font-family: "微软雅黑";
}

h1 {
	font-size: 20px;
	font-weight: normal;
}

h1 img {
	width: 20%;
	vertical-align: top;
}

form>.info {
	border-radius: 6px;
	margin-bottom: 15px;
	background: #fff;
	width: 100%;
	border: 1px solid #ddd;
	height: 45px;
	line-height: 45px;
	overflow: hidden;
	box-sizing: border-box;
}

form>div {
	margin: 10px 0;
}

.info>input {
	border-radius: 6px;
	width: 100%;
	height: 100%;
	box-sizing: border-box;
	left: 0;
	top: 0;
	bottom: 0;
	padding: 10px;
	border: 0;
}

.sub {
	border: 1px solid #344D5A;
	text-align: center;
	box-sizing: border-box;
	width: 100%;
	border-radius: 32px;
	padding: 12px;
	margin-bottom: 10px;
	font-size: 16px;
	color: white;
	background-color: #344D5A;
}

textarea {
	width: 98%;
	margin: 0 auto;
}
</style>
</head>

<body>
	<h1>
			${notification.title}
	</h1>
		<img src="<%=basePath%>/upload/${notification.imageName}" />
	<br>
			${notification.msgContent}
	
</body>
</html>
