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
<h1>Detalii medic</h1>
Id:<c:out value="${medic.id}"/><br/>
Nume:<c:out value="${medic.nume}"/><br/>
Specialitate:<c:out value="${medic.specialitate}"/><br/>
Vechime:<c:out value="${medic.vechime}"/><br/>
Salar:<c:out value="${medic.salar}"/><br/>
<br></br>
<a href="<c:url value ="/listMedic.htm?id=${md.id}"/>">Inapoi la lista</a>


</body>
</html>