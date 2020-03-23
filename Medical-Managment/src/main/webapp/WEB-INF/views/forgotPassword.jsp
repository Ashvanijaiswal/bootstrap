<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="lavender">
	<center>
		<h1>Forget Password</h1>
		
		<form:form method="post" modelAttribute="user">
			<table>
				<tr>
				<td colspan="2">${msg}</td>
				</tr>
				<tr>
					<td><form:label path="email_id">Enter your Email Address:</form:label></td>
					<td><form:input path="email_id" name="Email" id="email_id" /></td>
				</tr>
				<tr><td>OR</td></tr>
				<tr>
					<td><form:label path="contact_number">Enter your phone number:</form:label></td>
					<td><form:password path="contact_number" name="contact_number" id="contact_number" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" name="submit"></td>	
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>