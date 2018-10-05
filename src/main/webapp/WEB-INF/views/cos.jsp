<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="header.jsp"/>
	<form action="/validareComanda" method="POST">
		<c:set var="i" value="0"/>
		<c:forEach var="article" items="${products}">
			<div class="articlesInCart">
				<article>
					<img src ="${article.imageURL}">
					<span class="priceDescription">Preț: ${article.price} lei</span>
					<p class="articleInCartName">${article.name}</p>	
					<span class="quantity">Cantitatea: </span>
						<input type="number" name="${article.id}" value="${tableSend['quantities'][i]}">
					<a href="/stergeDinCos?idA=${article.id}" class="remove">Eliminare produs</a>
				</article>
			</div>
			<c:set var="i" value="${i+1}"/>
		</c:forEach>
		<br><span style="color:red">${msg}</span>
		<c:choose>
			<c:when test="${fn:length(products)==0}">
				<h4 style="text-align: center">Coșul de cumpărături este gol.</h4>
			</c:when>
			<c:otherwise>
				<button type="submit">Validare comandă</button>	
			</c:otherwise>
		</c:choose>	
	</form>
<c:import url="footer.jsp"/>