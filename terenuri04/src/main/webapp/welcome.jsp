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

	</head>
	<body>
		<jsp:directive.include file="headerLogout.html"/>

		<center>
			<h2>
				<s:text name="url.lista2" />
			</h2>
		</center>
	</body>
</jsp:root>