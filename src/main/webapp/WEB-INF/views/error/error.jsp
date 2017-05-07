<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误信息提示</title>
</head>
<body>
	<h1>抱歉,遇到错误了!</h1>
	<h2>错误信息:${error_message}</h2>
	<h3>请与<a href="javascript:void(0)" target="_blank">管理员联系</a>或返回<a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" target="_top">首页</a>。</h3>
</body>
</html>