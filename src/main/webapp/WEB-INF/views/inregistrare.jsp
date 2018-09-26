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
        <link rel="shortcut icon" href="fav.ico">
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
    		<li><a href="/index.jsp">Intră în cont</a></li>
    	</ul>
    	<ul id=headerRight>
    		<li><a href="index.jsp"><img id="cos" src="/resources/img/cos.png">Vizualizare comandă</a></li>
    		<li><img id="call" src="/resources/img/call.png">Comenzi telefonice: <p>0740.000.000</p></li>
    	</ul>
    	<img id="headerImg" src="/resources/img/header.png">
    	<h1>Magazin acvaristică</h1>
    </header>
    <body>
    	<form:form action="inregistrare" id="login" method="POST" modelAttribute="client">
	    	<label>Nume:</label><br>
	    	<form:input path="nume"/><br>
	    	<label>Prenume:</label><br>
    		<form:input path="prenume"/><br>
    		<label>Telefon:</label><br>
    		<form:input path="telefon"/><br>
    		<label>Adresa email</label>
    		<form:input path="email"/><br>
    		<label>Parola:</label><br>
    		<form:input path="parola" id="conf1"/><br>
    		<label>Confirmă parola:</label><br>
    		<input  type="text" id="conf2"><br>
    		<button type="submit">Înregistrare</button><br>
    		<button >Schimbă parola</button>
    	</form:form>
    	<p></p>
    </body>
</html>