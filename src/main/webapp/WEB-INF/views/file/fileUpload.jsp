<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>资源上传</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/component/title.jsp"/>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		function submitCheck(){
			var file = $("#file_upload").val();
			if(file == ""){
				alert("请先选择要上传的资源文件!");
				return false;
			}else {
				return true;
			}
		}
	</script>
</head>
<body>
<div style="margin: 5rem 0rem 0 15rem">
<h2 style="margin-left: 18rem">资源上传</h2>
	<form action="fileOperate/upload" method="post" enctype="multipart/form-data" onsubmit="return submitCheck();">
		<table>
			<tr>
				<td><span style="font-size: 0.8rem;margin-right: 1rem">待上传资源</span></td>
				<td>
					<input type="file" name="file" id="file_upload"/><br>	
				</td>
			</tr>
			<tr>
				<td><span style="font-size: 0.8rem;margin-right: 1rem">资源描述(250个字以内)</span></td>
				<td>
					<textarea style="font-size: 0.8rem;margin-top: 1rem" id="fileDesc" cols="60" rows="5" name="fileDesc" onchange="this.value=this.value.substring(0, 250)" onkeydown="this.value=this.value.substring(0, 250)" onkeyup="this.value=this.value.substring(0, 250)"></textarea><br>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<button style="margin-top: 1rem" type="submit">上传</button>
				</td>
			</tr>
		</table>
		</form>
</div>
</body>
</html>