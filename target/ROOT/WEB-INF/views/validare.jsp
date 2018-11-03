<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="header.jsp"/>
	<form:form action="/trimite" method="POST" modelAttribute="ordersForm">
		<div class="description">
			<article>
				<table id="validationTable">
					<tr>
						<th>Denumire</th>
						<th>Preț</th>
						<th>Cantitate</th>
						<th>Cost</th>
					</tr>	
					<c:set var="r" value="0"/>
					<c:forEach var="names" items="${tableSend['names']}">
						<tr>
							<c:forEach var="table" items="${tableSend}">							
									<td>${table.value[r]}</td>						
							</c:forEach>
						</tr>
						<c:set var="r" value="${r+1}"/>
					</c:forEach>
				</table>
					<form:hidden path="articleId" value="${ordersForm.articleId}"/>
					<form:hidden path="quantity" value="${ordersForm.quantity}"/>
					<form:hidden path="clientId" value="${ordersForm.clientId}"/>		
			</article>
			<button type="submit">Trimite comanda</button>
		</div>
	</form:form>
<c:import url="footer.jsp"/>