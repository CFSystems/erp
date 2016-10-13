<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<h1>CADASTRAR FORMA DE PAGAMENTO</h1>

<c:url var="urlSave" value="/paymentMethod/save" />
<form:form method="post" action="${urlSave}"
	modelAttribute="paymentMethod">
	<div>
		<label for="name">Nome</label>
		<form:input path="name" />
	</div>
	<div>
		<input type="submit" value="Enviar">
	</div>
</form:form>