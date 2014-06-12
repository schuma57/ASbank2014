<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>IUT-AS-Groupe n°3</title>
	<link rel="stylesheet" type="text/css" href="../CSS/style.css">
</head>

<body>
	<h2>Creer Client</h2>
	
	<s:form name="myForm" action="controller.NewClientController.createClient.action"
		method="POST">
		<s:textfield label="Client number" name="clientNumber" />
		<s:textfield label="Last Name" name="lastname" />
		<s:textfield label="First Name" name="firstname" />
		<s:textfield label="Address" name="address" />
		<s:textfield label="Login" name="userCde" />
		<s:password label="Password" name="userPwd" />
		<label name="profile">Manager:</label>
		<input type="checkbox" name="profile" value="yes" />
		<s:submit name="submit" />
	</s:form>
</body>
</html>