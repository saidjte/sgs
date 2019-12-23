<%@page import="ma.safi.entities.Fornisseur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="<%= request.getContextPath() %>/include/css/style.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Ajouter un Fornisseur</title>
</head>
<body>
	<header>
		<jsp:include page="${request.getContextPath()}/include/header.jsp"></jsp:include>
	</header>
	<div id="main">
		<div id="sideBar">
			<jsp:include page="${request.getContextPath()}/include/infouser.jsp"></jsp:include>
			<fieldset id="options">
			<legend>Liste Des Options</legend>
				<img src="${pageContext.servletContext.contextPath}/include/imgs/back.png" title="back" alt="back" class="icon ic_b_edit"> 
				<input class="button" type="button" title="Retourner au gestion du Fornisseur"
				value="Retourner au gestion du Fornisseur" onClick="document.location = '${pageContext.servletContext.contextPath}/gestionfornisseurs'">
			</fieldset>
			
		</div>
		<fieldset id="fieldset">
			<legend class="lege-Login">Ajouter un Fornisseur</legend>
			<form action="${pageContext.servletContext.contextPath}/ajouterfornisseur"
				method="post" class="f1">
				<input type="hidden" value="${detailfornisseur.idfournisseur}"name="id"> 
				<label>Nom</label><input type="text" name="nomfornisseur" ><br>
				<label>PreNom</label><input type="text" name="prenomfornisseur" ><br>
				<label>Adresse</label><input type="text" name="adresse" ><br> 
				<label>Ville</label>				
				<select name="ville">
				<c:forEach var="malistville" items="${vList}">
					<option value="${malistville.idVille }" >${malistville.nomVille }</option>
				</c:forEach>
				</select>	
				<br>
				<input type="submit" name="envoyer" value="Ajouter" class="envoyer">
			</form>
			<form
				action="${pageContext.servletContext.contextPath}/gestionfornisseurs"
				method="post">
				<input class="button" type="submit" value="Annuler">
			</form>
		</fieldset>
	</div>
	<footer>
		<jsp:include page="${request.getContextPath()}/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>