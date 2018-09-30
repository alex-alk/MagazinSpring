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
        <link rel="shortcut icon" href="fav.ico">
        <script src="/resources/js/jquery-3.3.1.min.js"></script>
        <script src="/resources/js/popper.js"></script>
        <script src="/resources/js/bootstrap.min.js"></script>
        <script src="/resources/js/script"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
		<a href="/">Pagina de start</a>
		<form:form action="/admin/optiuni/articolUpload" method="POST" enctype="multipart/form-data" modelAttribute="articolUpload">
			<table>
				<tr>
					<td>  
						<form:input type="file" path="file"/><br>
						<p>Dim: 160px X 160px</p>
					</td>
				</tr>
				<tr>
					<td>
						<p>Denumire:</p>
						<form:input path="name"/>
						<form:hidden path="id" value="0"/>
					</td>
				</tr>
				<tr>
					<td>
						<p>Preț:</p>
						<form:input path="priceStr"/>
					</td>
				</tr>
				<tr>
					<td>
						<p>Categorie:</p>
						<form:input path="category"/>
					</td>
				</tr>
			</table>
			Descriere:
			<form:input path="description"></form:input>
			<button type="submit">Adaugă</button>
		</form:form>
		<p>${msg}</p>
	</body>
</html>