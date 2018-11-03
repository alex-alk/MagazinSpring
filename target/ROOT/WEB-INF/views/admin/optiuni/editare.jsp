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
    	<ul>
    		<li class="startStyle"><a href="/">Pagina de start</a></li>
    	</ul>	
    	<form:form action="/admin/optiuni/editare/cauta" method="GET" modelAttribute="mainQuery">
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
	    		<form:radiobutton path="order" value="nume" id="nume" onclick="form.submit()"/><label for="nume">Denumire</label><br>
	    		<form:radiobutton path="order" value="pret" id="pret" onclick="form.submit()"/><label for="pret">Preț</label><br>
    		</aside>
    	</form:form>
    	<div id=main>
	    	<c:forEach items="${articles}" var="article">
		  		<a href="/admin/optiuni/editeaza?id=${article.id}" class="article">
	    			<span class="img"><img src="${article.imageURL}"></span>
	    			<span class="name">${article.name}</span>
	    			<span class="price">Preț: ${article.price} lei</span>
	    		</a>
	    	</c:forEach>
    	</div>		
    </body>
</html>