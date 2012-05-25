<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><c:out value="Add Project" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>
		<c:out value="Add Project" />
	</h1>
	<form:form method="post" commandName="project">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td align="right" width="20%">Name:</td>
				<td width="20%"><form:input path="name" />
					<form:errors path="name" cssClass="error" /></td>
				<td align="right" width="20%">Max Number of People:</td>
				<td width="20%"><form:input path="maxPeople" />
					<form:errors path="maxPeople" cssClass="error" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" align="center" value="Execute">
	</form:form>
	<a href="<c:url value="hello.htm"/>">Home</a>
	<a href="<c:url value="adduser.htm"/>">Add Users</a>
	<a href="<c:url value="assignproject.htm"/>">Assign People to Projects</a>
</body>
</html>