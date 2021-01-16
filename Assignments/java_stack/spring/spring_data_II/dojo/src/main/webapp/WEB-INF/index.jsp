<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Dojo App</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-2">
      <h1>Information</h1>
      <div class="row">
        <a class="m-2" href="/dojos/new">Create a Dojo</a>
        <a class="m-2" href="/ninjas/new">Create a Ninja</a>
      </div>
      <table class="table">
        <thead>
          <th>Dojo Name</th>
          <th>Ninja Count</th>
        </thead>
        <tbody>
          <c:forEach items="${dojos}" var="dojo">
            <tr>
              <td>
                <a href="/dojos/${dojo.id}"><c:out value="${dojo.name}" /></a>
              </td>
              <td><c:out value="${dojo.ninjas.size()}" /> ninjas</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
