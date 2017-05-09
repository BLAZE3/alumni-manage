<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>资源详情</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/component/title.jsp"/>
</head>
<body>
	<table>
		<tr>
			<td>资源名</td>
			<td>${file.fileName}</td>
		</tr>
		<tr>
			<td>上传者</td>
			<td>${file.publisherName}</td>
		</tr>
		<tr>
			<td>文件大小</td>
			<td>${file.fileSize}</td>
		</tr>
		<tr>
			<td>上传时间</td>
			<td>${file.publishTimeStr}</td>
		</tr>
		<tr>
			<td>下载次数</td>
			<td>${file.downCount}</td>
		</tr>
		<tr>
			<td>资源描述</td>
			<td>${file.fileDesc}</td>
		</tr>
	</table>

</body>
</html>