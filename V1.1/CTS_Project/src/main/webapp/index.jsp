<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value = "/UIResources/design.css"/>">
<title>
ThePharmaCompany
</title>
</head>

<body >

	<div id="upper">
	
	
	<div id="upperInner" ><a href="customerLoginPage" id="customer_login">Customer Login</a>
	<a href="adminLoginPage" id="admin_login">Admin Login</a>
	<a href="AboutUS" id="about_Us">About US</a></div>
	
	<div id="Hrule"></div>
	</div>
	
	
	<div id="middle">
	
	
	<div id="ThePharmaCompanyLogo">
	 <img src="<c:url value = "/UIResources/images/ThePharmaCompanyLogo.png"/>" style="width:100%;height: 100%;">
	
	</div>
	<div id="form">
	<form action="saveCustomer" method="post">
	<h3 id="formTitle">New Customer ?</h3>
	<table>
	<tr><td><input id = "entry" type="text"  name="customer_Name" placeholder="Full-Name" required="required">
	<tr><td><input id = "entry" type="text" name="customer_Phone" placeholder="Phone-Number" required="required">
	<tr><td><input id = "entry" type="password" name="customer_Password" minlength="6" maxlength="6"  placeholder="Password" required="required">
	<tr><td><textarea id = "entry" rows="7" cols="22" placeholder="Where to deliver..." required="required" name="customer_Address"></textarea>
	</table>
	<input id="submit" type="submit" value="submit">
	</form>
	</div>
	
	
	</div>
	
	
	<div id="lower" >
	
	
	</div>
	
	
	<div id = "background">
<img src="<c:url value = "/UIResources/images/indexBG.jpg"/>" style="width:100%;height: 100%;">
</div>
	
</body>

</html>

