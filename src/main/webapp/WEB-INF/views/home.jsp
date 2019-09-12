<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Love Me Tinder
</h1>
<h2>
	Le site des amoureux de la musique
</h2>
<P>  The time on the server is ${serverTime}. </P>

<div>
	<a href="${pageContext.request.contextPath}/signIn/display">Sign in (s'authentifier)</a>
	<div>
	<a href="${pageContext.request.contextPath}/member/display">Sign up</a>
	<br><a href="${pageContext.request.contextPath}/localize/display">click here to find love</a>
	</div>
</div>
</body>
</html>
