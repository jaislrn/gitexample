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
	${db.fetchAllEmps()}
	<table border="1">
		<thead>
			<tr>
				<td>Emp No</td>
				<td>Name</td>
				<td>Job</td>
				<td>Dept No</td>
			</tr>
		</thead>
		<c:forEach var="e" items="${db.empList}">
			<tr>
				<td>${e.empid}</td>
				<td>${e.name}</td>
				<td>${e.job}</td>
				<td><a href="dept.jsp?deptno=${e.dept.deptno}">${e.dept.deptno}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

