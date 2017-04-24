<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>修改用户密码</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/component/title.jsp"></jsp:include>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$("#submit_btn").click(function(){
			var url="user/updatePassword";
			var newPassword=$("#newPassword").val();
			var rePassword=$("#rePassword").val();
			if(newPassword!=rePassword){
				alert("两次输入的密码不一致,请重新输入!!!");
				$(".update_password").val("");
				return;
			}
			
			$.post(
				url,
				$("#update_password_form").serialize(),
				function(data){// 回调函数
					if(data.info=="success"){
						alert("修改成功");
						location.reload();// 刷新
					}else {
						alert(data.info);
					}
				},
				"json"
			);
		});
	});
</script>
<body>
	<form id="update_password_form" action="">
	<input type="hidden" name="id" value="${userInfo.id}">
	<table>
		<tr>
			<td>账户名</td>
			<td>${userInfo.userName}</td>
		</tr>
		<tr>
			<td>旧密码</td>
			<td>
				<input type="password" name="password">
			</td>
		</tr>
		<tr>
			<td>新密码</td>
			<td>
				<input id="newPassword" type="password" name="newPassword" class="update_password">
			</td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td>
				<input id="rePassword" type="password" name="rePassword" class="update_password">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button id="submit_btn" type="button">提交</button>
				<button id="reset_btn" type="reset">重置</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>