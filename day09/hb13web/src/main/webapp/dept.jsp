<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept</title>
</head>
<body>
	<jsp:useBean id="db" class="sh.beans.DeptEmpBean"/>
	<jsp:setProperty name="db" property="*"/>
	${db.fetchDept()}
	
	<c:choose>
		<c:when test="${empty db.dept}">
			Department not found.
		</c:when>
		<c:otherwise>
			Dept No: ${db.dept.deptno} <br/>
			Name: ${db.dept.name} <br/>
			Location: ${db.dept.loc} <br/>
			<br/><br/>
			<table border="1">
				<thead>
					<tr>
						<td>Emp No</td>
						<td>Name</td>
						<td>Job</td>
						<td>Dept No</td>
					</tr>
				</thead>
				<c:forEach var="e" items="${db.dept.empList}">
					<tr>
						<td>${e.empid}</td>
						<td>${e.name}</td>
						<td>${e.job}</td>
						<td>${e.dept.deptno}</td>
					</tr>
				</c:forEach>		
			</table>
		</c:otherwise>
	</c:choose>	
</body>
</html>

