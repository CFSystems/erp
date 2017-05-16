<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">

$(document).ready(function() {
});
</script>

<h1>CADASTRAR PRODUTO</h1>
<c:url var="urlSave" value="/product/save" />
<form:form method="post" action="${urlSave}" modelAttribute="product">
	<div class="col-sm-4" style="clear: both;">
		<div class="form-group">
			<label for="name">Nome</label>
			<form:input path="name" type="text" class="form-control" placeholder="Nome" />
		</div>
	</div>
	<div class="col-sm-4" style="clear: both;">
		<div class="form-group">
			<label for="value">Valor</label>
			<form:input path="value" type="text" class="form-control" placeholder="value" />
		</div>
	</div>
	<div class="col-sm-4" style="clear: both;">
		<input type="submit" value="Enviar">
	</div>
</form:form>
