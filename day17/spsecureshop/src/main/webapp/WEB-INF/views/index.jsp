<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h3><s:message code="app.title"/></h3>
	<form method="post" action="j_spring_security_check">
		<table>
			<tr>
				<td>
					<s:message code="email.label"/>:
				</td>
				<td>
					<input type="text" name="email"/>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<s:message code="password.label"/>:
				</td>
				<td>
					<input type="password" name="password"/>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="<s:message code="signin.label"/>"/>
				</td>
				<td>
					<a href="register"><s:message code="signup.label"/></a>
				</td>
			</tr>
		</table>
		<a href="index?lang=en">English</a>
		<a href="index?lang=hi">Hindi</a>
	</form>
</body>
</html>

