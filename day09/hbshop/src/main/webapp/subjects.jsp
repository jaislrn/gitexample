<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subjects</title>
</head>
<body>
	Hello, ${ub.user.name} <hr/>
	<jsp:useBean id="sb" class="sh.beans.SubjectsBean"/>
	${sb.fetchSubjects()}
	<form method="post" action="books.jsp">
		<c:forEach var="subjectName" items="${sb.subjects}">
			<input type="radio" name="subject" value="${subjectName}"/> ${subjectName} <br/>
		</c:forEach>
		<input type="submit" value="Show Books"/>
		<input type="submit" value="Show Cart" formaction="showcart.jsp"/>
	</form>
</body>
</html>
