<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subjects</title>
</head>
<body>
	Hello, ${cust.name} <hr/>
	<sf:form action="books">
		<sf:radiobuttons path="subject" items="${subjectList}" delimiter="<br/>"/>
		<br/><br/>
		<input type="submit" value="Show Books"/>
		<a href="showcart">Show Cart</a>
	</sf:form>
</body>
</html>
