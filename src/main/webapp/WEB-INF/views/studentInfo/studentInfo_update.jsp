<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>学生信息修改</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/component/title.jsp"></jsp:include>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		
		// 提交表单
		$("#submit_btn").click(function(){
			if(confirm("确认提交?")){
				$("#student_update_form").submit();
				window.parent.location.reload();
			}
		});
	});
	
</script>
<body>
	<form id="student_update_form" action="studentInfo/updateStudentInfo" method="post">
		<input type="hidden" name="id" value="${studentInfo.id}">
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td>用户账号</td>
					<td><input type="text" name="userName" value="${userInfo.userName}" disabled="disabled"></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="studentName" value="${studentInfo.studentName}"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age" value="${studentInfo.age}"></td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input type="text" name="telephone" value="${studentInfo.telephone}"></td>
				</tr>
				<tr>
					<td>联系地址</td>
					<td><input type="text" name="address" value="${studentInfo.address}"></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input type="text" name="email" value="${studentInfo.email}"></td>
				</tr>
				<tr>
					<td>QQ</td>
					<td><input type="text" name="wechat" value="${studentInfo.wechat}"></td>
				</tr>
				<tr>
					<td>微信</td>
					<td><input type="text" name="qq" value="${studentInfo.qq}"></td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="educationInfo/forwardEducationInfoPage" target="_blank">学历信息</a>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<button id="submit_btn" type="button">提交</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="reset">重置</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>