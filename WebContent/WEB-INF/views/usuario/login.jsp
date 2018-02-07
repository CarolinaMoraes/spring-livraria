<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>

<c:url value="/autenticar" var="urlAutenticar"  />

<!DOCTYPE html>
<html>
<head>
	<c:import url="../templates/head.jsp" />
</head>
<body>
	<c:import url="../templates/header.jsp" />
	<div class="row">
	<c:if test="${not empty param.cadastrado}">
	    <div class="card-panel center teal accent-2">
	    	<h5>Você está cadastrado! Agora autentique-se para utilizar nosso sistema ♥</h5>
	    </div>
	</c:if>
    <form:form modelAttribute="usuario" class="col s12" action="${urlAutenticar}" method="post">
      <div class="row">
        <div class="input-field col s12">
			<form:input path="email" id="inputEmail" type="email" class="validate" />
			<label for="inputEmail">Email</label>
			<form:errors path="email" />
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
        	<form:input path="senha" id="inputPassword" type="password" class="validate" />
			<label for="inputPassword">Senha</label>
			<form:errors path="senha" />
        </div>
      </div>
      <div class="row">
        <div class="col s12">
         <button class="waves-effect waves-light btn" type="submit">Salvar</button>
        </div>
      </div>
    </form:form>
  </div>
</body>
</html>