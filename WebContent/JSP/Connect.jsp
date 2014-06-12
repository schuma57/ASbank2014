<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
	<title>IUT-AS-Groupe n°3</title>
	<link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all.css">
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	
	
	<SCRIPT type="text/javascript" src="extjs/ext-all.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="extjs/ext-all-debug.js"></SCRIPT>
	
	<!-- Exemple utilisation EXTJS -->
	<SCRIPT type="text/javascript">
	Ext.onReady(function() {
		Ext.QuickTips.init();
		Ext.MessageBox.alert("Welcome in the third Group Application. - ", "<s:text name='currentUser.firstName' /> <s:text name='currentUser.lastName' />" );
		// ICI ON INSERE TOUS OBJETS DE TYPE EXTJS 
	});
	</SCRIPT>

<table width="100%">
	<tr>
		<h2>Bonjour <s:text name="currentUser.firstname" /> <s:text name="currentUser.lastname" /></h2> 
	<br>
	<br>
		Vous êtes connecté à l'application bancaire AS-2014 (Numéro de client : <b><s:text name="currentUser.clientNumber" /></b> )
	<br>
	<br>
		<u>Voici la liste de vos comptes dans notre établissement :</u>
		<br>
		<br>
		<table width="50%" border="1">
			<td width="20%" bgcolor="gray">
				<b>Numéro de compte : </b>
			</td>
			<td width="30%" bgcolor="gray">
				<b>Solde : </b>
			</td>	
			<s:iterator id="account" value="accounts">
				<tr valign="top">
					<td width="20%">
						<s:text name="accountNumber" />
					</td>
					<td width="30%">
						<s:text name="balance" /> euro(s)
					</td>
	        	</tr>
        	</s:iterator>
        </table>
	<tr>
	<br>
	<br>
	<u>Pour effectuer une opération, merci d'indiquer le numéro de compte (valide) concerné :</u>
	<br>
	<br>
	<s:form name="formOperation" action="" >
		<s:hidden name="clientNumber"></s:hidden>
		<s:textfield label="Compte concerné" name="accountNumber" />	
		<s:textfield label="Montant" name="amount" />	
		<s:submit action="controller.BankController.depot" value="Dépôt" name="depot" />
		<s:submit action="controller.BankController.retrait" value="Retrait" name="retrait" />
	 </s:form>
</table>

</html>
