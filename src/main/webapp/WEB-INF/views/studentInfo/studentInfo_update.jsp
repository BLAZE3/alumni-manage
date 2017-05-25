<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		// 性别默认选中
		var sex = "${studentInfo.sex}";
		$(".sex_radio[value='${studentInfo.sex}']").attr("checked", true);
		// 提交表单
		$("#submit_btn").click(function(){
			if(confirm("确认提交?")){
				var url = "studentInfo/updateStudentInfo";
				$.post(url,$("#student_update_form").serialize(),function(){
					window.parent.location.reload();
				});
				//$("#student_update_form").submit();
			}
		});
	});
	
</script>
<body>
	<%-- <c:if test="${studentInfo!=null}"> --%>
	<form id="student_update_form" action="studentInfo/updateStudentInfo" method="post">
		<input type="hidden" name="id" value="${studentInfo.id}">
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td style="padding-left: 1rem">用户账号</td>
					<td style="padding-left: 1rem"><input type="text" name="userName" value="${userInfo.userName}" disabled="disabled"></td>
				</tr>
				<tr>
					<td style="padding-left: 1rem">姓名</td>
					<td style="padding-left: 1rem"><input type="text" name="studentName" value="${studentInfo.studentName}"></td>
				</tr>
				<tr>
					<td style="padding-left: 1rem">年龄</td>
					<td style="padding-left: 1rem"><input type="text" name="age" value="${studentInfo.age}"></td>
				</tr>
				<tr>
					<td style="padding-left: 1rem">性别</td>
					<td style="padding-left: 1rem">
						<input id="sex_male" type="radio" name="sex" value="男" class="sex_radio"><label for="sex_male">男</label>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="sex_female" type="radio" name="sex" value="女" class="sex_radio"><label for="sex_female">女</label>
					</td>
				</tr>
				<tr>
					<td style="padding-left: 1rem">手机号</td>
					<td style="padding-left: 1rem"><input type="text" name="telephone" value="${studentInfo.telephone}"></td>
				</tr>
				<tr>
					<td style="padding-left: 1rem">联系地址</td>
					<td style="padding-left: 1rem"><input type="text" name="address" value="${studentInfo.address}"></td>
				</tr>
				<tr>
					<td style="padding-left: 1rem">邮箱</td>
					<td style="padding-left: 1rem"><input type="text" name="email" value="${studentInfo.email}"></td>
				</tr>
				<tr>
					<td style="padding-left: 1rem">QQ</td>
					<td style="padding-left: 1rem"><input type="text" name="wechat" value="${studentInfo.wechat}"></td>
				</tr>
				<tr>
					<td style="padding-left: 1rem">微信</td>
					<td style="padding-left: 1rem"><input type="text" name="qq" value="${studentInfo.qq}"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<a href="educationInfo/forwardEducationInfoPage?studentId=${studentInfo.id}" target="_blank">学历信息</a>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="center">
						<button id="submit_btn" type="button">提交</button>
						<button type="reset" style="margin-left: 1rem">重置</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	<%-- </c:if> --%>
</body>
</html>