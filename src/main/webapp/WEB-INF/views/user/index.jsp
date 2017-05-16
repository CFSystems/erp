<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<h1>LISTAR USUARIOS</h1>

<a role="button" class="btn btn-default"
	href="<c:url value="/user/form" />"> <i class="fa fa-plus"
	aria-hidden="true"></i> Adicionar
</a>
<div style="clear: both; height: 10px;"></div>

<c:choose>
	<c:when test="${empty users}">
		<div class="alert alert-info" role="alert">Nenhum Usuário
			Cadastrado.</div>
	</c:when>
	<c:otherwise>
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>Documento</td>
				<td>E-mail</td>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.document}</td>
					<td>${user.email}</td>
				</tr>
			</c:forEach>
		</table>

	</c:otherwise>
</c:choose>