<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in</title>
</head>
<body>
		<form:form method="post" action="${pageContext.request.contextPath}/authentication/" modelAttribute="userBean">
		<form:errors path="email" />
		<form:input path="email"/>
		
		<form:errors path="password" />
		<form:input path="password"/>
		<input type="submit" value="Login">
	</form:form>
</body>
</html>