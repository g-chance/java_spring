<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<h1>New Cat</h1>
	<form:form action="/cats/new" method="post" modelAttribute="cat">
	    <p>
	    	<form:errors path="name"/>
	        <form:label path="name">Name</form:label>
	        <form:input path="name"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>

</html>