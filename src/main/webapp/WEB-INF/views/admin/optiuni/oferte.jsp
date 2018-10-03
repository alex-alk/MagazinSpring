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
		<a href="/">Pagina de start</a>
		<form:form modelAttribute="file" action="/admin/optiuni/oferte" method="POST" enctype="multipart/form-data">
			<form:input type="file" path="file"/><br>
			<button type="submit">Adaugă</button>
		</form:form>
		<p>${msg}</p>
		<c:forEach var="offer" items="${offers}">
			<article class="offersAdmin">
				<img src="${offer.url}"/>
				<p><a class="offerDelete" href = "/admin/optiuni/oferte/sterge?id=${offer.id}">Șterge</a></p>
			</article>
		</c:forEach>
	</body>
</html>