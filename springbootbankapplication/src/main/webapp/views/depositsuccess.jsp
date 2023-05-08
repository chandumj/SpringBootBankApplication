<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor="pink" style="text-align: center;">
	<h1>SDFC Bank ExtraOrdinary Services</h1>
	<table align="center" >
		<tr>
			<td>Amount Before Deposit:</td>
			<td>${oldamount}</td>

		</tr>
		<tr>
			<td>Deposited Amount:</td>
			<td>${newamount}</td>

		</tr>
		<tr>
			<td>Amount after Deposit:</td>
			<td>${database.amount}</td>

		</tr>

	</table>
	<a href="/">Back to Home</a>
</body>
</html>