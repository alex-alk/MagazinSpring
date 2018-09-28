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
        <link rel="shortcut icon" href="/resources/img/fav.ico">
        <script src="/resources/js/jquery-3.3.1.min.js"></script>
        <script src="/resources/js/popper.js"></script>
        <script src="/resources/js/bootstrap.min.js"></script>
        <script src="/resources/js/script"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <header>
    	<ul>
    		<li><a href="/">Pagina de start</a></li>
    		<li><a href="index.jsp">Înregistrare</a></li>
    		<li><a href="index.jsp">Intră în cont</a></li>
    	</ul>
    	<ul id=headerRight>
    		<li><a href="/cos"><img id="cos" src="/resources/img/cos.png">Vizualizare comandă</a></li>
    		<li><img id="call" src="/resources/img/call.png">Comenzi telefonice: <p>0740.000.000</p></li>
    	</ul>
    	<img id="headerImg" src="/resources/img/header.png">
    	<h1>Magazin acvaristică</h1>
    </header>
	<body>
		<form:form action="trimite" method="POST" modelAttribute="ordersForm">
			<div id=main>
				<article>
					<c:set var="space" value=" "/>
					<c:forEach var ="i" items="${idQ}">
						<c:set var="idArticole" value="${i.key}${space}${idArticole}"/>
					</c:forEach>
					<form:hidden path="articleId" value="1"/><p>IdArticol: ${idArticole}</p>
					<c:forEach var ="i" items="${idQ}">
						<c:set var="cantitati" value="${i.value}${space}${cantitati}"/>
					</c:forEach>
					<form:hidden path="quantity" value="2"/><p>Cantitate: ${cantitati}</p>
				</article>
				<form:hidden path="clientId" value="3"/><p>Client Id: ${clientId}</p>
				<button type="submit">Trimite comanda</button>
			</div>
		</form:form>
	</body>
</html>