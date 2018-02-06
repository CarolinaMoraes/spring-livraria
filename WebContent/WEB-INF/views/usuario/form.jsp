<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/usuario/salvar" var="urlSalvar"  />

<!DOCTYPE html>
<html>
<head>
	<c:import url="../templates/head.jsp" />
</head>
<body>
	<c:import url="../templates/header.jsp" />
	<div class="row">
    <form:form modelAttribute="usuario" class="col s12" action="${urlSalvar}" method="post">
      <div class="row">
        <div class="input-field col s4">
        	<form:input path="nome" id="inputNome" type="text" class="validate" />
          	<label for="inputNome">Primeiro Nome</label>
          	<form:errors path="nome" />
        </div>
        <div class="input-field col s8">
        	<form:input path="sobrenome" id="inputSobrenome" type="text" class="validate"/>
          	<label for="inputSobrenome">Sobrenome</label>
          	<form:errors path="sobrenome" />
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
			<form:input path="email" id="inputEmail" type="email" class="validate" />
			<label for="inputEmail">Email</label>
			<form:errors path="email" />
        </div>
      </div>
      <div class="row">
        <div class="input-field col 6">
        	<form:input path="dataNascimento" id="inputDataNascimento" type="text" class="validate" />
			<label for="inputDataNascimento">Data de nascimento</label>
			<form:errors path="dataNascimento" />
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
        <div class="input-field col s12">
			<input id="inputRepetirSenha" type="password" class="validate" />
			<label for="inputRepetirSenha">Repetir senha</label>
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