<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">

$(document).ready(function() {
});
</script>

<h1>LISTAR PEDIDOS</h1>

<a role="button" class="btn btn-default" href="<c:url value="/purchase/form" />">
	<i class="fa fa-plus" aria-hidden="true"></i> Adicionar
</a>
<div style="clear: both; height: 10px;"></div>

<c:choose>
	<c:when test="${empty purchases}">
		<div class="alert alert-info" role="alert">
			Nenhum Pedido Cadastrado.
		</div>
	</c:when>
	<c:otherwise>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<td>ID</td>
					<td>Conta</td>
					<td>Usuário</td>
					<td>Valor</td>
				</tr>
			</thead>
			<c:forEach items="${purchases}" var="purchase">
				<tr>
					<td>${purchase.id}</td>
					<td>${purchase.account.id}</td>
					<td>${purchase.user.name}</td>
					<td>${purchase.value}</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3">
						<table class="table table-striped table-hover table-bordered">
							<thead>
								<tr>
									<td>ID</td>
									<td>Produto</td>
									<td>Qtde</td>
									<td>Valor Unitário</td>
									<td>Valor Total</td>
								</tr>
							</thead>
							<c:forEach items="${purchase.purchaseProducts}" var="purchaseProduct">
								<tr>
									<td>${purchaseProduct.id}</td>
									<td>${purchaseProduct.product.name}</td>
									<td>${purchaseProduct.quantity}</td>
									<td>${purchaseProduct.unitaryValue}</td>
									<td>${purchaseProduct.amount}</td>
								</tr>
							</c:forEach>
						</table>
					
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>