<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <title>List Customers</title>
  </head>
  <body>
    <div id="wrapper">
      <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
      </div>
    </div>
    <div id="container">
      <div id="content">
        
        <!-- add button to navigate to add customer form -->

        <a href="${pageContext.request.contextPath}/customer/showForm">
          <button class="add-button">
            Add Customer
          </button>
        </a>

        <!-- add customer table -->

        <table>
          <thead>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="customer" items="${customers}">
              <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>

      </div>
    </div>
  </body>
</html>
