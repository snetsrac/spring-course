<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Spring Security Demo</title>
</head>

<body>
  <h2>Spring Security Demo Home Page</h2>
  <p>Welcome to the home page!</p>
  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout" />
  </form:form>
</body>

</html>