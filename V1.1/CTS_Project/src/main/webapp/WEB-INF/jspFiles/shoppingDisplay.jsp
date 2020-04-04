<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value = "/UIResources/design.css"/>">
<title>Shopping</title>
</head>

<body>
<div id="upperShopping">
	
	
	<div id="upperInnerShopping" >
	<a href="customerLogout" id="admin_login">Logout</a>
	<a href="AboutUS" id="about_Us">About US</a></div>
	
	
	</div>



<div id ="session">Welcome ${sessionScope.customer_Name}</div>	
	
<div id="ThePharmaCompanyLogoShopping">
	 <img src="<c:url value = "/UIResources/images/ThePharmaCompanyLogo.png"/>" style="width:100%;height: 100%;">
	
	</div>	
	<c:forEach var="p" items="${Products}">
	<div class="container">
		
		<img src=${ p.product_Picture } width="10" height="10"/>
	<p class="title">MRP : Rs.${p.product_Cost}/pc</p>
  <div class="overlay"></div>
  <div class="button"><a href="addCart"> Add to Cart </a></div>
  
</div>
</c:forEach>
<div id="icon"><a href="cart"><img src="https://img.icons8.com/dusk/50/000000/shopping-cart.png" width="100%" height="100%"/></a> </div>
<a href="https://icons8.com/icon/42852/shopping-cart">Shopping Cart icon by Icons8</a>

<div id = "background">
<img src="<c:url value = "/UIResources/images/shoppingBG.jpg"/>" style="width:100%;height: 100%;">
</div>
</body>
</html>