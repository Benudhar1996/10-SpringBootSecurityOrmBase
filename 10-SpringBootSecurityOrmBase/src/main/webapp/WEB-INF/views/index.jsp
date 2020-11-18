<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">WELCOME TO USER MANAGMENT</h1>

	<div align="center">
		<form:form modelAttribute="user" action="saved">
			<table>
				<tr>
					<td>NAME</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="userPassword" /></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><form:input path="userEmail" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><form:radiobutton path="userGender" value="MALE" />Male<form:radiobutton
							path="userGender" value="FEMALE" />FEMALE</td>
				</tr>
				<tr>
					<td>DATE OF BIRTH</td>
					<td><form:input path="userDateofBirth" type="date" /></td>
				</tr>
				<tr>
					<td>ROLSE</td>
					<td><form:checkbox path="roles" value="ADMIN" />&nbsp;ADMIN
						&nbsp;&nbsp;<form:checkbox path="roles" value="USER" />&nbsp;USER&nbsp;&nbsp;<form:checkbox
							path="roles" value="EMPLOYEE" />&nbsp;EMPLOYEE</td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="REGISTER"></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>