<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="ro">
    <head>
        <meta charset="utf-8">
        <title>Magazin acvaristică</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
        <link rel="stylesheet" href="/resources/css/codemirror.min.css">
        <link rel="stylesheet" href="/resources/css/froala_editor.pkgd.min.css">
        <link rel="stylesheet" href="/resources/css/froala_style.min.css">
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="/resources/css/style.css">
        <link rel="shortcut icon" href="/resources/img/fav.ico">
        <script src="/resources/js/popper.min.js"></script>
        <script src="/resources/js/jquery-3.3.1.min.js"></script>
        <script src="/resources/js/bootstrap.min.js"></script>
        <script src="/resources/js/codemirror.min.js"></script>
        <script src="/resources/js/xml.min.js"></script>
        <script src="/resources/js/froala_editor.pkgd.min.js"></script>
        <script src="/resources/js/script.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
		<a href="/">Pagina de start</a>
		<form:form action="/admin/optiuni/articolUpload" method="POST" enctype="multipart/form-data" modelAttribute="articolUpload">
			<table id="tableAdd">
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
						<form:input type="number" path="priceStr"/> lei
					</td>
				</tr>
				<tr>
					<td>
						<p>Categorie:</p>
						<form:select path="category">
							<form:option value="pesti">Pești</form:option>
							<form:option value="hrana">Hrană</form:option>
							<form:option value="accesorii">Accesorii</form:option>
							<form:option value="acv">Acvarii</form:option>
						</form:select>
					</td>
				</tr>
			</table>
			<p style="color:green;font-weight:bold;margin-left:10px">${msg}</p>
			<span id="d">Descriere:</span>
			<form:textarea path="description" id="jedit"></form:textarea>
			<button type="submit" style="margin-left: 10px">Adaugă</button>
		</form:form>
		<footer>
			<p id="time"></p>
		</footer>
	</body>
</html>