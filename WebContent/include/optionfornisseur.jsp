<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<fieldset id="options">
	<legend>Liste Des Options</legend>
	<form
		action="${pageContext.servletContext.contextPath}/modifierfornisseur"
		method="get">
		<img src="${pageContext.servletContext.contextPath}/include/imgs/b_edit.png"
			title="Éditer" alt="Éditer" class="icon ic_b_edit"> <input
			type="hidden" value="${detailfornisseur.idfournisseur}" name="id">
		<input class="button" type="submit" title="Modifier le Fornisseurs"
			value="Modifier le Fornisseurs">
	</form>
	<form
		action="${pageContext.servletContext.contextPath}/confermationfornisseur"
		method="post">
		<img src="${pageContext.servletContext.contextPath}/include/imgs/b_drop.png"
			title="drop" alt="drop" class="icon b_drop"> <input
			type="hidden" value="${detailfornisseur.idfournisseur}" name="id">
		<input type="hidden"
			value="${detailfornisseur.nomFournisseur} ${detailfornisseur.preNomFournisseur}"
			name="nomFornisseur"> <input class="button" type="submit"
			title="Supprimer le Fornisseurs" value="Supprimer le Fornisseurs">
	</form>
	<form
		action="${pageContext.servletContext.contextPath}/listfornisseurs"
		method="post">
		<img src="${pageContext.servletContext.contextPath}/include/imgs/back.png"
			title="back" alt="back" class="icon ic_b_edit"> <input
			class="button" type="submit"
			title="Retourner à la liste des Fornisseurs"
			value="Retourner à la liste des Fornisseurs">
	</form>
</fieldset>