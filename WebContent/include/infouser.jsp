<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ma.safi.entities.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<fieldset id="userinfo">
	<legend>Profil de l'Utilisateur</legend>
		<img class="user_pic" alt="User" src="${pageContext.servletContext.contextPath}/include/imgs/user-96.png">
			<p><img src="${pageContext.servletContext.contextPath}/include/imgs/b_usrcheck.png" title="user" alt="user" class="icon user">
			${sessionScope.login}</p>
			<label class="userinfo">Nom </label>: ${sessionScope.user.nom}<br> 
			<label class="userinfo">PreNom</label>: ${sessionScope.user.preNom}<br>
			<label class="userinfo">Poste  </label>: ${sessionScope.user.poste}<br>
	<form action="${pageContext.servletContext.contextPath}/deconnexion"
		method="post">
		<input type="submit" value="Deconnexion">
	</form>
</fieldset>