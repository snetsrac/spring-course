<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Confirmation</title>
  </head>
  <body>
    <p>The student is confirmed: ${student.firstName} ${student.lastName}</p>
    <p>Country: ${student.country}</p>
    <p>Favorite Language: ${student.favoriteLanguage}</p>
    <p>Operating Systems: <c:forEach var="temp" varStatus="status" items="${student.operatingSystems}">
      ${temp}<c:if test="${!status.isLast()}">, </c:if>
    </c:forEach></p>
  </body>
</html>
