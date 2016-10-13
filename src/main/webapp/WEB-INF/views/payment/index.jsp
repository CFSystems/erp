<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<h1>LISTAR PAGAMENTOS</h1>

<a role="button" class="btn btn-default"
	href="<c:url value="/payment/form" />"> <i class="fa fa-plus"
	aria-hidden="true"></i> Adicionar
</a>
<div style="clear: both; height: 10px;"></div>

<c:choose>
	<c:when test="${empty payments}">
		<div class="alert alert-info" role="alert">Nenhum Pagamento
			Cadastrado.</div>
	</c:when>
	<c:otherwise>
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<td>ID</td>
				<td>Conta</td>
				<td>Valor</td>
				<td>Forma de Pagamento</td>
			</tr>
			<c:forEach items="${payments}" var="payment">
				<tr>
					<td>${payment.id}</td>
					<td>${payment.account.id}</td>
					<td>${payment.value}</td>
					<td>${payment.paymentMethod.name}</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>