<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="col-md-9">
	<table class="table table-striped table-hover table-bordered datatable">
		<thead>
			<tr>
				<td>Order Id</td>
				<td>Date</td>
				<td>Quantity</td>
				<td>Total Amount</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${orderList }" var="order">
				<tr>
				<td>${order.id}</td>
				<td>${order.orderDate}</td>
				<td>${order.quantity}</td>
				<td>${order.totalAmount}</td>
 				<td><a class="glyphicon glyphicon-pencil" href="<spring:url value='/admin/order/edit/${order.id}'/>">Edit</a></td>
				<td><a class="glyphicon glyphicon-remove" href="<spring:url value='/admin/order/checkout/${order.id}'/>">Check-Out</a></td> 
			</tr>
			</c:forEach>
			
		</tbody>



	</table>
</div>