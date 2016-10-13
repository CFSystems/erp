<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<h1>CADASTRAR PAGAMENTO</h1>

<c:url var="urlSave" value="/payment/save" />
<form:form method="post" action="${urlSave}" modelAttribute="payment">
	<div>
		<label for="account.id">Conta</label>
		<form:input path="account.id" />
	</div>
	<div>
		<label for="value">Valor</label>
		<form:input path="value" />
	</div>
	<div>
		<label for="paymentMethod.id">Forma de Pagamento</label>
		<form:input path="paymentMethod.id" />
	</div>
	<div>
		<input type="submit" value="Enviar">
	</div>
</form:form>