<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="header.jsp"/>
   	<form:form action="/recuperare" id="login" method="POST" modelAttribute="client">
   	<%-- 
    	<form:hidden path="familyName" value=""/><br>
   		<form:hidden path="firstName" value=""/><br>--%>
   		<form:hidden path="tel" value=""/><br>
   		<label>Adresa email</label>
   		<form:input path="email"/><br>
   		<label>Parola:</label><br>
   		<form:input path="password"/><br>
   		<p style="color:red">${msg}</p>
   		<button type="submit">Întră în cont</button><br>
   		<button type="submit">Recuperare parolă</button>
   	</form:form>
   	<p></p>
<c:import url="footer.jsp"/>