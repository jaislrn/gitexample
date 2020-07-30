<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="ub" class="sh.beans.UserBean" scope="session"/>
	<jsp:setProperty name="ub" property="*"/>
	${ub.authenticate()}
	<c:choose>
		<c:when test="${not empty ub.user}">
			<c:redirect url="subjects.jsp"/>
		</c:when>
		<c:otherwise>
			Login failed. <br/>
			<a href="index.jsp">Login Again</a>
		</c:otherwise>
	</c:choose>
</body>
</html>