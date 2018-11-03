<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="header.jsp"/>
	<section id="login">
	   	<form:form action="/intra" method="POST" modelAttribute="client">
	   		<form:hidden path="tel" value=""/><br>
	   		<label>Adresa email</label>
	   		<form:input path="email"/><br>
	   		<label>Parola:</label><br>
	   		<form:input path="password"/><br>
	   		<p style="color: green; font-weight: bold">${msg}</p>
	   		<button type="submit">Întră în cont</button><br>
	   	</form:form>
	   	<form action="/recuperare" method="GET">
	   		<button type="submit">Recuperare parolă</button>
	   	</form>
   	</section>
   	<p></p>
<c:import url="footer.jsp"/>