<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><c:out value="Add User" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>
		<c:out value="Add User"/>
	</h1>
	<form:form method="post" commandName="addUser">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td align="right" width="20%">Name:</td>
				<td width="20%"><form:input path="name" /><form:errors path="name" cssClass="error"/></td>
				<td align="right" width="20%">Email:</td>
				<td	width="20%"><form:input path="email"/><form:errors path="email" cssClass="error"/></td>
			</tr>
		</table>
		<br>
		<input type="submit" align="center" value="Execute">
	</form:form>
	<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>