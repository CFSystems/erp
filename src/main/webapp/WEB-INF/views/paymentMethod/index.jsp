<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<h1>FORMAS DE PAGAMENTO</h1>

<a role="button" class="btn btn-default"
	href="<c:url value="/paymentMethod/form" />"> <i class="fa fa-plus"
	aria-hidden="true"></i> Adicionar
</a>
<div style="clear: both; height: 10px;"></div>

<c:choose>
	<c:when test="${empty paymentsMethod}">
		<div class="alert alert-info" role="alert">Nenhuma Forma de
			Pagamento Cadastrada.</div>
	</c:when>
	<c:otherwise>
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<td>ID</td>
				<td>Nome</td>
			</tr>
			<c:forEach items="${paymentsMethod}" var="paymentMethod">
				<tr>
					<td>${paymentMethod.id}</td>
					<td>${paymentMethod.name}</td>
				</tr>
			</c:forEach>
		</table>

	</c:otherwise>
</c:choose>