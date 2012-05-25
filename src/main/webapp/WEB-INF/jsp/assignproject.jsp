<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><c:out value="Assign Project" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>
		<c:out value="Assign Project" />
	</h1>
	<form:form method="post" commandName="project_intern">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td align="right" width="20%">Project:</td>
				<td width="20%"><form:select  path="project"> 
				<form:options items="${projects}" itemValue="name"/>
				</form:select>
				</td>
				<td align="right" width="20%">Person:</td>
				<td width="20%"><form:select  path="intern"> 
				<form:options items="${interns}" itemValue="name"/>
				</form:select></td>
			</tr>
		</table>
		<br>
		<input type="submit" align="center" value="Execute">
	</form:form>
	<a href="<c:url value="hello.htm"/>">Home</a>
	<a href="<c:url value="adduser.htm"/>">Add Users</a>
	<a href="<c:url value="addproject.htm"/>">Add Project</a>
</body>
</html>