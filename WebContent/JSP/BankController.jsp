<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<title>IUT-AS-Groupe n°3</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>
	


<body>
	<h2> Op&eacute;rations </h2>
	
	<table width="100%">
		<tr>
			Operation réalisée sur le compte N° <b><s:text name="accountNumber" /></b>
			Le solde du compte est maintenant de <s:text name="account.balance" />
		</tr>
	</table>
	
	<!-- Retour vers la page principal -->
	<s:form name="formBack" action="back" >
		<s:hidden name="client"></s:hidden>	
		<s:submit value="back" name="back" />
	</s:form>
</body>
</html>
