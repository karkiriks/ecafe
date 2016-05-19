<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrators Portal</title>
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
<div>
<h2 class="text-center text-info">Administrator Portal</h2>
<h3>${message}</h3>
<div align="right">
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
		 <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input class="btn btn-primary" type="submit" value="Logout" />
		</form>
	</div>
<div>
<jsp:include page="adminpanel.jsp"/>
<jsp:include page="${page}"/>
</div>
</div>
</body>
</html>