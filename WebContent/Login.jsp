<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<head>
	<title>IUT-AS-Groupe n°3</title>
	<link rel="stylesheet" type="text/css" href="CSS/accueil.css">

	<script type="text/javascript">
		function DisplayMessage() {
			alert('Projet des AS Groupe 3, (Promotion 2013-2014)');
		}	
	</script>
</head>

<body>
<br>
<u><h1>Bienvenue</h1></u>
	<br>
	<input type="button" value="Information" name="info" onClick="DisplayMessage()" />
	<s:form name="myForm" action="controller.Connect.login.action"
		method="POST">
		<s:textfield label="Code user" name="usrCde" />
		<s:password label="Password" name="usrPwd" />		
		<s:submit name="submit" />
	</s:form>
</body>

</html>