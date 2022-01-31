<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Spring Security Demo Login</title>
</head>

<body>
  <h2>Spring Security Demo Login Page</h2>
  <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">

    <!-- Check for login error -->
    <c:if test="${param.error != null}">
      <i style="color: red;">Invalid username/password.</i>
    </c:if>

    <p>Username: <input type="text" name="username" /></p>
    <p>Password: <input type="password" name="password" /></p>
    <input type="submit" value="Login" />
  </form:form>
</body>

</html>