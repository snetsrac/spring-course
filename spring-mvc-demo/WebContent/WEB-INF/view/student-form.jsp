<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
  </head>
  <body>
    <form:form action="processForm" modelAttribute="student">
      First Name: <form:input path="firstName" />
      
      <br><br>

      Last Name: <form:input path="lastName" />
      
      <br><br>

      Country:
      <form:select path="country">
        <form:options items="${countryOptions}" required="true" />
      </form:select>
      
      <br><br>
      
      Java <form:radiobutton path="favoriteLanguage" value="Java" />
      C# <form:radiobutton path="favoriteLanguage" value="C#" />
      C++ <form:radiobutton path="favoriteLanguage" value="C++" />
      Rust <form:radiobutton path="favoriteLanguage" value="Rust" />
      
      <br><br>
      
      Linux <form:checkbox path="operatingSystems" value="Linux" />
      Mac OS<form:checkbox path="operatingSystems" value="Mac OS" />
      Microsoft Windows<form:checkbox path="operatingSystems" value="Microsoft Windows" />

      <br><br>

      <button>Submit</button>
    </form:form>
  </body>
</html>
