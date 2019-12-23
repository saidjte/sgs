<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Gestion du fornisseurs</title>
</head>
<body>
		<jsp:include page="${request.contextPath()}/include/header.jsp"></jsp:include>

		<div id="main">
		<div id="sideBar">
			<jsp:include page="${request.contextPath()}/include/infouser.jsp"></jsp:include>
			<fieldset id="options">
			<legend>Liste Des Options</legend>
				<img src="${pageContext.servletContext.contextPath}/include/imgs/back.png" title="back" alt="back" class="icon ic_b_edit"> 
				<input class="button" type="button" title="Retourner au Page d'accueil"
				value="Retourner au Page d'accueil" onClick="document.location = '${pageContext.servletContext.contextPath}'">
			</fieldset>			
			
		</div>
				<div id="menuhome">
			
			<div class="Fornisseurs">
				<figure>
				<a href="${pageContext.servletContext.contextPath}/ajouterfornisseur">
					<img alt="Ajouter un Fornisseurs" src="./include/imgs/icons8-fournisseur+64.png">
				</a>	
					<figcaption>
				<a href="${pageContext.servletContext.contextPath}/listproduit">
					Ajouter un Fornisseurs
				</a>	
					</figcaption> 
					</figure>
			</div>
			<div class="Fornisseurs">
					<figure>
				<a href="${pageContext.servletContext.contextPath}/listfornisseurs">
					<img alt="liste des Fornisseurs" src="./include/imgs/icons8-fournisseur-list-64.png">
				</a>	
					<figcaption>
					<a href="${request.contextPath()}/listproduit">
					liste des Fornisseurs
					</a>
					</figcaption> 

					</figure>
				
			</div>
		</div>
	</div>
	<jsp:include page="${request.contextPath()}/include/footer.jsp"></jsp:include>
</body>
</html>