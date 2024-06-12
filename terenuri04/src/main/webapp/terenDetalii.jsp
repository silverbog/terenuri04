<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="headerImport.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Detalii Teren</title>
</head>

<body>
	<!-- Aduc datele din pagina de proprietati -->
	<s:set var="urlLista" value="%{getText('url.lista')}" />
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

	<jsp:directive.include file="headerLogout.html" />

	<c:choose>
		<c:when test="${teren.id != null && teren.id != 0}">
			<h1>Actualizare date teren</h1>
			<form action="updateTeren" method="post">
		</c:when>
		<c:otherwise>
			<h1>Adaugare teren</h1>
			<form action="insertTeren" method="post">
		</c:otherwise>
	</c:choose>



	<table style="width: 100%">
		<tr>
			<td style="width: 20%">ID</td>
			<td><c:out value='${teren.id}' /> <input type="hidden"
				name="teren.id" size="90" value='${teren.id}' /></td>
		</tr>

		<tr>
			<td>${titleNrCad}</td>
			<td><input type="text" name="teren.nrcadast" size="90"
				value='${teren.nrcadast}' /></td>
		</tr>
		<tr>
			<td>${titleNume}</td>
			<td><input type="text" name="teren.nume" size="90"
				value='${teren.nume}' /></td>
		</tr>
		<tr>
			<td>${titleStrada}</td>
			<td><input type="text" name="teren.str" size="90"
				value='${teren.str}' /></td>
		</tr>
		<tr>
			<td>${titleNumar}</td>
			<td><input type="text" name="teren.nr" size="90"
				value='${teren.nr}' /></td>
		</tr>
		<tr>
			<td>${titleTarla}</td>
			<td><input type="text" name="teren.tarla" size="90"
				value='${teren.tarla}' /></td>
		</tr>
		<tr>
			<td>${titleParcela}</td>
			<td><input type="text" name="teren.parcela" size="90"
				value='${teren.parcela}' /></td>
		</tr>
		<tr>
			<td>${titleData}</td>
			<td><input type="text" name="teren.data" size="90"
				value='${teren.data}' /></td>
		</tr>
		<tr>
			<td>${titleInreg}</td>
			<td><input type="text" name="teren.inrg" size="90"
				value='${teren.inrg}' /></td>
		</tr>
		<tr>
			<td>${titleExpert}</td>
			<td><input type="text" name="teren.ex" size="90"
				value='${teren.ex}' /></td>
		</tr>
		<tr>
			<td>${titleObiect}</td>
			<td><input type="text" name="teren.obj" size="90"
				value='${teren.obj}' /></td>
		</tr>
		<tr>
			<td>${titleCf}</td>
			<td><input type="text" name="teren.cf" size="90"
				value='${teren.cf}' /></td>
		</tr>
		<tr>
			<td>${titleDomeniu}</td>
			<td><input type="text" name="teren.dom_public" size="90"
				value='${teren.dom_public}' /></td>
		</tr>
		<tr>
			<td><h2>
					<s:text name="url.lista2" />
				</h2></td>
			<td><input type="submit" value="OK" /></td>

		</tr>

	</table>

	</form>

</body>
</html>