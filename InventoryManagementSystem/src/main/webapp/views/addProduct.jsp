<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<p>${message }</p>
	<h3>All fields are Mandatory</h3>
	<form action="addProduct">
	
		<label for="productID">Product ID: </label>
		<input type="number" name="productID" value=0 />
		<br/><br/>
		<label for="productName">Product Name: </label>
		<input type="text" name="productName" />
		<br/><br/>
		<label for="productDescription">Product Description: </label>
		<input type="text" name="productDescription" />
		<br/><br/>
		<label for="price">Price: </label>
		<input type="number" name="price" value=0 />
		<br/><br/>
		<input type="submit" name="Add Product">
		
	</form>
	
	<br/><br/>
	<a href="/">Home</a>
	<br/><br/>
	<a class="button" href="viewProducts">View Products</a>

</body>
</html>