<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">

$(document).ready(function() {
});
</script>

<h1>CADASTRAR CLIENTE</h1>

<c:url var="urlSave" value="/consumer/save" />
<form:form method="post" action="${urlSave}" modelAttribute="consumer">
	<form:hidden path="id"/>
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
		<div class="form-group">
			<label for="email">E-mail</label>
			<form:input path="email" type="text" class="form-control" placeholder="E-mail" />
		</div>
	</div>
	
	<div class="col-sm-4" style="clear: both;">
		<div class="form-group">
			<label for="password">Senha</label>
			<form:input path="password" type="text" class="form-control" placeholder="Senha" />
		</div>
	</div>

	<div class="col-sm-4" style="clear: both;">
		<button class="btn btn-default" type="submit">Enviar</button>
	</div>
</form:form>
