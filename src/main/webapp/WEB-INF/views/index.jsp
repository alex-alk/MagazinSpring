<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="header.jsp"/>
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
    	<c:forEach items="${articles}" var="article">
	  		<a href="descriere?id=${article.id}" class="article">
    			<span class="img"><img src="${article.imageURL}"></span>
    			<span class="name">${article.name}</span>
    			<span class="price">Preț: ${article.price} lei</span>
    		</a>
    	</c:forEach>
    </div>
<c:import url="footer.jsp"/>