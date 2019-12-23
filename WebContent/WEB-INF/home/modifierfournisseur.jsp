<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Modifier le Produit</title>
</head>
<body>

	<jsp:include page="${request.getContextPath()}/include/header.jsp"></jsp:include>
	<div id="main">
		<div id="sideBar">
			<jsp:include page="${request.getContextPath()}/include/infouser.jsp"></jsp:include>
		
		</div>

		<fieldset id="fieldset">
			<legend class="lege-Modifier">Modifier le Fournisseur ${detailfornisseur.nomFournisseur } ${detailfornisseur.preNomFournisseur}</legend>
			<form action="${pageContext.servletContext.contextPath}/modifierfornisseur"
				method="post" class="f1">
				<input type="hidden" value="${detailfornisseur.idfournisseur}"name="id"> 
				<label>Nom</label><input type="text" name="nomfornisseur" value="${ detailfornisseur.nomFournisseur}"><br>
				<label>PreNom</label><input type="text" name="prenomfornisseur" value="${detailfornisseur.preNomFournisseur}"><br>
				<label>Adresse</label><input type="text" name="adresse" value="${detailfornisseur.adresse}"><br> 
				<label>Ville</label>
				<select name="ville">
				<c:forEach var="malistville" items="${vList}">
					<c:choose>
						<c:when test="${malistville.idVille == detailfornisseur.ville.idVille}">
							<option value="${malistville.idVille }" selected="selected">${malistville.nomVille }</option>
						</c:when>
						<c:otherwise>
							<option value="${malistville.idVille }" >${malistville.nomVille }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>	
					
					<br>
				<input type="submit" name="Modifier" value="Modifier" class="envoyer">
			</form>
			<form
				action="${pageContext.servletContext.contextPath}/listfornisseurs"
				method="post">
				<input class="button" type="submit" value="Annuler">
			</form>
		</fieldset>
	</div>
</body>
</html>