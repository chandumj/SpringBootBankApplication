<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor="pink" style="text-align: center;">
<h1>SDFC Bank ExtraOrdinary Services</h1>
<table border="1px" align="center" cellpadding="10px" cellspacing="0">
<tr>
<th>ACCOUNT NO</th>
<th>USERNAME</th>
<th>AMOUNT</th>
<th>ADDRESS</th>
<th>PHONE</th>
</tr>
<tr>
<td>${database.accountNo}</td>
<td>${database.name}</td>
<td>${database.amount}</td>
<td>${database.address}</td>
<td>${database.mobileNo}</td>
</tr>

</table>
<a href="/">Back to Home</a>
</body>
</html>