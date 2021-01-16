<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container h-100">
      <table class="table">
        <thead class="bg-dark text-light">
          <th>First Name</th>
          <th>Last Name</th>
          <th>License #</th>
          <th>State</th>
          <th>Expire Date</th>
        </thead>
        <tbody>
          <c:forEach items="${persons}" var="person">
            <tr>
              <td><c:out value="${person.firstName}" /></td>
              <td><c:out value="${person.lastName}" /></td>
              <td><c:out value="${person.license.number}" /></td>
              <td><c:out value="${person.license.state}" /></td>
              <td><c:out value="${person.license.expirationDate}" /></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
