<%@page import="br.caelum.clauvane.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

<title>MVC</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<jsp:useBean id="dao" class="br.caelum.clauvane.dao.ContatoDao"/>
<table border="1">
	<tr>
	<th>id</th>
	<th>nome</th>
	<th>endereco</th>
	<th>email</th>
	<th>data</th>
	</tr>
	<c:forEach var="contato" items="${dao.contatos}" varStatus="contador">
		<tr bgcolor="#${contador.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
			<td>${contato.id}</td>
			<td>${contato.nome}</td>
			<td>${contato.endereco}</td>
			<td>
				<c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
				</c:if>
				<c:if test="${empty contato.email}">
					Email nao informado
				</c:if>
				
			</td>
			<td>
				<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /> 
			</td>
		</tr>
	</c:forEach>
</table>
<br/>
<br/>
<a href="adicionaContato.html" >NOVO</a>
<br/>
<a href="alteraContato.html" >ALTERAR</a>
<c:import url="rodape.jsp"></c:import>
</body>
</html>