<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>
	<h2>Client Search</h2>
	Id: <c:out value="${client.clientId}"/><br />
	Name: <c:out value="${client.name}"/>
</body>
</html>