<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Page</title>
	<link rel="Stylesheet" type="text/css"
		  href="${pageContext.request.contextPath}/resources/css/login.css" />
	<script type="text/javascript">
		function doSubmit() {
			document.getElementById("username").value = document
					.getElementById("username").value.toUpperCase();
			return true;
		}
	</script>
</head>
<body onload='document.loginForm.username.focus();'>

<h1>Spring Security Login Form (Database Authentication) My Login</h1>

<div id="login-box">

	<h3>Login with Username and Password</h3>

	<form name='loginForm'
		  action="j_spring_security_check" method='POST'
		  onsubmit="return doSubmit()">

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' id="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' id="password" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
									   value="submit" /></td>
			</tr>
		</table>

		<input type="hidden" name="${_csrf.parameterName}"
			   value="${_csrf.token}" />

	</form>
</div>

</body>
</html>