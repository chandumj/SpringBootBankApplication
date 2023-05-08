<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body bgcolor="pink" style="text-align: center;">
<h1>SDFC Bank ExtraOrdinary Services</h1>
	<h2>New Account Registration Form</h2>
	<form:form method="POST" modelAttribute="account" action="/addaccount">
		<table align="center">
			<tr>
				<td>Account Number:</td>
				<td><form:input path="accno" /></td>

			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>

			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" /></td>

			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><form:input path="confirmpassword" /></td>

			</tr>
			<tr>
				<td>Amount:</td>
				<td><form:input path="amount" /></td>

			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>

			</tr>
			<tr>
				<td>Mobile No:</td>
				<td><form:input path="mobileno" /></td>

			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Add Account"></td>
			</tr>
			<tr>
		</table>
	</form:form>
</body>
</html>