<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Registration Form</title>
    <style>
      .error {
        color: red;
      }
    </style>
  </head>
  <body>
    <i>Please fill out the form. Asterisk (*) means required.</i>

    <br><br>

    <form:form action="processForm" modelAttribute="customer">
      First Name: <form:input path="firstName" />
      
      <br><br>

      Last Name (*): <form:input path="lastName" />
      <form:errors path="lastName" cssClass="error" />

      <br><br>

      Free Passes: <form:input path="freePasses" />
      <form:errors path="freePasses" cssClass="error" />

      <br><br>

      Postal code: <form:input path="postalCode" />
      <form:errors path="postalCode" cssClass="error" />

      <br><br>
      
      Course code: <form:input path="courseCode" />
      <form:errors path="courseCode" cssClass="error" />

      <br><br>

      <button>Submit</button>
    </form:form>
  </body>
</html>
