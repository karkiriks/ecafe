<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body class="bg-success">
	<div class="container">
		<div class="col-md-9">
			<h2 class="text-center text-info">New Product</h2>
			<div class="col-md-6">
				<form:form method="post" modelAttribute="productModel" action="/ecafe/admin/product/add">
					<div class="form-group">
						<label class="control-label" for="">Product Name</label>
						<form:input path="productName" class="form-control" type="text" placeholder="product name" />
					</div>
					<div class="form-group">
					<label class="control-label" for="">Description</label>
					<form:input path="description" type="text" class="form-control" placeholder="Description" />
					</div>
					<div class="form-group">
					<label class="control-label" for="">Price</label>
					<form:input path="price" type="text" class="form-control" placeholder="Price" />
					</div>
					<div class="form-group">
						<label class="control-label" for="">Product Type</label>
						<form:select path="productType" >
						<form:option value="BREAKFAST" label="Breakfast" />
 						<form:option value="LUNCH" label="Lunch" />
						<form:option value="DINNER" label="Dinner" />
						</form:select>
					</div>
		
					<div class="center" >
						<input type="submit" class="btn btn-primary pull-right" name="action" value="Add Product"></button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>