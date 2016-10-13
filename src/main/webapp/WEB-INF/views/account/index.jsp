<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<h1>LISTAR CONTAS</h1>

<a role="button" class="btn btn-default"
	href="<c:url value="/account/form" />"> <i class="fa fa-plus"
	aria-hidden="true"></i> Adicionar
</a>
<div style="clear: both; height: 10px;"></div>

<c:choose>
	<c:when test="${empty accounts}">
		<div class="alert alert-info" role="alert">Nenhuma Conta
			Cadastrada.</div>
	</c:when>
	<c:otherwise>
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<td>ID</td>
				<td>Cliente</td>
				<td>Valor Conta</td>
				<td>Valor Pago</td>
				<td>Status</td>
			</tr>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.id}</td>
					<td>${account.consumer.name}</td>
					<td>${account.amountSpent}</td>
					<td>${account.amountPaid}</td>
					<td>${account.status}</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>