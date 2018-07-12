<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页——文件上传</title>
<head>
</head>
<body>
<h1>This is SpringMVC Demo</h1>
<h1>${msg}</h1>

<form action="${pageContext.servletContext.contextPath}/upload/single.mvc" method="post" enctype="multipart/form-data">
   	<input type ="file" name="file"/>
   	<input type="submit" value="上传">
   </form>
   <form action="${pageContext.servletContext.contextPath}/upload/multipart.mvc" method="post" enctype="multipart/form-data">
   	<input type ="file" name="files"/><br>
   	<input type ="file" name="files"/><br>
   	<input type ="file" name="files"/><br>
   	<input type="submit" value="上传多个文件">
   </form>

</body>
</html>