<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/include/css/stylelogin.css" />
<jsp:include page="${request.contextPath}/include/head.jsp"></jsp:include>
<title>Login</title>
</head>
<body>
	<header> </header>
	<div id="login">
		<fieldset>
			<legend>Connexion </legend>
			<div class="logo">
				<img alt="Logo" title="Logo"
					src="${pageContext.servletContext.contextPath}/include/imgs/logo-sgs.png">
			</div>
			<form action="${pageContext.servletContext.contextPath}/login" method="post">
				<p>
					<label>Nom d'utilisateur</label><input type="text" id="loguser"
						name="loguser">
				</p>
				<p>
					<label>Mot de pass</label><input type="password" id="logpass"
						name="logpass">
				</p>
				<p>
					<input type="submit" name="authentifier" id="authentifier"
						value="Login">
				</p>
			</form>
		</fieldset>
		<h2 class="login">		
			${msglogin}
			${msgloginerror}
		</h2>
	</div>
</body>
</html>