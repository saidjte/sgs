<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Ajouter un Produit</title>
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
				<input class="button" type="button" title="Retourner au gestion du produits"
				value="Retourner au gestion du produits" onClick="document.location = '${pageContext.servletContext.contextPath}/gestionduproduits'">
			</fieldset>			
		</div>
		<fieldset id="fieldset">
			<legend class="lege-Login">Ajouter un Produit</legend>
				<p class="msge">
					${msgmanupilationproduit}
				</p>
			
			<form action="${pageContext.servletContext.contextPath}/ajouterunproduit"
				method="post" class="f1">
				<label>Nom de Produit</label><input type="text" name="nomProduit"><br>
				<label>Prix Unitaire</label><input type="text" name="prixUnitaire"><br>
				<label>quantite</label><input type="number" name="quantite"><br>
				<label>description</label><input type="text" name="description"><br>
				<label>fournisseur</label> <select name="fournisseur">
					<c:forEach var="opfor" items="${listFornisseur}">
						<c:choose>
							<c:when test="${opfor.idfournisseur == detailProduit.founisseur.idfournisseur}">
	 							<option value="${ opfor.idfournisseur }" selected >${opfor.nomFournisseur} ${opfor.preNomFournisseur}</option>
	 						</c:when>
	 						<c:otherwise>
	 							<option value="${ opfor.idfournisseur }">${opfor.nomFournisseur} ${opfor.preNomFournisseur}</option>
	 						</c:otherwise>
						</c:choose>
					</c:forEach>
					</select>	
				<br>
				<input type="submit" name="Ajouter" value="Ajouter" class="envoyer">
			</form>
			<form action="${pageContext.servletContext.contextPath}/gestionduproduits" method="post">
				<input type="hidden" value="${detailProduit.idProduit}" name="id"> 
				<input class="button" type="submit" value="Annuler">
			</form>
		</fieldset>
	</div>
	<footer>
		<jsp:include page="${request.getContextPath()}/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>