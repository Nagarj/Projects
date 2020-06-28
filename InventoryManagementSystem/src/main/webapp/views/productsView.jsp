<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<p>${message }</p>
	<table>
		<thead>
			<tr>
				<td>Product ID</td>
				<td>Product Name</td>
				<td>Product Description</td>
				<td>Price</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${products}">
				<tr>
					<td><c:out value="${product.productID }" /></td>
					<td><c:out value="${product.productName }" /></td>
					<td><c:out value="${product.productDescription }" /></td>
					<td><c:out value="${product.price }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a class="button" href="/">Home</a>

</body>
</html>