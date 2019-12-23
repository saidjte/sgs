<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
	<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>La liste des Fornisseurs</title>
</head>
<body>
	<jsp:include page="${request.contextPath()}/include/header.jsp"></jsp:include>
	<div id="main">
		<div id="sideBar">
			<jsp:include page="${request.contextPath()}/include/infouser.jsp"></jsp:include>
			<fieldset id="options">
			<legend>Liste Des Options</legend>
				<img src="${pageContext.servletContext.contextPath}/include/imgs/back.png" title="back" alt="back" class="icon ic_b_edit"> 
				<input class="button" type="button" title="Retourner au gestion du Fornisseur"
				value="Retourner au gestion du Fornisseur" onClick="document.location = '${pageContext.servletContext.contextPath}/gestionfornisseurs'">
			</fieldset>
				<p class="msge">
					${msgmanupilationfornisseure}
				</p>
			
			<p class="msg">
					${msgmanupilationfornisseur}
			</p>
		</div>
		<fieldset id="fieldset">
			<legend>La liste des Fornisseurs</legend>

			<table id="tbdet">
			<thead><tr><th>Nom de Fornisseur</th><th colspan="3">Actions</th></tr></thead>
				<c:forEach var="malisfornisseur" items="${listFornisseur}">
				<tr><td> <c:out value="${malisfornisseur.nomFournisseur} ${malisfornisseur.preNomFournisseur}"></c:out></td><td><a href="${pageContext.servletContext.contextPath}/detataildufornisseur?id=${malisfornisseur.idfournisseur}">Voir Detail</a></td>
					<td><input class="listbotons" type="submit" title="Modifier le Produit" value="Modifier" onClick="document.location = '${pageContext.servletContext.contextPath}/modifierfornisseur?id=${ malisfornisseur.idfournisseur }'"></td>
					<td>
					<form class="listbotons" action="${pageContext.servletContext.contextPath}/confermationfornisseur" method="post" >
					 	<input type="hidden" value="${ malisfornisseur.idfournisseur }" name="id"> 
						 <input	type="hidden" value="${ malisfornisseur.nomFournisseur } ${ malisfornisseur.preNomFournisseur }" name="nomFornisseur">
						<input class="button" type="submit" title="Supprimer le Produit" value="Supprimer">
					</form>
					</td>		
				</tr>
				</c:forEach>
			</table>
		</fieldset>

	</div>

	<jsp:include page="${request.contextPath()}/include/footer.jsp"></jsp:include>
</body>
</html>