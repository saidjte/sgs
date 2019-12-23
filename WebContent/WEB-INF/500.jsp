<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/include/css/erreurpage.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<fieldset class="messageErreur">
<h1>Erreur N° 500</h1>
<img alt="500" title="Erreur N° 500" src="${pageContext.servletContext.contextPath}/include/imgs/oops.PNG">
<p>
${msgloginerror }
</p>
<a href="${pageContext.servletContext.contextPath}/"> Retourner au Page d'accueil</a>
</fieldset>
</body>
</html>