<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Detaille du Fornisseurs : ${detailfornisseur.nomFournisseur}</title>
</head>
<body>
	<header>
		<jsp:include page="${request.getContextPath()}/include/header.jsp"></jsp:include>
	</header>
	<div id="main">
		<div id="sideBar">
			<jsp:include page="${request.getContextPath()}/include/infouser.jsp"></jsp:include>
			<jsp:include page="${request.getContextPath()}/include/optionfornisseur.jsp"></jsp:include>
		</div>
		<fieldset id="fieldset">
			<legend>
				Detaille du Fornisseurs :
				${detailfornisseur.nomFournisseur}</legend>
			<table id="Detaille">
				<tr><th>Nom </th><td>: ${detailfornisseur.nomFournisseur}</td></tr>
				<tr><th>PreNom </th><td>: ${detailfornisseur.preNomFournisseur}</td></tr>
				<tr><th>Adresse </th><td>: ${detailfornisseur.adresse}</td></tr>
				<tr><th>Ville</th><td> : ${detailfornisseur.ville.nomVille}</td></tr>
			</table>
			<h2>Liste des Produits</h2>
			<table id="tbdet">
				<thead><tr><th>Nom de Produit</th><th colspan="3">Actions </th></tr></thead>
				<tbody>
				<c:choose>
				<c:when test="${empty listPoduits}">
				<tr><td colspan="4">La liste est Vide</td>
			</c:when>
			<c:otherwise>
			<c:forEach var="listedeporoduitfor" items="${listPoduits}">
				<c:if test="${listedeporoduitfor.founisseur.idfournisseur == detailfornisseur.idfournisseur }">
					<tr><td> <c:out value="${ listedeporoduitfor.nomProduit }"></c:out></td><td><a href="${pageContext.servletContext.contextPath}/detatailduproduit?id=<c:out value="${ listedeporoduitfor.idProduit }"></c:out>">Voir Detail</a></td>
						<td><input class="listbotons" type="submit" title="Modifier le Produit" value="Modifier" onClick="document.location = '${pageContext.servletContext.contextPath}/modifierproduit?id=${ listedeporoduitfor.idProduit }'"></td>
						<td>
					<form class="listbotons" action="${pageContext.servletContext.contextPath}/confermationproduit" method="post" >
						 <input type="hidden" value="${ listedeporoduitfor.idProduit }" name="id"> 
						 <input	type="hidden" value="${ listedeporoduitfor.nomProduit }" name="nomProduit">
						<input class="button" type="submit" title="Supprimer le Produit" value="Supprimer">
					</form>
				</td>		
			</tr>
				</c:if>
			</c:forEach>
				
			</c:otherwise>
			</c:choose>
			</tbody>
			</table>
		</fieldset>
	</div>
	<footer>
		<jsp:include page="${request.getContextPath()}/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>