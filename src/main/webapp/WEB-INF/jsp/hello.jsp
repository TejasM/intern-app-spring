<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><c:out value="Hello!"/></h1>
    <h3>Interns</h3>
    <pre>  <font size="4">  Name         Email</font></pre>

    <c:forEach items="${interns}" var="prod">
      <c:out value="${prod.name}"/> <i> <c:out value="${prod.email}"/></i><br><br>
    </c:forEach>
    <br>
    <h3>Projects</h3>
    <pre>  <font size="4">  Name     People</font></pre>
    <c:forEach items="${projects}" var="proj">
      <c:out value="${proj.name}"/> <c:forEach items="${proj.internsOnProject}" var="intern"> <i> <c:out value="${intern.name}"/></i><br></c:forEach><br>
    </c:forEach>
    <br>
    <a href="<c:url value="adduser.htm"/>">Add Users</a>
    <a href="<c:url value="addproject.htm"/>">Add Projects</a>
    <a href="<c:url value="assignproject.htm"/>">Assign People to Projects</a>
    <br>
  </body>
</html>