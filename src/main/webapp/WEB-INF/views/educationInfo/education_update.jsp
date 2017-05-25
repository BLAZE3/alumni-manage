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
	<script type="text/javascript" src="js/educationInfo/education_update.js"></script>
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
					<select id="country" onchange="fillProvince(this.options[this.options.selectedIndex].value);">
						<option value="">--请选择国家--</option>
					</select>
					&nbsp;
				</td>
				<td>
					<select id="province" onchange="fillCity(this.options[this.options.selectedIndex].value);">
						<option value="">--请选择省份--</option>
					</select>
					&nbsp;
				</td>
				<td>
					<select id="city" onchange="fillSchoolName(this.options[this.options.selectedIndex].value);">
						<option value="">--请选择城市--</option>
					</select>
					&nbsp;
				</td>
				<td>
					<select id="schoolName" name="schoolName" title="请选择学校" class="submit_check">
						<option value="">--请选择学校--</option>
					</select>
					&nbsp;
				</td>
				<td>
					<input type="text" name="institute" placeholder="请输入所在院" title="请输入所在院" class="submit_check">&nbsp;
					<!-- <select name="institute" title="请选择学院">
						<option>--所在学院--</option>
						<option value="软件学院">软件学院</option>
						<option value="计算机学院">计算机学院</option>
					</select> -->
				</td>
				<td>
					<input type="text" name="major" placeholder="请输入专业" title="请输入专业" class="submit_check">&nbsp;
					<!-- <select name="major" title="请选择专业">
						<option>--所在专业--</option>
						<option value="软件系统设计">软件系统设计</option>
						<option value="嵌入式软件设计">嵌入式系统</option>
						<option value="移动软件设计">移动软件设计</option>
						<option value="网络信息安全">网络信息安全</option>
					</select> -->
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

<div style="margin-top: 1rem" align="center">
	<table style='border:1px solid #ff00ff;'>
		<c:if test="${educationInfoList.size()>0}">
			<c:forEach items="${educationInfoList}" var="education" varStatus="status">
				<tr>
					<td style="padding-left: 1rem;color: blue;">
						${status.count}
					</td>
					<td style="padding-left: 1rem">
						${education.schoolName}
						<!-- <select name="school_name">
							<option>--请选择学校--</option>
							<option value="中国科学技术大学">中国科学技术大学</option>
							<option value="中国科学院大学">中国科学院大学</option>
						</select> -->
					</td>
					<td style="padding-left: 1rem">
						${education.institute}
						<!-- <input type="text" name="institute"> -->
					</td>
					<td style="padding-left: 1rem">
						${education.major}
						<!-- <input type="text" name="major"> -->
					</td>
					<td style="padding-left: 1rem">
						${education.education}
						<!-- <input type="text" name="education"> -->
					</td>
					<td style="padding-left: 1rem">
						${education.entranceTimeStr}
						<!-- <input type="text" name="userName" placeholder="请输入入学年份"> -->
					</td>
					<td style="padding-left: 1rem">
						${education.graduationTimeStr}
						<!-- <input type="text" name="userName" placeholder="请输入毕业年份"> -->
					</td>
					<td style="padding-left: 1rem">
						<!-- <button id="update_btn" type="button" onclick="updateEducation()">修改</button>
						&nbsp; -->
						<button class="del_btn" type="button" onclick="delEducationById('${education.id}')">删除</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</div>
</body>
</html>