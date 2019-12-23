<%@page import="ma.safi.entities.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Detaille du Produit :${ detailProduit.nomProduit }</title>
</head>
<body>
	<header>
		<jsp:include page="${request.contextPath()}/include/header.jsp"></jsp:include>		
	</header>
	<div id="main">
		<div id="sideBar">
 			<jsp:include page="${request.contextPath()}/include/infouser.jsp"></jsp:include>
 			<c:if test="${sessionScope.user.poste == 'Admin'}">
 				<jsp:include page="${request.contextPath()}/include/optionproduits.jsp"></jsp:include>
 			</c:if>
		</div>
		<fieldset id="fieldset">
			<legend>
				Detaille du Produit :
				${ detailProduit.nomProduit }</legend>
			<table id="Detaille">
				<tr><th>Nom de Produit</th><td>${ detailProduit.nomProduit }</td></tr>
				<tr><th>Prix Unitaire</th><td>${ detailProduit.prixUnitaire }</td></tr>
				<tr><th>Quantite</th><td> ${ detailProduit.quantite}</td></tr>
				<tr><th>Description</th><td>  ${ detailProduit.description}</td></tr>
				<tr><th>Fournisseur</th><td> <a href="${pageContext.servletContext.contextPath}/detataildufornisseur?id=${detailProduit.founisseur.idfournisseur}">${ detailProduit.founisseur.nomFournisseur}
					${ detailProduit.founisseur.preNomFournisseur}</a></td></tr>
				
			</table>
		</fieldset>
	</div>
	<footer>
		<jsp:include page="${request.getContextPath()}/include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>