<jsp:directive.include file="/WEB-INF/views/includes.jsp" />


<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="<c:url value="/consumer" />">Cliente</a></li>
		<li><a href="<c:url value="/product" />">Produto</a></li>
		<li><a href="<c:url value="/user" />">Usuário</a></li>
		<li><a href="<c:url value="/paymentMethod" />">Forma de Pagamento</a></li>
		<li><a href="<c:url value="/account" />">Conta</a></li>
		<li><a href="<c:url value="/payment" />">Pagamentos</a></li>
		<li><a href="<c:url value="/purchase" />">Pedidos</a></li>
	</ul>
</div>
