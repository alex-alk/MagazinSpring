<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="header.jsp"/>
    <body>
    	<form:form action="/inregistrare" id="login" method="POST" modelAttribute="client">
	    	<label>Nume:</label><br>
	    	<form:input path="familyName"/><br>
	    	<label>Prenume:</label><br>
    		<form:input path="firstName"/><br>
    		<label>Telefon:</label><br>
    		<form:input path="tel"/><br>
    		<label>Adresa email</label>
    		<form:input path="email"/><br>
    		<label>Parola:</label><br>
    		<form:input path="password" id="conf1"/><br>
    		<label>Confirmă parola:</label><br>
    		<input  type="text" id="conf2" name="confirmation"><br>
    		<p style="color: green; font-weight: bold">${msg}</p>
    		<button type="submit">Înregistrare</button><br>
    	</form:form>
    	<p></p>
<c:import url="footer.jsp"/>