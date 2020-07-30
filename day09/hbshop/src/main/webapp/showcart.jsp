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
	Hello, ${ub.user.name} <hr/>
	<jsp:useBean id="bb" class="sh.beans.BookBean"/>
	<c:set var="total" value="0.0"/>
	<table border="1">
		<thead>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Author</td>
				<td>Subject</td>
				<td>Price</td>
			</tr>
		</thead>
		<c:forEach var="id" items="${cb.cart}">
			<jsp:setProperty name="bb" property="id" value="${id}"/>
			${bb.fetchBook()}
			<c:set var="total" value="${total + bb.book.price}"/>
			<tr>
				<td>${bb.book.id}</td>
				<td>${bb.book.name}</td>
				<td>${bb.book.author}</td>
				<td>${bb.book.subject}</td>
				<td>${bb.book.price}</td>
			</tr>			
		</c:forEach>
	</table>
	<br/>
	Total Bill: Rs. ${total}/- <br/><br/>
	<a href="logout.jsp">Sign Out</a> 
</body>
</html>

