<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	Id: ${book.id} <br/>
	Name: ${book.name} <br/>
	Author: ${book.author} <br/>
	Subject: ${book.subject} <br/>
	Price: ${book.price} <br/><br/>
	<a href="books?subject=${book.subject}">Back</a>
</body>
</html>
