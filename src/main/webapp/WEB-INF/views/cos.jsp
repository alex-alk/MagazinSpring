<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div id=main>
			<article>
				<c:forEach var ="id" items="${cookie}">
					<c:if test='${id.value.value=="id"}'>
						${id.value.name}
						<form action="/stergeDinCos" method="POST">
							<input type="hidden" name="id" value='${id.value.name}'>
							<button type="submit">Elimină din coș</button>
						</form><br>
					</c:if>	
				</c:forEach>
			</article>
		</div>
		<form action="/validareComanda" method="POST">
			<button type="submit">Validare comandă</button>
		</form>
	</body>
</html>