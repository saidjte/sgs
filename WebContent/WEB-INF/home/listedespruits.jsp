<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
	<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>La liste des Produits</title>
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
				<p class="msg">
					${msgmanupilationproduit}
				</p>
				<p class="msge">
					${msgmanupilationproduite}
				</p>
				
		</div>
		<fieldset id="fieldset">
			<legend>La liste des Produits</legend>
			<table id="tbdet">
			<thead><tr><th>Nom de Produit</th><th colspan="3">Actions </th></tr></thead>
			<tbody>
			<c:forEach items="${ listPoduits}" var="malistproduit">
			<tr><td> <c:out value="${ malistproduit.nomProduit }"></c:out></td><td><a href="${pageContext.servletContext.contextPath}/detatailduproduit?id=<c:out value="${ malistproduit.idProduit }"></c:out>">Voir Detail</a></td>
			<td><input class="listbotons" type="submit" title="Modifier le Produit" value="Modifier" onClick="document.location = '${pageContext.servletContext.contextPath}/modifierproduit?id=${ malistproduit.idProduit }'"></td>
			<td>
				<form class="listbotons" action="${pageContext.servletContext.contextPath}/confermationproduit" method="post" >
					 <input type="hidden" value="${ malistproduit.idProduit }" name="id"> 
					 <input	type="hidden" value="${ malistproduit.nomProduit }" name="nomProduit">
					<input class="button" type="submit" title="Supprimer le Produit" value="Supprimer">
				</form>
				</td>		
			</tr>
			</c:forEach>
			</tbody>
			</table>
		</fieldset>

	</div>

	<jsp:include page="${request.contextPath()}/include/footer.jsp"></jsp:include>
</body>
</html>