<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="lavender">
	<center>
		<h1>Login</h1>
		
		<form:form modelAttribute="user" method="post">
			<table>
				<tr>
				<td colspan="3">${error}</td>
				</tr>
				<tr>
					<td><form:label path="user_id">UserName:</form:label></td>
					<td><form:input path="user_id" name="user_id" id="user_id" /></td>
					<td>${userIdError}</td>
				</tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:password path="password" name="password" id="password" /></td>
					<td>${passwordError}</td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" name="submit"></td>
					
				</tr>
				<tr>
				<td>
				<a href="/forgot">Forget paasword</a></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>