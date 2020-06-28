<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" class="button" href="css/style.css">
<head>
<meta charset="ISO-8859-1">
<title>IMS</title>
</head>
<body>
	<h4>Inventory Management System</h4>
	<p>${message }</p>
	
	<div>
		<a class="button" href="viewProducts">View Products</a>
	</div>
	<br/>
	<div>
		<a class="button" href="addProductPage">Add a Product</a>
	</div>
	<br/>
	<div>
		<a class="button" href="deleteProductPage">Delete Product</a>
	</div>
	<br/>
	<div>
		<a class="button" href="addReport">Product Added Report</a>
	</div>
	<br/>
	<div>
		<a class="button" href="deleteReport">Product Deleted Report</a>
	</div>
	
</body>
</html>