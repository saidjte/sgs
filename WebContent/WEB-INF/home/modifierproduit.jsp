<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/include/css/style.css" />
<link rel="icon" href="img/ico.png" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Modifier le Produit</title>
</head>
<body>

	<jsp:include page="${request.contextPath()}/include/header.jsp"></jsp:include>
	<div id="main">
		<div id="sideBar">
			<jsp:include page="${request.contextPath()}/include/infouser.jsp"></jsp:include>
		</div>
		<fieldset id="fieldset">
			<legend class="lege-Modifier">Modifier le Produit </legend>
			
			<form action="${pageContext.servletContext.contextPath}/modifierproduit" method="post" class="f1">
				<input type="hidden" value="${detailProduit.idProduit}" name="id"> 
				<label>Nom de Produit</label> <input type="text" name="nomProduit" value="${detailProduit.nomProduit}"><br>
				<label>Prix Unitaire</label> <input type="text" name="prixUnitaire" value="${detailProduit.prixUnitaire}"><br>
				<label>Quantite</label> <input type="number" name="quantite" value="${detailProduit.quantite}"><br> 
				<label>Description</label> <input type="text" name="description" value="${detailProduit.description}"><br>
				<label>Fournisseur</label> 
				<select name="fournisseur">
					<c:forEach var="opfor" items="${listFornisseur}">
						<c:choose>
							<c:when test="${opfor.idfournisseur == detailProduit.founisseur.idfournisseur}">
	 							<option value="${ opfor.idfournisseur }" selected="selected" >${opfor.nomFournisseur} ${opfor.preNomFournisseur}</option>
	 						</c:when>
	 						<c:otherwise>
	 							<option value="${ opfor.idfournisseur }">${opfor.nomFournisseur} ${opfor.preNomFournisseur}</option>
	 						</c:otherwise>
						</c:choose>
					</c:forEach>
					</select>	
				<br>
				<input type="submit" name="modifier" value="Modifier"class="envoyer">
				
			</form>
			
			<form action="${pageContext.servletContext.contextPath}/detatailduproduit"
				method="post">
				<input type="hidden" value="${detailProduit.idProduit}" name="id"> 
				<input class="button" type="submit" value="Annuler">
	</form>
		</fieldset>
	</div>
</body>
</html>