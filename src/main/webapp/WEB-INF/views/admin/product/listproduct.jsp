<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="col-md-9">
	<a class="btn btn-primary glyphicon glyphicon-plus"
		href="<spring:url value='/admin/product/add'/>">Add Product</a>
	<table class="table table-striped table-hover table-bordered datatable">
		<thead>
			<tr>
				<td>Name</td>
				<td>Price</td>
				<td>Description</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${proList }" var="pro">
				<tr>
					<td>${pro.productName }</td>
					<td>${pro.price }</td>
					<td>${pro.description }</td>
					<td><a class="glyphicon glyphicon-pencil" href="<spring:url value='/admin/product/edit/${pro.id}'/>">Edit</a></td>
				<td><a class="glyphicon glyphicon-remove" href="<spring:url value='/admin/product/delete/${pro.id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
			
		</tbody>



	</table>
</div>