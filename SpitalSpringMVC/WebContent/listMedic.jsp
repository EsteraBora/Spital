<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabelul Medicilor</title>
</head>
<body>
<table border=1>
<tr>
     <td>ID</td>
     <td>Nume</td>
     <td>Specialitate</td>
     <td>Vechime</td>
     <td>Salar</td>
     <td></td>
     <td></td>
     <td></td>
     
     
</tr>
<c:forEach var ="md" items="${medic}">
<tr>
      <td><c:out value="${md.id}"/></td>
      <td><c:out value="${md.nume}"/></td>
      <td><c:out value="${md.specialitate}"/></td>
      <td><c:out value="${md.vechime}"/></td>
      <td><c:out value="${md.salar}"/></td>
      <td><a href="<c:url value ="/detaliiMedic.htm?id=${md.id}"/>">Detalii</a></td>
      <td><a href="<c:url value ="/editare-medic.htm?id=${md.id}"/>">Editare</a></td>
      <td><a href="<c:url value ="/deleteMedic.htm?id=${md.id}"/>">Sterge</a></td>
      
</tr>
</c:forEach>
</table>
<a href="<c:url value ="/adaugare-medic.htm"/>">Adaugare medic</a>

</body>
</html>