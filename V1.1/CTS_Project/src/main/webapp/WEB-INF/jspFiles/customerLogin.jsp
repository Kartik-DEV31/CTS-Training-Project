<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value = "/UIResources/design.css"/>">
<title>CustomerLogin</title>
</head>
<body>


<div id="middle">
	<div id="ThePharmaCompanyLogo">
	 <img src="<c:url value = "/UIResources/images/ThePharmaCompanyLogo.png"/>" style="width:100%;height: 100%;">
	
	</div>
	
	
	<div></div>
	<div id="formCstLogin">
	<form action="customerLogin" method="post">
	<h3 id="formTitleCstLogin">Please Enter Your Credentials</h3>
	<c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
	
	<table>
	<tr><td><input id = "entryCstLogin" type="text"  name="customer_Name" placeholder="Customer-Name" required="required">
	
	<tr><td><input id = "entryCstLogin" type="password" name="customer_Password" minlength="6" maxlength="6"  placeholder="Customer-Password" required="required">
	</table>
	<input id="submitCstLogin" type="submit" value="submit">
	</form>
	</div>
	
	
	</div>
	
<div id = "background">
<img src="<c:url value = "/UIResources/images/indexBG.jpg"/>" style="width:100%;height: 100%;">
</div>	

</body>
</html>