<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editare pacient</title>
</head>
<body>
<h1>Editare pacient</h1>
<form:form action="${pageContext.request.contextPath}/editare-pacient-save.htm" method="post" modelAttribute="pacientForm">
Id: <form:input path="id" readonly = "true"/><br/>
Nume: <form:input path="nume"/><br/>
Adresa: <form:input path="adresa"/><br/>
Varsta: <form:input path="varsta"/><br/>
Diagnostic: <form:input path="diagnostic"/><br/>
<input type="submit" value="Salveaza"/><br/>
</form:form>
</br>
<a href="<c:url value="/listPacient.htm"/>">Inapoi la lista</a>
</body>
</html>