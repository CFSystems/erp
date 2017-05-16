<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">

$(document).ready(function() {
});
</script>

<h1>LISTAR PRODUTOS</h1>

<a role="button" class="btn btn-default" href="<c:url value="/product/form" />">
	<i class="fa fa-plus" aria-hidden="true"></i> Adicionar
</a>
<div style="clear: both; height: 10px;"></div>

<c:choose>
	<c:when test="${empty products}">
		<div class="alert alert-info" role="alert">
			Nenhum Produto Cadastrado.
		</div>
	</c:when>
	<c:otherwise>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Valor</th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.name}</td>
					<td>${product.value}</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>