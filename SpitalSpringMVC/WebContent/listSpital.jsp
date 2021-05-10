<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabel </title>
</head>
<body>
<table border=1>
<tr>
     <td>ID</td>
     <td>Nume</td>
     <td>Adresa</td>
     <td>Telefon</td>
     <td>Email</td>
     <td></td>
     <td></td>
     <td></td>
     
     
</tr>
<c:forEach var ="sp" items="${spital}">
<tr>
      <td><c:out value="${sp.id}"/></td>
      <td><c:out value="${sp.nume}"/></td>
      <td><c:out value="${sp.adresa}"/></td>
      <td><c:out value="${sp.email}"/></td>
      <td><c:out value="${sp.email}"/></td>
      <td><a href="<c:url value ="/detaliiSpital.htm?id=${pa.id}"/>">Detalii</a></td>
      <td><a href="<c:url value ="/editare-spital.htm?id=${pa.id}"/>">Editare</a></td>
      <td><a href="<c:url value ="/deleteSpital.htm?id=${pa.id}"/>">Sterge</a></td>
      
</tr>
</c:forEach>
</table>
<a href="<c:url value ="/adaugare-spital.htm"/>">Adaugare spital</a>

</body>
</html>