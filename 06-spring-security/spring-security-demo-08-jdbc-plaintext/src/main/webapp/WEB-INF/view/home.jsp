<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Spring Security Demo</title>
</head>

<body>
  <h2>Spring Security Demo Home Page</h2>

  <hr>

  <p>Welcome to the home page!</p>

  <hr>

  <p>Username: <sec:authentication property="principal.username" /></p>
  <p>Role(s): <sec:authentication property="principal.authorities" /></p>

  <hr>

  <sec:authorize access="hasRole('ROLE_MANAGER')">
    <p><a href="${pageContext.request.contextPath}/leaders">Click here</a> to learn about the leadership retreat.</p>

    <hr>
  </sec:authorize>

  <sec:authorize access="hasRole('ROLE_ADMIN')">
    <p><a href="${pageContext.request.contextPath}/systems">Click here</a> to learn about the systems conference.</p>

    <hr>
  </sec:authorize>

  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout" />
  </form:form>
</body>

</html>
