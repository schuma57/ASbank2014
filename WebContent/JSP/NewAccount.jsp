<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>IUT-AS-Groupe n°3</title>
	<link rel="stylesheet" type="text/css" href="../CSS/style.css">
</head>

<body>
	<h2>Creer Compte</h2>
	
	<h3>A faire... Bientot </h3><br>
	
	<s:form name="myForm" action=""
		method="POST">
		<s:textfield label="Account number" name="accountNumber" />
		<s:textfield label="Account Name" name="accountName" />
		<s:textfield label="Client Number" name="clientNum" />
		<s:textfield label="Balance" name="balance" />
		<s:textfield label="Overdraft Authorised" name="overdraft" />
		
		<s:submit name="submit" />
	</s:form>
	
</body>
</html>