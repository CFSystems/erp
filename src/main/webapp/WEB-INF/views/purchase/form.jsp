<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<script type="text/javascript">

var addFormGroup = function (event) {
    event.preventDefault();

    var $formGroup = $(this).closest('.form-group');
    var $multipleFormGroup = $formGroup.closest('.multiple-form-group');
    var $formGroupClone = $formGroup.clone();

    $(this)
    	.toggleClass('btn-default btn-add btn-danger btn-remove')
        .html('-');

    $formGroupClone.find('input').val('');
    $formGroupClone.insertAfter($formGroup);
    var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
    if ($multipleFormGroup.data('max') <= countFormGroup($multipleFormGroup)) {
        $lastFormGroupLast.find('.btn-add').attr('disabled', true);
    }

    bindChangeSelect();
	setNames();
};

var setNames = function (event) {
	$('.form-group').each(function() {
		
		var $select = $(this).find('.select-product')
		var $qtde 	= $(this).find('.qtde');
		var $valor 	= $(this).find('.produto-valor');
		
		var selectName = 'purchaseProducts['+$(this).index()+'].product.id'
		$select.attr('name', selectName);
		
		var qtdeName = 'purchaseProducts['+$(this).index()+'].quantity'
		$qtde.attr('name', qtdeName);
		
		var valorName = 'purchaseProducts['+$(this).index()+'].unitaryValue'
		$valor.attr('name', valorName);
	})
};
var bindChangeSelect = function (event) {
	$('.select-product').off('change').change(function() {
		if ( $(this).val().length == 0 ) return; // SELECIONE
		var $formGroup 	= $(this).closest('.form-group');
		var $option 	= $(this).find(":selected");
		var valor 		= $option.attr('data-valor');
		var $inputValor	= $('.produto-valor', $formGroup);
		$inputValor.val(valor);
	});
	
};
var removeFormGroup = function (event) {
    event.preventDefault();

    var $formGroup = $(this).closest('.form-group');
    var $multipleFormGroup = $formGroup.closest('.multiple-form-group');

    var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
    if ($multipleFormGroup.data('max') >= countFormGroup($multipleFormGroup)) {
        $lastFormGroupLast.find('.btn-add').attr('disabled', false);
    }

    $formGroup.remove();
};

var countFormGroup = function ($form) {
    return $form.find('.form-group').length;
};

$(document).on('click', '.btn-add', addFormGroup);
$(document).on('click', '.btn-remove', removeFormGroup);

$(document).ready(function() {
	bindChangeSelect();
	setNames();
});
</script>

<h1>CADASTRAR PEDIDO</h1>

<c:url var="urlSave" value="/purchase/save" />
<form:form method="post" action="${urlSave}" modelAttribute="purchase">
	
	<div class="row form-group multiple-form-group" style="clear: both;">
		
		<label for="account.id">Conta</label>
		<form:input path="account.id"/>
		<label for="user.id">Usuário</label>
		<form:input path="user.id"/>
		
	 	<div class="col-sm-4">
			<label>Produto</label>
			<select class="form-control select-product">
				<option>Selecione</option>
				<c:forEach items="${products}" var="produto" varStatus="status">
				  <option data-valor="${produto.value}" value="${produto.id}">${produto.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-sm-2">
			<label>Qtde</label>
			<div class="input-group">
				<input type="text" class="form-control qtde" value="1">
			</div>
		</div>
		<div class="col-sm-2">
			<label>Valor</label>
			<div class="input-group">
				<span class="input-group-addon">$</span>
				<input type="text" class="form-control produto-valor">
				<span class="input-group-addon">.00</span>
			</div>
		</div>
		<div class="col-sm-4">	
			<label>&nbsp;</label>
			<div class="input-group">
				<button type="button" class="btn btn-default btn-add">+
				</button>
			</div>
		</div>
	</div> 
	<div class="col-sm-4" style="clear: both;">
		<button class="btn btn-default" type="submit">Enviar</button>
	</div>
</form:form>