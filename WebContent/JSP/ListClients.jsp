<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<title>IUT-AS-Groupe n°3</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>

<body>
<table width="100%">
	<tr>
		<h2>Bonjour <s:text name="currentUser.firstname" /> <s:text name="currentUser.lastname" /></h2> 
	<br>
	<br>
		Vous &ecirc;tes connect&eacute; &agrave; l'application bancaire en tant que manager <u>AS-2014</u>.
	<br>
	<br>
		<u>Voici les clients de la banque et leurs comptes : </u>
		<table width="60%" border="1">
			<td width="10%" bgcolor="gray">
				<b>Prénom : </b>
			</td>
			<td width="10%" bgcolor="gray">
				<b> Nom : </b>
			</td>
			<td width="20%" bgcolor="gray">
				<b> Compte : </b>
			</td>
			<td width="20%" bgcolor="gray">
				<b> Balance : </b>
			</td>
			<!--  Parcours de la liste des clients -->
			<s:iterator var="client" value="clients" >
				<!-- Parcours de la liste des comptes du client -->
				<s:iterator var="account" value="accounts">  
					<!--  Attention dans le cadre d'une 'map' il faut refaire une itération (clé, valeur) -->
					<s:iterator value="value">
		                <tr valign="top">
		                    <td width="10%">
		                    	<s:property value="firstname"/>
		                    </td>
		                    <td width="10%">
		                    	<s:property value="lastname"/>
		                    </td>
		                    <td width="20%">
		                    	<s:property value="accountNumber"/>
		                    </td>
		                     <td width="20%">
		                    	<s:property value="balance"/> €
		                    </td>
		                </tr>
	                </s:iterator>
	            </s:iterator>
             </s:iterator>
        </table>
	<tr>
</table>
<a id="lien" href="JSP/NewClient.jsp">Creer nouveau client</a> <br/>
<a id="lien" href="JSP/NewAccount.jsp">Creer nouveau compte</a>
</body>
</html>

