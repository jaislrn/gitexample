<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<sf:form modelAttribute="lg" action="auth">
		<table>
			<tr>
				<td>
					Email:
				</td>
				<td>
					<sf:input path="email"/>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					Password:
				</td>
				<td>
					<sf:password path="password"/>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Sign In"/>
				</td>
			</tr>
		</table>
	</sf:form>
</body>
</html>

