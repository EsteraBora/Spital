<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii</title>
</head>
<body>
<h1>Detalii pacient</h1>
Id:<c:out value="${pacient.id}"/><br/>
Nume:<c:out value="${pacient.nume}"/><br/>
Adresa:<c:out value="${pacient.adresa}"/><br/>
Varsta:<c:out value="${pacient.varsta}"/><br/>
Diagnostic:<c:out value="${pacient.diagnostic}"/><br/>
<br></br>
<a href="<c:url value ="/listPacient.htm?id=${pa.id}"/>">Inapoi la lista</a>


</body>
</html>