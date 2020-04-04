<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value = "/UIResources/databaseDisplay.css"/>">
	
   
</head>
<body>


 
	<div id="logout">

	<a href="adminLogout" id="admin_logout">Logout</a>
	
</div>

<div id="ThePharmaCompanyLogoShopping">
	 <img src="<c:url value = "/UIResources/images/ThePharmaCompanyLogo.png"/>" style="width:100%;height: 100%;">
	
	</div>	

<h1>Products List</h1>
<div id="table">
<table border="1"  style="background-color: whitesmoke ;">

 <col width="100">
 <col width="100">
 <col width="100">
 <col width="100">
 <col width="100">
 <col width="100">
  
	
	<c:forEach var="p" items="${Products}">
	<tr>
	<td>${p.product_ID} </td>
	<td>${p.product_Name} </td>
	<td>${p.product_Cost} </td>
	<td><img src=${ p.product_Picture} width="100" height="100"/></td>
	<td><a href="deleteProduct/${p.product_ID}">remove</a></td>
	<td>
	<form action="updateProduct/${p.product_Name}" method="post"><p>
	Price :			<input type="text" name="PriceUpdate"/><br>
	
				<input id="button" type="submit" name="submit" value="Update"></p>
	 </form>
	</td>
	</tr>
	
	</c:forEach>
	<tr>
	
	<td>
	<form action="addProduct" method="get">
	<input type="text" name="product_Name" placeholder="P-name"/>
	<input type="text" name="product_Cost" placeholder="Cost"/>
	<input type="text" name="product_Picture" placeholder="Picture Source"/>
	<input type="submit" name="submit" value="ADD Product"/>
	</form>
	</td>
	</tr>
</table>
</div>

<div id = "background">
<img src="<c:url value = "/UIResources/images/DatabaseDisplay.jpg"/>" style="width:100%;height: 100%;">
</div>
</body>
</html>

