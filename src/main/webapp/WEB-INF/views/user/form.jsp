<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<h1>CADASTRAR USUÁRIO</h1>

<c:url var="urlSave" value="/user/save" />
<form:form method="post" action="${urlSave}" modelAttribute="user">
	<div>
		<label for="name">Nome</label>
		<form:input path="name" />
	</div>
	<div>
		<label for="document">Documento</label>
		<form:input path="document" />
	</div>
	<div>
		<label for="email">E-mail</label>
		<form:input path="email" />
	</div>
	<div>
		<label for="password">Senha</label>
		<form:input path="password" />
	</div>
	<div>
		<button class="btn btn-default" type="submit">Enviar</button>
	</div>
</form:form>