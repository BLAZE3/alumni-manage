<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>资源上传</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/component/title.jsp"/>
	<script type="text/javascript">
		function submitCheck(){
			return true;
		}
	</script>
</head>
<body>
	<form action="fileOperate/upload" method="post" enctype="multipart/form-data" onsubmit="submitCheck();">
		<input type="file" name="file"/><br>
		<textarea rows="" cols="" name="fileDesc" ></textarea>
		<button type="submit">上传</button>
	</form>
</body>
</html>