<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<fieldset id="options">
	<legend>Liste Des Options</legend>

	<img src="${pageContext.servletContext.contextPath}/include/imgs/b_edit.png" title="Éditer" alt="Éditer" class="icon ic_b_edit" >
	<input class="button" type="submit" title="Modifier le Produit" value="Modifier le Produit" onClick="document.location = '${pageContext.servletContext.contextPath}/modifierproduit?id=${ detailProduit.idProduit }'">

	<form action="${pageContext.servletContext.contextPath}/confermationproduit" method="post" >
		<img src="${pageContext.servletContext.contextPath}/include/imgs/b_drop.png"
			title="drop" alt="drop" class="icon b_drop"> <input
			type="hidden" value="${ detailProduit.idProduit }" name="id"> <input
			type="hidden" value="${ detailProduit.nomProduit }" name="nomProduit">
		<input class="button" type="submit" title="Supprimer le Produit"
			value="Supprimer le Produit">
	</form>
		<img src="${pageContext.servletContext.contextPath}/include/imgs/back.png"
			title="back" alt="back" class="icon ic_b_edit"> 
			<input class="button" type="button" title="Retourner à la liste des Produit"
			value="Retourner à la liste des Produit" onClick="document.location = '${pageContext.servletContext.contextPath}/listproduit'">
</fieldset>