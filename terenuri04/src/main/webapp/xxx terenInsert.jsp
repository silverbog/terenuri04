<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.lang.*"%>
<%@ page import="javax.servlet.jsp.jstl.*"%>
<%@ page import="terenuri3.Teren" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>Detalii Teren</title>
</head>
<body>

<%-- 
Aceasta pagina poate/trebuie folosita pentru:
Create:	actiune de tip INSERT, nu se furnizeaza ID /teren==null
--%>	
<s:set var="urlLista" value="%{getText('url.lista')}"/>
<jsp:directive.include file="headerLogout.html"/>

	<h1>Adaugare teren nou</h1>

<!--form action="insertTeren"-->
<form action="insertTeren">
		<table style="width:100%">

			<tr>
				<td style="width:20%">ID</td>
				<td><c:out value='${teren.id}' />
				<!-- input type="hidden" name="teren.id" size="90" value='${teren.id}' /--></td>
			</tr>

			<tr>
				<td>Nr. Cadastral</td>
				<td><input type="text" name="teren.nrcadast" size="90" value='${teren.nrcadast}' /></td>
			</tr>
			<tr>
				<td>Nume</td>
				<td><input type="text" name="teren.nume" size="90" value='${teren.nume}' /></td>
			</tr>
			<tr>
				<td>Strada</td>
				<td><input type="text" name="teren.str" size="90" value='${teren.str}' /></td>
			</tr>
			<tr>
				<td>Nr.</td>
				<td><input type="text" name="teren.nr" size="90" value='${teren.nr}' /></td>
			</tr>
			<tr>
				<td>Tarla</td>
				<td><input type="text" name="teren.tarla" size="90" value='${teren.tarla}' /></td>
			</tr>
			<tr>
				<td>Parcela</td>
				<td><input type="text" name="teren.parcela" size="90" value='${teren.parcela}' /></td>
			</tr>
			<tr>
				<td>Data</td>
				<td><input type="text" name="teren.data" size="90" value='${teren.data}' /></td>
			</tr>
			<tr>
				<td>Inreg.</td>
				<td><input type="text" name="teren.inrg" size="90" value='${teren.inrg}' /></td>
			</tr>
			<tr>
				<td>Expert</td>
				<td><input type="text" name="teren.ex" size="90" value='${teren.ex}' /></td>
			</tr>
			<tr>
				<td>Obiect</td>
				<td><input type="text" name="teren.obj" size="90" value='${teren.obj}' /></td>
			</tr>
			<tr>
				<td>C.F.</td>
				<td><input type="text" name="teren.cf" size="90" value='${teren.cf}' /></td>
			</tr>
			<tr>
				<td>Domeniu Public</td>
				<td><input type="text" name="teren.dom_public" size="90" 	value='${teren.dom_public}' /></td>
			</tr>
			<tr>
				<td><h2><s:text name="url.lista2"/></h2></td>				
				<td><input type="submit" value="OK" /></td>
			</tr>

		</table>

		
	</form>
	

</body>
</html>