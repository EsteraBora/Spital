<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabelul Pacientilor</title>
</head>
<body>
<table border=1>
<tr>
     <td>ID</td>
     <td>Nume</td>
     <td>Adresa</td>
     <td>Varsta</td>
     <td>Diagnostic</td>
     <td></td>
     <td></td>
     <td></td>
     
     
</tr>
<c:forEach var ="pa" items="${pacient}">
<tr>
      <td><c:out value="${pa.id}"/></td>
      <td><c:out value="${pa.nume}"/></td>
      <td><c:out value="${pa.adresa}"/></td>
      <td><c:out value="${pa.varsta}"/></td>
      <td><c:out value="${pa.diagnostic}"/></td>
      <td><a href="<c:url value ="/detaliiPacient.htm?id=${pa.id}"/>">Detalii</a></td>
      <td><a href="<c:url value ="/editare-pacient.htm?id=${pa.id}"/>">Editare</a></td>
      <td><a href="<c:url value ="/deletePacient.htm?id=${pa.id}"/>">Sterge</a></td>
      
</tr>
</c:forEach>
</table>
<a href="<c:url value ="/adaugare-pacient.htm"/>">Adaugare pacient</a>

</body>
</html>