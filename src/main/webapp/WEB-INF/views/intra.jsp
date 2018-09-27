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
    <header>
    	<ul>
    		<li><a href="/">Pagina de start</a></li>
    		<li><a href="/inregistrare">Înregistrare</a></li>
    		<li><a href="/intra">Intră în cont</a></li>
    	</ul>
    	<ul id=headerRight>
    		<li><a href="index.jsp"><img id="cos" src="/resources/img/cos.png">Vizualizare comandă</a></li>
    		<li><img id="call" src="/resources/img/call.png">Comenzi telefonice: <p>0740.000.000</p></li>
    	</ul>
    	<img id="headerImg" src="/resources/img/header.png">
    	<h1>Magazin acvaristică</h1>
    </header>
    <body><%--incearca si fara hidden --%>
    	<form:form action="/intra" id="login" method="POST" modelAttribute="client">
	    	<form:hidden path="nume" value=""/><br>
    		<form:hidden path="prenume" value=""/><br>
    		<form:hidden path="telefon" value=""/><br>
    		<label>Adresa email</label>
    		<form:input path="email"/><br>
    		<label>Parola:</label><br>
    		<form:input path="parola"/><br>
    		<p>${msg}</p>
    		<button type="submit">Întră în cont</button><br>
    		<button type="submit">Recuperare parolă</button>
    	</form:form>
    	<p></p>
    </body>
</html>