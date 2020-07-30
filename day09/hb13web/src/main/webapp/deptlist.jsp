<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept List</title>
</head>
<body>
	<jsp:useBean id="db" class="sh.beans.DeptEmpBean"/>
	${db.fetchAllDepts()}
	<table border="1">
		<thead>
			<tr>
				<td>Dept No</td>
				<td>Name</td>
				<td>Location</td>
				<td></td>
			</tr>
		</thead>
		<c:forEach var="d" items="${db.deptList}">
			<tr>
				<td>${d.deptno}</td>
				<td>${d.name}</td>
				<td>${d.loc}</td>
				<td><a href="dept.jsp?deptno=${d.deptno}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

