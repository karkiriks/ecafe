<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9">

<h2>Dinner Items</h2>

		<table class="table table-striped table-hover table-bordered datatable">
			<thead>
				<tr>
					<td>Product Name</td>
					<td>Price</td>
					<td>Description</td>
					<td>Add Cart</td>
				</tr>
			</thead>
			<tbody>
			
				<div  class="text-right text-info" >
					<a href="${pageContext.request.contextPath}/orderline"> Total Cart  ${orderTotal} Checkout
				</div>
			   
				<c:forEach var="product" items="${products}">
					<tr>
					<td>${product.productName }</td>
					<td>${product.price }</td>
					<td>${product.description }</td>
					<td><a href="${pageContext.request.contextPath}/addToCart/${product.id}"><i class="glyphicon glyphicon-plus"></i></a>
					</td>
					</tr>
				</c:forEach>

			</tbody>
			</table>
</div>