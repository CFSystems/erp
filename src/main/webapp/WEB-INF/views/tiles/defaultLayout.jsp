<jsp:directive.include file="/WEB-INF/views/includes.jsp" />

<!DOCTYPE html>
<html lang="en">
  <head>
		<title><tiles:getAsString name="title" /></title>
		<meta http-equiv="Content-Type" content="text/html">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="Felipe">

   		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.min.css"/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
		
		<style type="text/css">
		.footer {
		    position: absolute;
		    bottom: 0;
		    width: 100%;
		    height: 60px;
		    background-color: #f5f5f5;
		}
		</style>
		
		<script src="<c:url value="/resources/js/angular.min.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap-formhelpers-phone.format.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap-formhelpers-phone.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap-select.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap-switch.js"/>"></script>

  </head>

  <body>
	<tiles:insertAttribute name="header" />

    <div class="container-fluid" style="margin-top: 60px;">
		<div class="row">
			<tiles:insertAttribute name="menu" />
        
			<div class="col-sm-9 col-md-10 main">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>

	<tiles:insertAttribute name="footer" />
    
  </body>
</html>
