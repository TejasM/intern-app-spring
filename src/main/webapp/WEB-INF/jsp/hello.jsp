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
    <a href="<c:url value="adduser.htm"/>">Add Users</a>
    <br>
  </body>
</html>