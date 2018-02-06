<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/usuario/salvar" var="urlSalvar"  />

<!DOCTYPE html>
<html>
<head>
	<c:import url="../templates/head.jsp" />
</head>
<body>
	<c:import url="../templates/header.jsp" />
	<div class="row">
    <form class="col 9 center" action="${urlSalvar}" method="post">
      <div class="row">
        <div class="input-field col s12">
          <input id="inputEmail" type="email" name="email" class="validate">
          <label for="inputEmail">Email</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="inputPassword" type="password" name="password" class="validate">
          <label for="inputPassword">Senha</label>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
         <button class="waves-effect waves-light btn" type="submit">Entrar</button>
        </div>
      </div>
    </form>
  </div>
</body>
</html>