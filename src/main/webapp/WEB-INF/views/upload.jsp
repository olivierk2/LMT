<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Upload</title>
</head>

</head>
${id}
<body>
	<form:form action="${pageContext.request.contextPath}/upload/import" method="post" enctype="multipart/form-data">
		<input type="file" name="photo" value="id"/>
			<input type="submit" value="Login">
		<input type="text" value="${id}" name="id"/>
		<form:errors path="*"></form:errors>
	</form:form>

</body>
</html>