<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="header.jsp"/>
	<form:form action="trimite" method="POST" modelAttribute="ordersForm">
		<div id=main>
			<article>
				
					<form:hidden path="articleId" value="${ordersForm.articleId}"/><p>IdArticol: ${ordersForm.articleId}</p>
					<form:hidden path="quantity" value="${ordersForm.quantity}"/><p>Cantitate: ${ordersForm.quantity}</p>
					<form:hidden path="clientId" value="${ordersForm.clientId}"/><p>Client Id: ${ordersForm.clientId}</p>
				
			</article>
			<button type="submit">Trimite comanda</button>
		</div>
	</form:form>
<c:import url="footer.jsp"/>