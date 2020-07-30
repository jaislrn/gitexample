<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/site.css">
</head>
<body>
	<sf:form modelAttribute="command" method="post" action="register">
		<table>
			<tr>
				<td>
					Name:
				</td>
				<td>
					<sf:input path="name"/>
				</td>
				<td>
					<sf:errors cssClass="error" path="name"/>
				</td>
			</tr>
			<tr>
				<td>
					Mobile:
				</td>
				<td>
					<sf:input path="mobile"/>
				</td>
				<td>
					<sf:errors cssClass="error" path="mobile"/>
				</td>
			</tr>
			<tr>
				<td>
					Email:
				</td>
				<td>
					<sf:input path="email"/>
				</td>
				<td>
					<sf:errors cssClass="error" path="email"/>
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
					<sf:errors cssClass="error" path="password"/>
				</td>
			</tr>
			<tr>
				<td>
					Birth Date (dd-mm-yyyy):
				</td>
				<td>
					<sf:input path="birth"/>
				</td>
				<td>
					<sf:errors cssClass="error" path="birth"/>
				</td>
			</tr>
			<tr>
				<td>
					Address:
				</td>
				<td>
					<sf:input path="address"/>
				</td>
				<td>
					<sf:errors cssClass="error" path="address"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Submit"/>
				</td>
				<td>
					<a href="index">Sign In</a>
				</td>
			</tr>
		</table>
		${message}
	</sf:form>
</body>
</html>

