<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body style="background-color: lavender">
	<h1>
		<center>User Registration</center>
	</h1>
	<center>
		<form:form modelAttribute="user" method = "post">
			<div>${status}</div>
			<table>
				<tr>
					<td><sf:label path="user_id">USER ID</sf:label></td>
					<td><sf:input path="user_id" id="user_id" /></td>
					<td><form:errors path="user_id" cssStyle="color: #ff0000;"/></td>
				</tr>

				<tr>
					<td><sf:label path="user_name">Name:</sf:label></td>
					<td><sf:input path="user_name" id="user_name" /></td>
					<td><form:errors path="user_name" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="email_id">Email ID</sf:label></td>
					<td><sf:input path="email_id" id="email_id" /></td>
					<td><form:errors path="email_id" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="contact_number">Contact NO</sf:label></td>
					<td><sf:input path="contact_number" id="contact_number" /></td>
					<td><form:errors path="contact_number" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="password">Password</sf:label></td>
					<td><sf:input path="password" id="password" /></td>
					<td><form:errors path="password" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit" id="submit"
						name="submit"></td>
					<td><input type="reset" value="clear" id="clear" name="clear"></td>
				</tr>
			</table>

		</form:form>
	</center>


</body>
</html>
