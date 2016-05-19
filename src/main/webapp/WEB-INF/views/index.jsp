
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>MUM E-Cafe</title>
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
	<div class="col-md-8 col-md-offset-3"><h1>MUM eCafe - Your own online foodstore</h1>
	<h3>${message}</h3>
	<hr>
	<div class="col-md-6 col-md-offset-3">
	<a href="login" class="btn btn-primary btn-lg active text-center" role="button">Login</a>
	<a href="register" class="btn btn-primary btn-lg active text-center" role="button">Register</a>
	<hr>
	</div>
	</div>
</body>
</html>