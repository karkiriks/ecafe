<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9">

<h2>Cart</h2>

		<table class="table table-striped table-hover table-bordered datatable">
			<thead>
				<tr>
					<td>Product Name</td>
					<td>Price</td>
					<td>Quantity</td>
					<td>Subtotal</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ct" items="${cart}">
					<tr>
					<td>${ct.product.productName }</td>
					<td>${ct.price }</td>
					<td>${ct.quantity }</td>
					<td>${ct.subtotal }</td>				
					<td><a href="${pageContext.request.contextPath}/orderline/remove/${ct.product.id}"><i class="glyphicon glyphicon-remove"></i></a>
					</td>
					</tr>
				</c:forEach>
				
			</tbody>
			</table>
			
			<div  style="color:red; font-size:large; length:30px; text-align: center;font-style:normal;" >
				${saveError}
			</div>
			<br>
			<div  class="text-center text-info" style="color:blue;, font-size:xx-large, length:30px" >
				 Order Total  ${orderTotal}
			</div>
			<br>
			<div  class="text-center text-info" style="color:red;, font-size:xx-large, length:30px" >
				 <a href="${pageContext.request.contextPath}/saveorder"> Checkout 
			</div>
			
			
			

			

			
			 
</div>