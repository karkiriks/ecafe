
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Customer Registration Portal</title>
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
		<div class="col-md-12">
			<h1 class="text-center text-info">Registration
				Form</h1>
			<div class="col-md-6 col-md-offset-3">
				<form:form method="post" modelAttribute="registrationForm"
					action="register">
					<div class="form-group">
						<label class="control-label" for="">Username</label>
						<form:input path="username" class="form-control" type="text"
							placeholder="Choose username" />
					</div>
					<div class="form-group">
						<label class="control-label" for="">Password</label>
						<form:input path="password" type="password" class="form-control"
							placeholder="Enter password" />
					</div>
					<div class="form-group">
					<label class="control-label" for="">First Name</label>
					<form:input path="firstName" type="text" class="form-control" placeholder="First Name" />
					</div>
					<div class="form-group">
					<label class="control-label" for="">Last Name</label>
					<form:input path="lastName" type="text" class="form-control" placeholder="Last Name" />
					</div>
					<div class="form-group">
					<label class="control-label" for="">Email</label>
					<form:input path="email" type="text" class="form-control" placeholder="Email" />
					</div>
					<div class="form-group">
					<label class="control-label" for="">Phone</label>
					<form:input path="phone" type="text" class="form-control" placeholder="Phone No." />
					</div>
					<div class="form-group">
					<label class="control-label" for="">City</label>
					<form:input path="address.city" type="text" class="form-control" placeholder="City" />
					</div>
					<div class="form-group">
					<label class="control-label" for="">State</label>
					<form:input path="address.state" type="text" class="form-control" placeholder="State" />
					</div>
					<div class="form-group">
					<label class="control-label" for="">Country</label>
					<form:input path="address.country" type="text" class="form-control" placeholder="Country" />
					</div>
					<div class="form-group">
					<label class="control-label" for="">Zip Code</label>
					<form:input path="address.zipcode" type="text" class="form-control" placeholder="Zipcode" />
					</div>
					<form:select path="role" hidden="true">
						<form:option value="ROLE_CUSTOMER" label="" />
						<form:options items="${roles}" />
					</form:select>
					<form:select path="enable" hidden="true">
						<form:option value="1" label="" />
						<form:options items="${enable}" />
					</form:select>
					<button type="submit" class="btn btn-primary pull-right">Register</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>