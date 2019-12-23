<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/style.css" />
			<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>

<title>Systeme de Gestion de Stock {SGS}</title>
</head>
<body>
		<jsp:include page="${request.contextPath}/include/header.jsp"></jsp:include>

		<div id="main">
		<div id="sideBar">
			<jsp:include page="${request.contextPath}/include/infouser.jsp"></jsp:include>
		</div>
				<div id="menuhome">
			
			<div class="Fornisseurs">
				<figure>
				<a href="${pageContext.servletContext.contextPath}/gestionfornisseurs">
					<img alt="Fornisseurs" src="./include/imgs/icons8-fournisseur-64.png">
				</a>	
					<figcaption>
				<a href="${pageContext.servletContext.contextPath}/listproduit">
					Fornisseurs
				</a>	
					</figcaption> 
					</figure>
			</div>
			<div class="produit">
					<figure>
				<a href="${pageContext.servletContext.contextPath}/gestionduproduits">
					<img alt="Products" src="./include/imgs/icons8-paquet-64.png">
				</a>	
					<figcaption>
					<a href="${pageContext.servletContext.contextPath}/listproduit">
					Products
					</a>
					</figcaption> 

					</figure>
			</div>
		</div>
	</div>
	<jsp:include page="${request.contextPath()}/include/footer.jsp"></jsp:include>
</body>
</html>