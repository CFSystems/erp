<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<h1>LISTAR CLIENTE</h1>

<a role="button" class="btn btn-default"
	href="<c:url value="/consumer/form" />"> <i class="fa fa-plus"
	aria-hidden="true"></i> Adicionar
</a>
<div style="clear: both; height: 10px;"></div>

<c:choose>
	<c:when test="${empty consumers}">
		<div class="alert alert-info" role="alert">Nenhum Cliente
			Cadastrado.</div>
	</c:when>
	<c:otherwise>
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>Documento</td>
				<td>Telefone</td>
				<td>E-mail</td>
				<td></td>
			</tr>
			<c:forEach items="${consumers}" var="consumer">
				<tr>
					<td>${consumer.id}</td>
					<td>${consumer.name}</td>
					<td>${consumer.document}</td>
					<td>${consumer.phoneNumber}</td>
					<td>${consumer.email}</td>
					<td><a href="<c:url value='consumer/edit-${consumer.id}'/>">Editar</a>
					<a href="<c:url value='consumer/delete-${consumer.id}' />">Deletar</a></td>
				</tr>
			</c:forEach>
		</table>

	</c:otherwise>
</c:choose>
