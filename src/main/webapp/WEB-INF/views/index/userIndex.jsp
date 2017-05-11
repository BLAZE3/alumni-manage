<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户首页</title>
	<jsp:include page="/component/title.jsp"/>
</head>
<body>
用户主页面<br>
<c:choose>
	<c:when test="${user.type=='2'}">
		<a href="studentInfo/forwardStudentRegister" target="_blank">学生信息认证</a>
	</c:when>
	<c:when test="${user.type=='3'}">
		<a href="javascript:void(0);">学生信息(认证中)</a>
	</c:when>
	<c:otherwise>
		<a href="studentInfo/forwardStudentInfoUpdate?userId=${loginUser.id}" target="_blank">信息管理</a>
	</c:otherwise>
</c:choose>
<a href="user/forwardQueryUserInfo?type=student" target="_blank">查看学生信息(学历信息)</a>
<a href="user/forwardUpdatePassword" target="_blank">密码修改</a>
<a href="fileOperate/forwardUpload" target="_blank">文件上传</a>
<a href="fileOperate/forwardFileList" target="_blank">资源库</a>
<a href="user/logout">注销</a><br>
</body>
</html>