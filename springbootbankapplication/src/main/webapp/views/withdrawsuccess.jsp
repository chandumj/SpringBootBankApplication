<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor="pink" style="text-align: center;">
	<h1>SDFC Bank ExtraOrdinary Services</h1>
	<table align="center" >
		<tr>
			<td>Amount Before Withdraw:</td>
			<td>${oldamount}</td>

		</tr>
		<tr>
			<td>Withdraw Amount:</td>
			<td>${newamount}</td>

		</tr>
		<tr>
			<td>Amount after Withdraw:</td>
			<td>${database.amount}</td>

		</tr>

	</table><br><br>
	<a href="/">Back to Home</a>
</body>
</html>