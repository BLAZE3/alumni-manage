<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<title>系统操作日志</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/component/title.jsp"/>
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
    
    <!-- 日历控件 -->
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
    
	<script type="text/javascript" src="js/log/logList.js"></script>
	<script type="text/javascript">
		var manager, g;
		var gridManager=$("#maingrid").ligerGetGridManager();
		var dataUrl = "log/queryLogForLigerUI";
		
		$(f_initGrid);
	</script>
	<style type="text/css">
	</style>
</head>

<body>
<div style="margin:1rem 0 0 5rem">
<table>
	<tr>
		<td><span style="margin-left: 1rem">用户名</span></td>
		<td>
			<input type="text" id="userName" name="fileName" class="select" style="margin-left: 1rem"/>
		</td>
		<td><span style="margin-left: 1rem;margin-right: 2rem;">开始时间</span></td>
		<td>
			<input type="text" id="startTime" name="startTime" class="select"/>
		</td>
		<td><span style="margin-left: 1rem;margin-right: 2rem;">截止时间</span></td>
		<td>
			<input type="text" id="endTime" name="endTime" class="select"/>
		</td>
		<td colspan="2">
			<button type="button" id="submit_btn" style="margin-left: 1rem">查询</button>
			&nbsp;&nbsp;
			<button type="button" id="reset_btn">重置</button>
			&nbsp;&nbsp;
			<button type="button" id="cancel_btn">批量删除</button>
		</td>
	</tr>
</table>
</div>
<div id="maingrid" style="margin-top:20px;height:90%"></div><br/>
</div>
</body>
</html>