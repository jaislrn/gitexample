<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
	Hello, ${ub.user.name} <hr/>
	<jsp:useBean id="bb" class="sh.beans.SubjectBooksBean"/>
	<jsp:setProperty name="bb" property="*" />
	${bb.fetchBooks()}
	<form method="post" action="addcart.jsp">
		<c:forEach var="b" items="${bb.books}">
			<input type="checkbox" name="book" value="${b.id}"/> ${b.name} (${b.author}) <br/>
		</c:forEach>
		<input type="submit" value="Add Cart"/>
	</form>
</body>
</html>
