<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户批量导入</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/component/title.jsp"/>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		var errorCount = "${error_count}";
		
		var operate = "${operate}";
		// 关闭页面-非脚本打开不会起作用
		if(operate!=null&&operate=="close"){
			alert("导入成功,初始密码是用户账号");
			window.opener=null;
			window.close();
		}
		
		$(function(){
			if(errorCount!=null && errorCount!=""){
				$("#error_message").show();
			}else {
				$("#error_message").hide();
			}
			
		});
		
		function downImportUserModel(){
			window.open("fileOperate/downImportUserModel");
		}
		
		function submitCheck(){
			return true;
		}
	</script>
</head>
<body>
	<a href="javascript:window.close();">关闭</a><br>
	<a href="javascript:void(0);" onclick="downImportUserModel();">下载学生信息导入模板.xls</a>
	<form action="user/importExcel" method="post" enctype="multipart/form-data" onsubmit="submitCheck();">
		<input type="file" name="file"/><br>
		<button type="submit">上传</button>
	</form>
	
	<!-- 批量导入错误信息 -->
	<div id="error_message">
		<table>
			<thead>
				<tr>
					<td colspan="2">批量导入错误信息</td>
				</tr>
			</thead>
			<c:forEach var="msg" items="${error_list}" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${msg}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>