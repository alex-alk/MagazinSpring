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
        <meta name="description" content="Magazin online cu pești de acvariu, hrană, accesorii și acvarii.">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <header>
    	<ul>
    		<li><a href="/">Pagina de start</a></li>
    		<li><a href="inregistrare">Înregistrare</a></li>
    		<li><a href="index.jsp">Intră în cont</a></li>
    	</ul>
    	<ul id=headerRight>
    		<li><a href="index.jsp"><img id="cos" src="/resources/img/cos.png">Vizualizare comandă</a></li>
    		<li><img id="call" src="/resources/img/call.png">Comenzi telefonice: <p>0740.000.000</p></li>
    	</ul>
    	<img id="headerImg" src="/resources/img/header.png">
    	<h1>Magazin acvaristică</h1>
    </header>
    	<form:form action="cauta" method="GET" modelAttribute="mainQuery">
    		<div id="cauta">
	   			<button type="submit">Caută:</button>
	   			<form:input path="text"/>
	   		</div>
	   		<aside id="asideLeft">
	    		<p>Categorii:</p>
	    		<form:checkbox path="pesti" value="pesti" id="pesti" onclick="form.submit()"/><label for="pesti" >Pești</label><br>
	    		<form:checkbox path="hrana" value="hrana" id="hrana" onclick="form.submit()"/><label for="hrana" >Hrană</label><br>
	    		<form:checkbox path="accesorii" value="accesorii" id="acc" onclick="form.submit()"/><label for="acc">Accesorii</label><br>
	    		<form:checkbox path="acv" value="acv" id="acv" onclick="form.submit()"/><label for="acv">Acvarii</label><br>
	    		<p>Sortare:</p>
	    		<form:radiobutton path="order" value="nume" id="den" onclick="form.submit()"/><label for="den">Denumire</label><br>
	    		<form:radiobutton path="order" value="pret" id="pret" onclick="form.submit()"/><label for="pret">Preț</label><br>
    		</aside>
    	</form:form>
    <div id=main>
    	<c:forEach items="${articole}" var="articol">
	    	<table>
	    		<tr>
	    			<td><img src="${articol.imagineURL}"></td>
	    		</tr>
	    		<tr>
	    			<td>${articol.nume}</td>
	    		</tr>
	    		<tr>
	    			<td>Preț: ${articol.pret} lei<a href="descriere?id=${articol.id}">AAAA</a>a></td>
	    		</tr>
	    	</table>
    	</c:forEach>
    </div>
    </body>
</html>