<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="col-md-2 col-md-offset-1" style = "border-right:3px solid #bbb; min-height:auto">

	<div id="product" style = "border-bottom:3px solid lightblue"><h2><a href="<spring:url value='/admin/product'/>">Product</a></h2></div>
	<div id="order" style = "border-bottom:3px solid lightblue"><h2><a href="<spring:url value='/admin/order'/>">Order</a></h2></div>
</div>