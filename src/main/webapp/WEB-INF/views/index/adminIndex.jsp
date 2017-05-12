<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<jsp:include page="/component/title.jsp"/>
</head>
<body>
管理员主页面<br>
<a href="user/forwardUserApprove" target="_blank">认证审批</a>
<a href="user/forwardQueryUserInfo?type=student" target="_blank">查看学生信息(学历信息)</a>
<a href="user/forwardQueryUserInfo?type=admin" target="_blank">查看管理员信息</a>
<a href="user/forwardUpdatePassword" target="_blank">查看组信息</a>
<a href="user/forwardUpdatePassword" target="_blank">查看日志</a>
<a href="fileOperate/forwardUpload" target="_blank">文件上传</a>
<a href="fileOperate/forwardFileList" target="_blank">资源库</a>
<a href="fileOperate/forwardImportExcel" target="_blank">信息导入</a>
<a href="fileOperate/forwardFileList?type=recycle" target="_blank">资源回收站</a>
<a href="user/logout">注销</a>
</body>
</html>