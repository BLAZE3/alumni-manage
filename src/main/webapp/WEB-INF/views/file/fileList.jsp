<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<title>文件资源列表</title>
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
    
	<script type="text/javascript" src="js/file/fileList.js"></script>
	<script type="text/javascript">
		var manager, g;
		var gridManager=$("#maingrid").ligerGetGridManager();
		var is_recycle = "${is_recycle}";//判断是不是回收站
		var file_cancel = "${file_cancel}";// 删除权限
		var file_restore = "${file_restore}";// 删除权限
		var dataUrl = "";
		if(is_recycle == "yes"){
			dataUrl = "fileOperate/queryFileResourcesJson?type=recycle";// 是回收站
			$("#del_btn").hide();
		}else {
			dataUrl = "fileOperate/queryFileResourcesJson";// 不是回收站
		}
		$(f_initGrid);
	</script>
</head>
<body>
<div style="margin:1rem 0 0 5rem">
<table>
	<tr>
		<td><span style="margin-left: 1rem">资源名</span></td>
		<td>
			<input type="text" id="fileName" name="fileName" class="select" style="margin-left: 1rem"/>
		</td>
		<td><span style="margin-left: 1rem">发布者</span></td>
		<td>
			<input type="text" id="publisherName" name="publisherName" class="select" style="margin-left: 1rem"/>
		</td>
		<td colspan="2">
			<button id="submit_btn" style="margin-left: 1rem">查询</button>
			&nbsp;&nbsp;
			<button id="reset_btn">重置</button>
			&nbsp;&nbsp;
			<button id="del_btn">删除</button>
		</td>
	</tr>
</table> 
</div>
<div class="l-clear"></div>
<div id="maingrid" style="margin-top:20px;height:90%"></div><br/>
</div>
</body>
</html>