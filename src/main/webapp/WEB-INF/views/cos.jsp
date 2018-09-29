<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"/>
	<form action="/validareComanda" method="POST">
		<c:set var="i" value="0"/>
		<c:forEach var ="id" items="${cookie}">			
			<c:if test='${id.value.value=="id"}'>
				<div class="articlesInCart">
					<article>
						<img src ="${articles[i].imageURL}">
						<span class="priceDescription">Preț: ${articles[i].price} lei</span>
						<p class="articleInCartName">${articles[i].name}</p>	
						<span class="quantity">Cantitatea: </span>
						<input type="number" name="${id.value.name}" value=""> 
						<a href="/stergeDinCos?id=${id.value.name}" class="remove">Eliminare produs</a>
					</article>
				</div>
				<c:set var="i" value="${i+1}"/> 
			</c:if>			
		</c:forEach>
		<br><span style="color:red">${msg}</span>	
		<button type="submit">Validare comandă</button>
	</form>
<c:import url="footer.jsp"/>