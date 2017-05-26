<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/WEB_INF/tld/c.tld" prefix="c" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学历信息总览</title>
	<jsp:include page="/component/title.jsp"></jsp:include>
	<!-- <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script> -->
    <script src="ligerUI1.3.3/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script> 
	<link href="ligerUI1.3.3/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <script src="ligerUI1.3.3/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="ligerUI1.3.3/lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
    
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<!-- 可选的Bootstrap主题文件（一般不使用） -->
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
	<script type="text/javascript" src="js/educationInfo/education_update.js"></script>
	<style type="text/css">
		.table th, .table td { 
			text-align: center;
			vertical-align: middle!important;
		}
	</style>
</head>
<script type="text/javascript">
	var operate = "${operate}";
</script>
<body>
<h1 align="center" style="margin-top: 2rem">学历信息</h1>
<div style="margin-top: 2rem" align="center">
	<form id="add_education_form" action="educationInfo/addEducationInfo" method="post" onsubmit="return submitCheck();">
		<input type="hidden" name="studentId" value="${studentId}"/>
		<table>
			<tr>
				<td>
					&nbsp;
					<select id="country" style="text-align: center;" onchange="fillProvince(this.options[this.options.selectedIndex].value);">
						<option value="">--请选择国家--</option>
					</select>
					&nbsp;
				</td>
				<td>
					<select id="province" style="text-align: center;" onchange="fillCity(this.options[this.options.selectedIndex].value);">
						<option value="">--请选择省份--</option>
					</select>
					&nbsp;
				</td>
				<td>
					<select id="city" style="text-align: center;" onchange="fillSchoolName(this.options[this.options.selectedIndex].value);">
						<option value="">--请选择城市--</option>
					</select>
					&nbsp;
				</td>
				<td>
					<select id="schoolName" name="schoolName" title="请选择学校" style="width: 10rem;text-align: center;" class="submit_check">
						<option value="">--请选择学校--</option>
					</select>
					&nbsp;
				</td>
				<td>
					<input type="text" name="institute" placeholder="请输入所在院" title="请输入所在院" class="submit_check">&nbsp;
				</td>
				<td>
					<input type="text" name="major" placeholder="请输入专业" title="请输入专业" class="submit_check">&nbsp;
				</td>
				<td>
					<!-- <input type="text" name="education" placeholder="请输入学历"> -->
					<select name="education" title="请选择学历">
						<option value="大专">大专</option>
						<option value="本科">本科</option>
						<option value="硕士">硕士</option>
						<option value="博士">博士</option>
					</select>
					&nbsp;
				</td>
				<td>
					<input type="text" name="entranceTimeStr" placeholder="入学年份" id="entranceTimeStr" class="submit_time" title="请选择入学时间">
				</td>
				<td>
					&nbsp;-&nbsp;
				</td>
				<td>
					<input type="text" name="graduationTimeStr" placeholder="毕业年份" id="graduationTimeStr" class="submit_time" title="请选择毕业时间">
				</td>
				<td>
					&nbsp;
					<button id="add_btn" type="button">添加</button>
					&nbsp;
					<button type="reset">重置</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<div class="table-responsive" style="margin-top: 2rem">
	<table class="table table-hover table-striped">
	    <thead>
	    <tr>
	        <th style="text-align: center;">
	       		 序号
	        </th>
	        <th style="text-align: center;">
	        	学校
	        </th>
	        <th style="text-align: center;">
	        	学院
	        </th>
	        <th style="text-align: center;">
	          	专业
	        </th>
	        <th style="text-align: center;">
	        	学位
	        </th>
	        <th style="text-align: center;">
	        	入学时间
	        </th>
	        <th style="text-align: center;">
	        	毕业时间
	        </th>
	    </tr>
	    </thead>
	
	    <tbody role="alert" aria-live="polite" aria-relevant="all" id="tBodyId">
			<c:if test="${educationInfoList.size()>0}">
				<c:forEach items="${educationInfoList}" var="education" varStatus="status">
					<tr>
						<td style="padding-left: 1rem;color: blue;text-align: center;">
							${status.count}
						</td>
						<td style="padding-left: 1rem;text-align: center;">
							${education.schoolName}
						</td>
						<td style="padding-left: 1rem;text-align: center;">
							${education.institute}
						</td>
						<td style="padding-left: 1rem;text-align: center;">
							${education.major}
						</td>
						<td style="padding-left: 1rem;text-align: center;">
							${education.education}
						</td>
						<td style="padding-left: 1rem;text-align: center;">
							${education.entranceTimeStr}
						</td>
						<td style="padding-left: 1rem;text-align: center;">
							${education.graduationTimeStr}
						</td>
						<td style="padding-left: 1rem;text-align: center;">
							<button class="del_btn btn btn-warning btn-sm" type="button" onclick="delEducationById('${education.id}')">删除</button>
						</td>
					</tr>
				</c:forEach>
			</c:if>
	    </tbody>
	</table>
</div>

</body>
</html>