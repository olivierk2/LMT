<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<p>Choisir un style :</p>
	<form:form method="post" action="${pageContext.request.contextPath}/member/newMemberGenres" modelAttribute="listVierge">
                  
                
      		 
               <br><form:checkboxes path="listVierge" items="${listGenres}"/>
                  
           
            

   <input type="submit" value="next">	
   </form:form>
</body>
</html>