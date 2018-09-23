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
        <meta name="description" content="Magazin online cu pești de acvariu, hrană, accesorii și acvarii.">
        <meta name="keywords" content="magazin acvaristică, de vânzare, pești, acvariu, acvaristică, accesorii, hrană, pești de acvariu">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
		<a href="index.jsp">Pagina de start</a>
		<form action="articolUpload" method="POST" enctype="multipart/form-data">
			<table>
				<tr>
					<td>  
						<input type="file" name="file"><br>
						<p>Dim: 144px X 144px</p>
					</td>
				</tr>
				<tr>
					<td>
						<p>Denumire:</p>
						<input name="nume"/>
					</td>
				</tr>
				<tr>
					<td>
						<p>Preț:</p>
						<input name="pret"/>
					</td>
				</tr>
				<tr>
					<td>
						<p>Categorie:</p>
						<input name="categorie"/>
					</td>
				</tr>
			</table>
			<textarea name="descriere"></textarea>
			<button type="submit">Adaugă</button>
		</form>
		<p>${msg}</p>
	</body>
</html>