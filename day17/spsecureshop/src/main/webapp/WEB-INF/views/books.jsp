<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
	Hello, ${cust.name} <hr/>
	<sf:form action="addcart">
		<c:forEach var="b" items="${bookList}">
			<sf:checkbox path="book" value="${b.id}" label="${b.name}"/> 
			<a href="details?id=${b.id}&subject=${b.subject}">Details</a>
			<br/>
		</c:forEach>
		<%--
		<sf:checkboxes path="book" items="${bookList}" itemValue="id" itemLabel="name" delimiter="<br/>"/>
		--%>
		<br/><br/>
		<input type="submit" value="Add Cart"/>	</sf:form>
</body>
</html>
