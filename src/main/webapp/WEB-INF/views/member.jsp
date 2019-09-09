<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Sign up</title>
  </head>
 
 <body>
 	
  <form:form method="post" action="${pageContext.request.contextPath}/member/newMember" modelAttribute="newMember">
  
		<form:errors path="email" />Your email
		<form:input path="email"/>
		<br>
		<form:errors path="password" />Your password
		<form:input path="password"/>		
		<br>
		<form:errors path="birthday" />Your birthday
		<form:input path="birthday" />
		<br>
		<form:errors path="adress" />Your adress
		<form:input path="adress"/>	
		<br>					
		<form:errors path="zipCode" />Your zipCode
		<form:input path="zipCode"/>
		<br>
		<form:errors path="city" />Your city
		<form:input path="city"/>
		<br>
		<form:errors path="firstname" />Your firstname
		<form:input path="firstname"/>
		<br>
		<form:errors path="lastname" />Your lastname
		<form:input path="lastname"/>
		<br>Your level
		<form:select path="levelMember">
		<form:option value="beginnner" label="beginner"></form:option>	
		<form:option value="intermediate" label="intermediate"></form:option>	
		<form:option value="advanced" label="advanced"></form:option>	
		<form:option value="professional" label="pro"></form:option>	
		</form:select>
		<br>Your sex
		<form:select path="sexMember">
		<form:option value="M" label="man"></form:option>	
		<form:option value="F" label="woman"></form:option>	
		<form:option value="OTHER" label="other"></form:option>		
		</form:select>
		<br>
		<form:errors path="resume" />Your presentation
		<form:input path="resume"/>
		
		<input type="submit" value="Next">
	</form:form>
	
	
	
	
</body>
</html>