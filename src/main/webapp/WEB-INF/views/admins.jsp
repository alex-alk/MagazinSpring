<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table> 
  <tr> 
    <th>Id</th> 
    <th>Name</th> 
    <th>Credits</th> 
    <th></th> 
  </tr> 
  <c:forEach items="${admins}" var="admin"> 
    <tr> 
      <td>${admin.id}</td> 
      <td>${admin.password}</td> 
      <td>${admin.username}</td> 
    </tr> 
  </c:forEach> 
</table>
</body>
</html>