<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/entrar" var="urlEntrar" />
<c:url value="/sair" var="urlSair" />
<c:url value="/usuario/novo" var="urlCadastrar" />


<nav>
  <div class="nav-wrapper">
    <a href="#!" class="brand-logo left">Livraria</a>
    <ul class="right hide-on-med-and-down">
		<c:choose>
			<c:when test="${empty usuarioAutenticado}">
				<li><a href="${urlEntrar}">Entrar</a></li>
				<li><a href="${urlCadastrar}">Cadastrar-se</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${urlSair}">Sair</a></li>
			</c:otherwise>
		</c:choose>		
    </ul>
  </div>
</nav>