<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Confirmation de Suppression de Fornisseur</title>
</head>
<body>
	<header>
		<jsp:include page="${request.contextPath()}/include/header.jsp"></jsp:include>
	</header>
	<div id="main">
		<div id="sideBar">
			<jsp:include page="${request.contextPath()}/include/infouser.jsp"></jsp:include>
		</div>
		<fieldset id="fieldset">
			<legend class="lege-Login">Confirmation de Suppression de Fornisseur</legend>
			<p id="confirmation_formp">
				Voulez-vous Vraiment supprimer le Fornisseur <br> <b id="importont">${param.nomFornisseur}</b>
			</p>
			<div id="confirmation">
				<form
					action="${pageContext.servletContext.contextPath}/detataildufornisseur?id=${param.id}"
					method="post">
					<input class="button" type="submit" value="Nom"> 
					<img src="${pageContext.servletContext.contextPath}/include/imgs/back.png" title="No-drop" alt="No-drop" class="icon No-drop">
				</form>
				<form action="${pageContext.servletContext.contextPath}/supprimerfornisseur"
					method="post">
					<input type="hidden" value="${param.nomfornisseur}" name="nomProduit">
				<img src="${pageContext.servletContext.contextPath}/include/imgs/b_drop.png"
					title="drop" alt="drop" class="icon b_drop"> <input
					type="hidden" value="${param.id}" name="id">
					<input class="button" type="submit" value="Oui">
				</form>

			</div>
		</fieldset>
	</div>
</body>
</html>