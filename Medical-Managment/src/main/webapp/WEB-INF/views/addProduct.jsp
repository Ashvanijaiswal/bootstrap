<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h1>
		<center>${message}</center>
	</h1>
	<center>
		<form:form method="post" modelAttribute="product" action="/${button}Product">

			<table>
				<tr>
					<td><sf:label path="product_name">Product Name:</sf:label></td>
					<td><sf:input path="product_name" id="product_name"/></td>
					<td><form:errors path="product_name" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="company_name">Company Name:</sf:label></td>
					<td><sf:input path="company_name" id="company_name" /></td>
					<td><form:errors path="company_name" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="product_price" />Product Price:</td>
					<td><sf:input path="product_price" id="product_price" /></td>
					<td><form:errors path="product_price" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="mfd_date" />Manufacture Date:</td>
					<td><sf:input path="mfd_date" id="mfd_date" /></td>
						<td><form:errors path="mfd_date" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="exp_date" />Expiry Date:</td>
					<td><sf:input path="exp_date" id="exp_date" /></td>
					<td><form:errors path="exp_date" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="quantity" />Quantity:</td>
					<td><sf:input path="quantity" id="quantity" /></td>
					<td><form:errors path="quantity" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="purchase_date" />Purchase Date:</td>
					<td><sf:input path="purchase_date" id="purchase_date" /></td>
					<td><form:errors path="purchase_date" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="product_type" />Product Type:</td>
					<td><sf:input path="product_type" id="product_type" /></td>
					<td><form:errors path="product_type" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><sf:label path="supplier_name" />Supplier List:</td>
					<td><sf:select path="supplier_name" id="supplier_name"
							items="${supplierList}" /></td>
					<td><form:errors path="supplier_name" cssStyle="color: #ff0000;"/></td>
				</tr>
				<tr>
					<td><input type="submit" id="submit" value="${button}"/></td>
					<td><input type="reset" id="reset" /></td>
				</tr>
			</table>
			${product}
		</form:form>
	</center>
	<br>
	<br>
	<br>
	<br>
	<h1>
		<center>Delete a Product</center>
	</h1>
	<center>
		<h2>
			<center>${delmessage}</center>
		</h2>

		<form:form method="post" action="/delProduct" modelAttribute="product">

			<table>
				<tr>
					<td>Select Product:</td>
					<td><form:select path="product_name" items="${products}" />
					<td>
				</tr>
				<tr>
					<td><input type="submit" id="submit" /></td>
				</tr>
			</table>

		</form:form>


	</center>
</body>
</html>