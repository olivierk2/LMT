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
		
		<form:errors path="password" />Your password
		<form:input path="password"/>		
	
		<form:errors path="birthday" />Your birthday
		<form:input path="birthday" />
		
		<form:errors path="city" />Your city
		<form:input path="city"/>
		
		<form:errors path="adress" />Your adress
		<form:input path="adress"/>	
		
		<form:errors path="firstname" />Your firstname
		<form:input path="firstname"/>
		
		<form:errors path="lastname" />Your lastname
		<form:input path="lastname"/>
		
		<form:errors path="levelMember" />Your level
		<form:input path="levelMember"/>
		<FORM NAME="form1" METHOD="post" ACTION="">

			<SELECT NAME="sexMember">
			
			<OPTION VALUE="m" >
			homme</OPTION>
			
			<OPTION VALUE="f"  >
			femme</OPTION>
			
			<OPTION VALUE="other"  >
			
			other</OPTION>
			
			</SELECT>
			
			</FORM>
		
		<form:errors path="picture" />Your picture
		<form:input path="picture"/>
		
		<form:errors path="resume" />Your presentation
		<form:input path="resume"/>
		
					
		<form:errors path="zipCode" />Your zipCode
		<form:input path="zipCode"/>		
						
		<form:errors path="instruments" />Your instrument(s)
		<form:input path="instruments" type="select"/>
		Choisir un style ->
		jazz : <form:checkbox path="genres" value="jazz"/>
		rock : <form:checkbox path="genres" value="rock"/>
		pop : <form:checkbox path="genres" value="pop"/>
		soul : <form:checkbox path="genres" value="soul"/>
		
		<input type="submit" value="Login">
	</form:form>
</body>
</html>