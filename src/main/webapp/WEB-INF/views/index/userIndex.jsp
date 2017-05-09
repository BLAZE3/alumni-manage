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
	<c:otherwise>
		<a href="studentInfo/forwardStudentInfoUpdate?studentId=${loginUser.studentId}" target="_blank">学生信息管理</a>
	</c:otherwise>
</c:choose>
<a href="user/forwardUpdatePassword" target="_blank">密码修改</a>
<a href="user/logout">注销</a><br>
</body>
</html>