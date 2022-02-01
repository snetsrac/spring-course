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
  <h2>Spring Security Demo Systems Conference</h2>

  <hr>

  <p>Something something systems conference for admin types.</p>

  <hr>

  <p>Username: <sec:authentication property="principal.username" /></p>
  <p>Role(s): <sec:authentication property="principal.authorities" /></p>

  <hr>

  <a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>

</html>
