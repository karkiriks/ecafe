<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>E-Cafe Home</title>
</head>
<body>
<h1>${message}</h1>

<div align="center">
<a href="login">Login</a> <a href="register">Register Now</a>
</div>
<hr><footer>The time on the server is ${serverTime}.</footer>
</body>
</html>