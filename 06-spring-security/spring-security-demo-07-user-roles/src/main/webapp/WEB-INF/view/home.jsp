<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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

  <p>Username: <security:authentication property="principal.username" /></p>
  <p>Role(s): <security:authentication property="principal.authorities" /></p>

  <hr>

  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout" />
  </form:form>
</body>

</html>