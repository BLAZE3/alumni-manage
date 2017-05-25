<%@ page language="java" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>

<!-- 本地用 -->
<%-- <c:set var="basePath" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/> --%>
<!-- 服务器上用 -->
<c:set var="basePath" value="${pageContext.request.scheme}://${pageContext.request.serverName}/"/>
<c:set var="requestURL" value="${pageContext.request.requestURL}" />
<base href="${basePath}">
<!-- <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script> -->