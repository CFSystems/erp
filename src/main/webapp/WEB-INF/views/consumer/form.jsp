<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">

$(document).ready(function() {
});
</script>

<h1>CADASTRAR CLIENTE</h1>

<c:url var="urlSave" value="/consumer/save" />
<form:form method="post" action="${urlSave}" modelAttribute="consumer">
	<div class="col-sm-4" style="clear: both;">
		<div class="form-group">
			<label for="name">Nome</label>
			<form:input path="name" type="text" class="form-control" placeholder="Nome" />
		</div>
	</div>
	
	<div class="col-sm-4" style="clear: both;">
		<div class="form-group">
			<label for="document">Documento</label>
			<form:input path="document" type="text" class="form-control" placeholder="Documento" />
		</div>
	</div>
	
	<div class="col-sm-4" style="clear: both;">
		<div class="form-group">
			<label for="phoneNumber">Número Telefone</label>
			<form:input path="phoneNumber" type="text" class="form-control" placeholder="Número Telefone" />
		</div>
	</div>

	<div class="col-sm-4" style="clear: both;">
		<button class="btn btn-default" type="submit">Enviar</button>
	</div>
</form:form>
