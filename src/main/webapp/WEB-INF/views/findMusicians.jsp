<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme() + "://"
         + request.getServerName() + ":"
         + request.getServerPort()
         + request.getContextPath() + "/"
         %>" />
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/webapp/css/style.css" />
<title>Rock it</title>
</head>
<body>
<%String userName = (String) session.getAttribute("nomSession"); 

%>
<%--     <form action="savefile" method="post" enctype="multipart/form-data"> --%>
<!--     Select File: <input type="file" name="file"/> -->
<!--     <input type="submit" value="Upload File"/> -->
<%--     </form> --%>
    <h1><%= userName %></h1>
	<c:forEach var="user" items="${listMembres}">
		<div class="card" style="width: 18rem;">
			
			<div class="card-body">	
			<img src="${user.picture}" class="card-img-top" alt="..." >		
				<h3 class="card-title">${user.firstname} </h3>
				<h4 class="card-title">${user.city}</h4>
				
				<h5>${user.age}ans</h5>
				<p class="card-text">${user.resume}</p>
				<a href="#" class="btn btn-primary">Discuter</a>
			</div>
			
		</div>
			
	</c:forEach>
<img src="C:\JAVA\workspace-lmt\projetLMT\src\main\webapp\ressources\images\madonna.jpeg" class="card-img-top" alt="...">		

</body>
</html>