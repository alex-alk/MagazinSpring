<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp"/>
	<div class="description">
		<article>
			<div class="priceDescription">Preț: ${article.price} lei</div>
			<h3>${article.name}</h3>
			<img src="${article.imageURL}">
			<p>${article.description}</p>
		</article>
	</div>
	<form action="/cos" method="POST">
		<input type="hidden" name="idA" value="${article.id}">
		<p style="color:red">${msg}</p>
		<button type="submit">Adaugă în coș</button>
	</form>
<c:import url="footer.jsp"/>