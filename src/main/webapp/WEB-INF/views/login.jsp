<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
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

	<div class="col-md-4 col-md-offset-4">
				<form:form method="post" modelAttribute="loginForm" action="login">
					<div class="form-group">
						<label class="control-label" for="">Username</label>
						<form:input path="username" class="form-control" type="text"
							placeholder="Enter Username" />
					</div>
					<div class="form-group">
						<label class="control-label" for="">Password</label>
						<form:input path="password" type="password" class="form-control"
							placeholder="Enter password" />
					</div>
					<button type="submit" class="btn btn-primary pull-right">Sign-In</button>
					</form:form>
					</div>

</body>
</html>