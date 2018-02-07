<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/categoria/salvar" var="urlSalvar" />

<!DOCTYPE html>
<html>
<head>
	<c:import url="../templates/head.jsp" />
</head>
<body>
	<c:import url="../templates/header.jsp" />
	<main class="container">
		<c:choose>
			<c:when test="${empty categoria.id}">
				<h2>Cadastro de categoria</h2>
			</c:when>
			<c:otherwise>
				<h2>Alterando categoria ${categoria.nome}</h2>
			</c:otherwise>
		</c:choose>
		<form:form modelAttribute="categoria">
			<div class="row">
	        <div class="input-field col s9">
	        	<form:input path="nome" id="inputPassword" type="password" class="validate" />
				<label for="inputPassword">Nome da categoria</label>
				<form:errors path="nome" />
	        </div>
	        <div class="input-field col s3">
	        	<button class="waves-effect waves-light btn" type="submit">Salvar</button>
	        </div>
	      </div>
		</form:form>
	</main>
</body>
</html>