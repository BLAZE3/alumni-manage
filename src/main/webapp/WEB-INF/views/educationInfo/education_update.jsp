<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/WEB_INF/tld/c.tld" prefix="c" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学历信息总览</title>
	<jsp:include page="/component/title.jsp"></jsp:include>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		
		$("#add_btn").click(function(){
			$("#add_education_form").submit();
			//location.reload();
		});
	});
</script>
<body>
	<form id="add_education_form" action="educationInfo/addEducationInfo" method="post">
		<input type="hidden" name="studentId" value="${userId}"/>
		<table>
			<tr>
				<td>
					<select name="schoolName">
						<!-- <option>--请选择学校--</option> -->
						<option value="中国科学技术大学">中国科学技术大学</option>
						<option value="中国科学院大学">中国科学院大学</option>
					</select>
				</td>
				<td>
					<!-- <input type="text" name="institute" placeholder="请输入所在院"> -->
					<select name="institute">
						<!-- <option>--所在学院--</option> -->
						<option value="软件学院">软件学院</option>
						<option value="计算机学院">计算机学院</option>
					</select>
				</td>
				<td>
					<!-- <input type="text" name="major" placeholder="请输入专业"> -->
					<select name="major">
						<!-- <option>--所在专业--</option> -->
						<option value="软件系统设计">软件系统设计</option>
						<option value="嵌入式软件设计">嵌入式系统</option>
						<option value="移动软件设计">移动软件设计</option>
						<option value="网络信息安全">网络信息安全</option>
					</select>
				</td>
				<td>
					<input type="text" name="education" placeholder="请输入学历">
				</td>
				<td>
					<input type="text" name="entranceTimeStr" placeholder="请输入入学年份">
				</td>
				<td>
					<input type="text" name="graduationTimeStr" placeholder="请输入毕业年份">
				</td>
				<td>
					<button id="add_btn" type="button">添加</button>
					&nbsp;&nbsp;
					<button type="reset">重置</button>
				</td>
			</tr>
		</table>
	</form>
	
	<table>
		<c:if test="${educationInfoList.size()-1>0}">
			<c:forEach items="${educationInfoList}" var="education" varStatus="status">
				<tr>
					<td>
						${status.count}
					</td>
					<td>
						${education.schoolName}
						<!-- <select name="school_name">
							<option>--请选择学校--</option>
							<option value="中国科学技术大学">中国科学技术大学</option>
							<option value="中国科学院大学">中国科学院大学</option>
						</select> -->
					</td>
					<td>
						${education.institute}
						<!-- <input type="text" name="institute"> -->
					</td>
					<td>
						${education.major}
						<!-- <input type="text" name="major"> -->
					</td>
					<td>
						${education.education}
						<!-- <input type="text" name="education"> -->
					</td>
					<td>
						${education.entranceTimeStr}
						<!-- <input type="text" name="userName" placeholder="请输入入学年份"> -->
					</td>
					<td>
						${education.graduationTimeStr}
						<!-- <input type="text" name="userName" placeholder="请输入毕业年份"> -->
					</td>
					<td>
						<button id="update_btn" type="button">修改</button>
						&nbsp;&nbsp;
						<button id="del_btn" type="button">删除</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>