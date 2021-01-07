<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${person.getFirstName()} ${person.getLastName()}"/></h1>
	<p>License Number: <c:out value="${person.getLicense().getNumber()}"/></p>
	<p>State: <c:out value="${person.getLicense().getState()}"/></p>
	<p>Number of pages: <c:out value="${person.getLicense().getExpirationDate()}"/></p>
</body>
</html>