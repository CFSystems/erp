<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<h1>CADASTRAR CONTA</h1>

<c:url var="urlSave" value="/account/save" />
<form:form method="post" action="${urlSave}" modelAttribute="account">
	<div>
		<label for="consumer.id">Código do Cliente</label>
		<form:input path="consumer.id" />
	</div>
	<div>
		<label for="status">Status</label>
		<form:input path="status" />
	</div>
	<div>
		<input type="submit" value="Enviar">
	</div>
</form:form>