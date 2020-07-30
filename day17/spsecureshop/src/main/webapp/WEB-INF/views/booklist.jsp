<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Cart</title>
</head>
<body>
	Hello, ${cust.name} <hr/>
	<c:set var="total" value="0.0"/>
	<table border="1">
		<thead>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Author</td>
				<td>Subject</td>
				<td>Price</td>
				<td>Image</td>
				<td></td>
			</tr>
		</thead>
		<c:forEach var="b" items="${bookList}">
			<tr>
				<td>${b.id}</td>
				<td>${b.name}</td>
				<td>${b.author}</td>
				<td>${b.subject}</td>
				<td>${b.price}</td>
				<td><img src="download?id=${b.id}" alt="NA" width="150" height="200"/></td>
				<td><a href="upload?id=${b.id}">Upload Image</a></td>
			</tr>			
		</c:forEach>
	</table>
	<br/>
	<a href="${pageContext.request.contextPath}/logout">Sign Out</a> 
</body>
</html>

