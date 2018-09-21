<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <meta name="keywords" content="magazin acvaristică, de vânzare, pești, acvariu, acvaristică, accesorii, hrană, pești de acvariu">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <header>
    	<ul>
    		<li><a href="index.jsp">Pagina de start</a></li>
    		<li><a href="index.jsp">Înregistrare</a></li>
    		<li><a href="index.jsp">Intră în cont</a></li>
    	</ul>
    	<ul id=headerRight>
    		<li><a href="index.jsp"><img id="cos" src="/resources/img/cos.png">Vizualizare comandă</a></li>
    		<li><img id="call" src="/resources/img/call.png">Comenzi telefonice: <p>0740.000.000</p></li>
    	</ul>
    	<img id="headerImg" src="/resources/img/header.png">
    	<h1>Magazin acvaristică</h1>
    </header>
    <aside id="asideRight">
    	<form action="" method="GET">
    		<p>Categorii:</p>
    		<input type="checkbox" id="pesti"><label for="pesti">Pești</label><br>
    		<input type="checkbox" id="hrana"><label for="hrana">Hrană</label><br>
    		<input type="checkbox" id="acc"><label for="acc">Accesorii</label><br>
    		<input type="checkbox" id="acv"><label for="acv">Acvarii</label><br>
    		<p>Sortare:</p>
    		<input type="checkbox" id="den"><label for="den">Denumire</label><br>
    		<input type="checkbox" id="pret"><label for="pret">Preț</label><br>
    	</form>
    </aside>
   	<form action="" method="GET">
   		<button type="submit">Caută:</button>
   		<input type="text">
   	</form>
    <div id=main>
    sadasd
    </div>
    </body>
</html>