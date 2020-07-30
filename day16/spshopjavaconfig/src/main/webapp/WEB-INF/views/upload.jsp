<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Upload</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="upload">
		<input type="hidden" name="id" value="${param.id}"/>
		Book Image: <input type="file" accept="image/*" name="imgfile"/> <br/><br/>
		<input type="submit" value="Upload Image"/>
		<br/><br/>
		${message}
	</form>
</body>
</html>

