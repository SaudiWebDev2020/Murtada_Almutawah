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

      <div class="row d-block">
        <h2 class="col-12 my-3">Edit an Event</h2>
        <div class="col-6">
          <form:form action="/events/${event.id}/edit" method="post" modelAttribute="eventForm">
            <div class="form-group">
              <label>Name:</label>
              <form:input path="name" class="form-control" value="${event.name}"/>
              <form:errors path="name" class="text-danger" />
            </div>
            <div class="form-group">
              <label>Date:</label>
              <form:input type="date" path="date" class="form-control" value="${event.getDateFormFormatted()}"/>
              <form:errors path="date" class="text-danger" />
            </div>
            <div class="form-group">
              <label>Location:</label>
              <div class="row">
                <div class="col">
                  <form:input path="city" class="form-control" value="${event.location.city}"/>
                  <form:errors path="city" class="text-danger" />
                </div>
                <div class="col">
                  <form:select path="state" class="form-control" value="${event.location.state.name}">
                    <c:forEach items="${states}" var="s">
                      <form:option value="${s}" label="${s.name}" />
                    </c:forEach>
                  </form:select>
                  <form:errors path="state" class="text-danger" />
                </div>
              </div>
            </div>
            <input type="submit" value="Edit" class="btn btn-primary" />
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
