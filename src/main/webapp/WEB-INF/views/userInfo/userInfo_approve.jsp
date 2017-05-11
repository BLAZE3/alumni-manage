<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>学生认证审批</title>
    <jsp:include page="/component/title.jsp"></jsp:include>
    
    <!-- ligerui 表格 -->
    <link href="ligerUI1.3.3/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="ligerUI1.3.3/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/json2.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
    
    <!-- 弹框 -->
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerWindow.js" type="text/javascript"></script>
    
    <!-- toolbar -->
    <link href="ligerUI1.3.3/lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>

    <script src="js/userInfo/userInfo_approve.js" type="text/javascript"></script>
    <script type="text/javascript">
    	var operate = "${operate_tag}";
    	var gridManager=$("#maingrid").ligerGetGridManager();
	    var manager, g;
	    $(f_initGrid);
	</script>
</head>

<body style="padding:10px">
<table>
	<tr>
		<td>账号</td>
		<td>
			<input type="text" id="userName" name="userName" class="select"/>
		</td>
		<td>姓名</td>
		<td>
			<input type="text" id="studentName" name="studentName" class="select"/>
		</td>
		<td colspan="2">
			<button id="submit_btn">查询</button>
			&nbsp;&nbsp;
			<button id="reset_btn">重置</button>
		</td>
	</tr>
</table> 
<div class="l-clear"></div>
   <div id="maingrid" style="margin-top:20px"></div><br/>
</div>
</body>
</html>
