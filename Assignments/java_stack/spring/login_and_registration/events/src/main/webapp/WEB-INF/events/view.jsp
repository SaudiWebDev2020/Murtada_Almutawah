<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>View <c:out value="${event.name}" /></title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-4">
      <div class="row">
        <div class="col">
          <h1>Events</h1>
        </div>
        <div class="col">
          <a href="/logout" class="float-right btn btn-danger">Logout</a>
          <a href="/events" class="float-right btn btn-primary mx-3">Home</a>
        </div>
      </div>
      <div class="row">
        <h1 class="my-5"><c:out value="${event.name}" /></h1>
      </div>
      <div class="row p-3">
        <div class="col">
          <p class="mb-0">Host: <c:out value="${event.host.getFullName()}" /></p>
          <p class="mb-0">Date: <c:out value="${event.getDateFormatted()}" /></p>
          <p class="mb-0">Location: <c:out value="${event.location.getFullLocation()}" /></p>
          <p class="mb-0">People who are attending this event: <c:out value="${event.joining.size()}" /></p>

          <table class="table table-bordered table-striped mt-3">
            <thead>
              <th>Name</th>
              <th>Location</th>
            </thead>
            <tbody>
              <c:forEach items="${event.joining}" var="user">
                <tr>
                  <td><c:out value="${user.getFullName()}" /></td>
                  <td><c:out value="${user.location.city}" /></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="col">
          <h1>Message Wall</h1>
        </div>
      </div>
    </div>
  </body>
</html>
