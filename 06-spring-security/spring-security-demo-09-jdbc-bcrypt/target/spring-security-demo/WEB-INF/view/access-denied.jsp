<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Spring Security Demo Access Denied</title>
</head>

<body>
  <h2>Access Denied</h2>

  <hr>

  <p>You do not have the appropriate permissions to access this page.</p>

  <hr>

  <p>Username: <sec:authentication property="principal.username" /></p>
  <p>Role(s): <sec:authentication property="principal.authorities" /></p>

  <hr>

  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout" />
  </form:form>

  <hr>

  <a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>

</html>
