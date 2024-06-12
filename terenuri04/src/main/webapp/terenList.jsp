<jsp:root version="2.0" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:display="urn:jsptld:http://displaytag.sf.net"
	xmlns:s="/struts-tags" xmlns:c="http://java.sun.com/jsp/jstl/core">

	<jsp:directive.page language="java" />
	<jsp:directive.page import="terenuri3.TerenDAO" />
	<jsp:directive.page contentType="text/html; charset=UTF8" />
	<jsp:directive.page import="java.lang.*" />
	<jsp:directive.page import="java.sql.*" />
	<jsp:directive.page import="org.apache.commons.beanutils.*" />
	<jsp:directive.page import="terenuri3.Constante" />
	<jsp:directive.page import="org.displaytag.*" />

	


	<jsp:text>
		<![CDATA[<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[<html xmlns="http://www.w3.org/1999/xhtml" lang="en">]]>
	</jsp:text>

	<head>
<title name="eticheta.AppTitle"><s:text name="eticheta.AppTitle" /></title>


<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<style type="text/css" media="all">
@import url("css/maven-base.css");

@import url("css/maven-theme.css");

@import url("css/site.css");

@import url("css/screen.css");
</style>

<link rel="stylesheet" href="./css/print.css" type="text/css"
	media="print" />

<script language="javascript">
	function customReset() {
		//Sterg continut campuri de cautare in mod explicit
		//Simplul control input type="reset" ... nu functioneaza odata ce a fost facut Submit
		//window.alert("Execut JS");
		document.getElementById("nrcadastCaut").value = "";
		document.getElementById("numeCaut").value = "";
		document.getElementById("strCaut").value = "";
		document.getElementById("nrCaut").value = "";
		document.getElementById("tarlaCaut").value = "";
		document.getElementById("parcelaCaut").value = "";
	}
</script>
	</head>
	<body>
<jsp:directive.include file="headerLogout.html"/>
	<s:text name="atentionare.max200" />

	<form action="lista" method="GET">
		<table name="t_cautare" style="width: 95%">
			<tr>
				<td><p>	<s:text name="label.cautare" />	</p></td>
			</tr>

			<tr>
				<!-- Linia care afisaza etichete. 
				Ia valorile din fisierul ApplicationResources.properties care trbuie plasat in package root -->
				<td><s:text name="label.nrcad" /></td>
				<td><s:text name="label.nume" /></td>
				<td><s:text name="label.strada" /></td>
				<td><s:text name="label.numar" /></td>
				<td><s:text name="label.tarla" /></td>
				<td><s:text name="label.parcela" /></td>
			</tr>
			<tr>
				<!-- Aceasta parte afisaza input de tip text care prin Bean Form se transmit la Action -->
				<td><input type="text" name="caut.nrcadast" id="nrcadastCaut" value="${caut.nrcadast}" /></td>
				<td><input type="text" name="caut.nume" id="numeCaut" value="${caut.nume}" /></td>
				<td><input type="text" name="caut.str" id="strCaut" value="${caut.str}" /></td>
				<td><input type="text" name="caut.nr" id="nrCaut" value="${caut.nr}" /></td>
				<td><input type="text" name="caut.tarla" id="tarlaCaut" value="${caut.tarla}" /></td>
				<td><input type="text" name="caut.parcela" id="parcelaCaut"
					value="${caut.parcela}" /></td>
			</tr>


			<tr>
				<td>
					<input type="submit" value="Cautare" />
					<input 	type="button" name="reset" value="Reset" id="reset123" onclick="customReset();" />	
				</td>
				<td><s:checkbox label ="Cautare exacta" name="cautareExacta" id="cautareExacta" /></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>

	<form action="detaliiInsert" method="GET">
		<!-- Form pentru declansare operatie de adaugare -->
		<input type="submit" value="Adaugare teren"  style="float: left;" />
	</form>	<br/><br/>

	<!-- Aduc datele din pagina de proprietati, sunt necesare pentru transmiterea in en-tete de la coloanele displaytag table-->
	<s:set var="titleNrCad" value="%{getText('label.nrcad')}" />
	<s:set var="titleNume" value="%{getText('label.nume')}" />
	<s:set var="titleStrada" value="%{getText('label.strada')}" />
	<s:set var="titleNumar" value="%{getText('label.numar')}" />
	<s:set var="titleTarla" value="%{getText('label.tarla')}" />
	<s:set var="titleParcela" value="%{getText('label.parcela')}" />
	<s:set var="titleData" value="%{getText('label.data')}" />
	<s:set var="titleInreg" value="%{getText('label.inreg')}" />
	<s:set var="titleObiect" value="%{getText('label.obiect')}" />
	<s:set var="titleCf" value="%{getText('label.cf')}" />
	<s:set var="titleDomeniu" value="%{getText('label.domeniu')}" />
	<s:set var="titleExpert" value="%{getText('label.expert')}" />
	<s:set var="titleSterge" value="%{getText('label.sterge')}" />


	<display:table id="TTerenuri" name="requestScope.listaTerenuri.rows"
		export="true" pagesize="5" style="width:95%"
		requestURI="${myActionName}">

		<display:column title="Nr. Crt." sortable="true"
			headerClass="sortable">
			<c:out value="${TTerenuri_rowNum}" />
		</display:column>

		<display:column property="Id" title="ID" sortable="true"
			headerClass="sortable" href="detaliiAction" paramId="id" />

		<display:column property="nrcadast" title="${titleNrCad}"
			sortable="true" headerClass="sortable" />
		<display:column property="nume" title="${titleNume}" sortable="true"
			headerClass="sortable" />
		<display:column property="str" title="${titleStrada}" sortable="true"
			headerClass="sortable" />
		<display:column property="nr" title="${titleNumar}" sortable="true"
			headerClass="sortable" />
		<display:column property="tarla" title="${titleTarla}" sortable="true"
			headerClass="sortable" />
		<display:column property="parcela" title="${titleParcela}"
			sortable="true" headerClass="sortable" />
		<display:column property="data" title="${titleData}" sortable="true"
			headerClass="sortable"  />
		<display:column property="inrg" title="${titleInreg}" sortable="true"
			headerClass="sortable" />
		<display:column property="obiect" title="${titleObiect}"
			sortable="true" headerClass="sortable" />
		<display:column property="cf" title="${titleCf}" sortable="true"
			headerClass="sortable" />
		<display:column property="dom_public" title="${titleDomeniu}"
			sortable="true" headerClass="sortable" />

		<display:column property="Id" title="${titleSterge}" sortable="false"
			headerClass="sortable" href="deleteTeren" paramId="id" />

	</display:table>

</body>


</jsp:root>
