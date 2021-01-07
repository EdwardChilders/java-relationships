<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1>New License</h1>
	<form:form method="post" action="/licenses/new" modelAttribute="license">
		<p>
			<form:label path="person">Person:</form:label>
			<form:select path="person">
				<c:forEach items="${persons }" var="person">
					<c:if test = "${person.getLicense() == null }">
						<form:option value="${person }" label = "${person.getFirstName() } ${person.getLastName() }"/>
					</c:if>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="state">State:</form:label>
			<form:errors path="state"/>
			<form:input path="state"/>
		</p>
		<p>
			<form:label path="expirationDate">Expiration Date:</form:label>
			<form:errors path="expirationDate"/>
			<form:input type="date" path="expirationDate"/>
		</p>
		<input type="submit" value="Submit"/>
		
	</form:form>
</body>
</html>