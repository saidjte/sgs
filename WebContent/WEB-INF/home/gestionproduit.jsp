<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
	<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Gestion du produits</title>
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
			
			<div class="produit">
				<figure>
				<a href="${pageContext.servletContext.contextPath}/ajouterunproduit">
					<img alt="Ajouter un produit" src="./include/imgs/icons8-paquet+64.png">
				</a>	
					<figcaption>
				<a href="${pageContext.servletContext.contextPath}/listproduit">
					Ajouter un produit
				</a>	
					</figcaption> 
					</figure>
			</div>
			<div class="produit">
					<figure>
				<a href="${pageContext.servletContext.contextPath}/listproduit">
					<img alt="Products" src="./include/imgs/icons8-paquetliste64.png">
				</a>	
					<figcaption>
					<a href="${pageContext.servletContext.contextPath}/listproduit">
					liste des Products
					</a>
					</figcaption> 

					</figure>
				
			</div>
		</div>
	</div>
	<jsp:include page="${request.contextPath()}/include/footer.jsp"></jsp:include>
</body>
</html>