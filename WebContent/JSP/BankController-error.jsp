<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<title>IUT-AS-Groupe n°3</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>

<body>
<h1>Erreur</h1>
<table width="100%">
	<tr>
		Operation non réalisée sur le compte N° <b><s:text name="accountNumber" /><b>
		<br><br>
		Veuillez contacter votre conseiller ... 
		<br><br>
		Raison de l'erreur <u>'<s:text name="bankMessage" />'</u>
	</tr>
</table>

<!-- Retour vers la page principal -->
<s:form name="formBack" action="back" >
	<s:hidden name="client"></s:hidden>	
	<s:submit value="back" name="back" />
</s:form>

</body>
</html>
