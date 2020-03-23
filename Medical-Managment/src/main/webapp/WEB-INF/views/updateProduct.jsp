<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Update Product</h1>
	<form:form modelAttribute="product" method="post" action="/UpdateProductRedirectToAdd">
		<table>
			<tr>
				<td><form:label path="product_name">Product to Search</form:label></td>
				<td><form:select path="product_name" items="${products}"></form:select></td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" name="update" value="Update"></td>
			</tr>
		</table>
	</form:form>


</body>
</html>