<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Maintenance</title>
</head>
<body>
	<h1>
		<center>Stock Maintenance</center>
	</h1>
	<center>
		<form:form method="get" modelAttribute="product" action="/stockMaintenanceAdd">
			<table>
				<tr>
					<td><form:select path="product_name" items="${products}" id="product_name" /></td>
					<td><form:input path="quantity" id="quantity"/></td>
					<td><input type="submit" name="add" id="add" value="add"></td>
					<td><input type="submit" name="delete" id="delete" value="delete"></td>
					<td>${update}</td>
				</tr>
			</table>

		</form:form>
	</center>
</body>
</html>