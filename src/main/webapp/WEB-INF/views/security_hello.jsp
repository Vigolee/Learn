<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	<sec:authorize access="hasRole('POWER')">
		<!-- For login user -->
		<form action="/security/logout" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

			<h2>
				<a href="admin">admin</a>
			</h2>
	</sec:authorize>

	<sec:authorize access="isAnonymous()">
		<br />
		<h2>
			<a href="login">login</a>
		</h2>
	</sec:authorize>

</body>
</html>