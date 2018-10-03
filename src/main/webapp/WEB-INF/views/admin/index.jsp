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
    <body>
    	<form:form action="/admin/optiuni" id="login" method="POST" modelAttribute="admin">
	    	<label>Nume de utilizator:</label><br>
	    	<form:input path="username"/><br>
	    	<label>Parola:</label><br>
    		<form:input path="password"/><br>
    		<p style="color:red">${msg}</p>
    		<button type="submit">Intră în cont</button>
    		<button type="submit">Schimbă parola</button>
    	</form:form>
    	<p></p>
    </body>
</html>