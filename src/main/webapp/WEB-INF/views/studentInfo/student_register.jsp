<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>学生信息注册</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/component/title.jsp"></jsp:include>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		if(submitCheck()){
			// 提交表单
			$("#submit_btn").click(function(){
				if(confirm("确认提交?")){
					$("#student_register_form").submit();
				}
			});
		}
	});
	
	// 提交前验证
	function submitCheck(){
		var msg = null;// 错误提示
		$(".submit_check").each(function(i,n){
			var content = $(n).val();
			if(content==null || content==""){
				msg = $(n).attr("placeholder");
				return;
			}
		});
		if(!msg){
			return true;
		}else {
			alert (msg);
			return false;
		}
	}
</script>
<body>
	<form id="student_register_form" action="studentInfo/studentRegister" method="post">
		<input type="hidden" name="id" value="${loginUser.id}">
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td>用户账号</td>
					<td>
						${loginUser.userName}
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>姓名</td>
					<td><input type="text" name="studentName" class="submit_check" placeholder="请输入姓名"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age" placeholder=""></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<input id="sex_male" type="radio" name="sex" value="男"><label for="sex_male">男</label>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="sex_female" type="radio" name="sex" value="女"><label for="sex_female">女</label>
					</td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input type="text" name="telephone" placeholder=""></td>
				</tr>
				<tr>
					<td>联系地址</td>
					<td><input type="text" name="address" placeholder=""></td>
				</tr>
				<tr>
					<td><font color="red">*</font>邮箱</td>
					<td><input type="text" name="email" class="submit_check" placeholder="请舒服邮箱"></td>
				</tr>
				<tr>
					<td>QQ</td>
					<td><input type="text" name="wechat" placeholder=""></td>
				</tr>
				<tr>
					<td>微信</td>
					<td><input type="text" name="qq" placeholder=""></td>
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