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
        <script src="/resources/js/script.js"></script>
        <c:if test="${description==null}">
        	<meta name="description" content="Magazin online cu pești de acvariu, hrană, accesorii și acvarii.">
        </c:if>
        <meta name="description" content="${description}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <header>
    	<ul>
    		<li><a href="/">Pagina de start</a></li>
    		<li><a href="/inregistrare">Înregistrare</a></li>
    		<c:choose>
    			<c:when test="${cookie.name.value!=null}">
    				<li><a href="/intra">Utilizator: ${cookie.name.value}</a>
    			</c:when>
    			<c:otherwise>
    				<li><a href="/intra">Intră în cont</a></li>
    			</c:otherwise>
    		</c:choose>
    	</ul>
    	<ul id=headerRight>
    		<li><a href="/cos"><img id="cos" src="/resources/img/cos.png">Coș de cumpărături</a></li>
    		<li><img id="call" src="/resources/img/call.png">Comenzi telefonice: <p>0740.000.000</p></li>
    	</ul>
    	<img id="headerImg" src="/resources/img/header.png">
    	<h1>Magazin acvaristică</h1>
    </header>