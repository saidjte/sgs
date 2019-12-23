<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/include/css/erreurpage.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Erreur N° 404</title>
</head>
<body>
<fieldset class="messageErreur">
<h1>Erreur N° 404</h1>
<img alt="404" title="Erreur N° 404" src="${pageContext.servletContext.contextPath}/include/imgs/404.png">
<p>
${msgloginerror }
</p>
<a href="${pageContext.servletContext.contextPath}/"> Retourner au Page d'accueil</a>
</fieldset>
</body>
</html>