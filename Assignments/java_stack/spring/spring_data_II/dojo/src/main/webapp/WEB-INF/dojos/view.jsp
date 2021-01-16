<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>View Dojo <c:out value="${dojo.name}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-3">
      <h1 class="my-3"><c:out value="${dojo.name}" /> Location Ninjas</h1>
      <table class="table">
        <thead>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Age</th>
        </thead>
        <tbody>
          <c:forEach items="${dojo.ninjas}" var="ninja">
            <tr>
              <td><c:out value="${ninja.firstName}" /></td>
              <td><c:out value="${ninja.lastName}" /></td>
              <td><c:out value="${ninja.age}" /></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
