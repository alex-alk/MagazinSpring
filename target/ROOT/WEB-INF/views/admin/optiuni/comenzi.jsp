<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="ro">
    <head>
        <meta charset="utf-8">
        <title>Magazin acvaristică</title>
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="/resources/css/style.css">
        <link rel="shortcut icon" href="/resources/fav.ico">
        <script src="/resources/js/popper.min.js"></script>
        <script src="/resources/js/jquery-3.3.1.min.js"></script>
        <script src="/resources/js/bootstrap.min.js"></script>
        <script src="/resources/js/script.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    	<table id="validationTable">
    		<tr>
    			<th>Email</th>
    			<th>Nume</th>
    			<th>Telefon</th>
    			<th>Produs</th>
    			<th>Cantitate</th>
    		</tr>
			<c:forEach var="order" items="${ordersTableList}">
				<tr>
					<td><c:out value="${order.email}"/></td>
					<td><c:out value="${order.name}"/></td>
					<td><c:out value="${order.tel}"/></td>
					<td>${order.artName}</td>
					<td>${order.quantity}</td>
					<td><a href="/admin/optiuni/comenzi/sterge?id=${order.orderId}">Șterge</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>