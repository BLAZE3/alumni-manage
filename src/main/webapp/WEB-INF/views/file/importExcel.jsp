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
			var file = $("#file_upload").val();
			if(file == ""){
				alert("请先选择要导入xls文件!");
				return false;
			}else {
				return true;
			}
		}
	</script>
</head>
<body>
<div style="margin: 5rem 20rem 0 30rem">
<h2>用户信息批量导入</h2>
<form action="user/importExcel" method="post" enctype="multipart/form-data" onsubmit="return submitCheck();">
	<table style="margin-top: 10rm">
		<tr>
			<td>
				<input id="file_upload" type="file" name="file"/><br>
			</td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" onclick="downImportUserModel();" ><p style="font-size:0.8rem">下载学生信息导入模板.xls</p></a>
			</td>
		</tr>
		<tr>
			<td>
				<button type="submit">导入</button>
			</td>
		</tr>
	</table>
</form>
</div>
	
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