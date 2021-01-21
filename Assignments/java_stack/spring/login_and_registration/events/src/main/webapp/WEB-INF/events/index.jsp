<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Events app</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container my-4">
      <div class="row">
        <div class="col">
          <h1>Events</h1>
        </div>
        <div class="col">
          <a href="/logout" class="float-right btn btn-danger">Logout</a>
        </div>
      </div>
      <div class="row">
        <p>Here are some of the events in your states:</p>
        <table class="table table-bordered table-striped mt-3">
          <thead>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>Host</th>
            <th>Action/Status</th>
          </thead>
          <tbody>
            <c:forEach items="${inStateEvents}" var="event">
              <tr>
                <td>
                  <a href="/events/${event.id}"><c:out value="${event.name}" /></a>
                </td>
                <td><c:out value="${event.getDateFormatted()}" /></td>
                <td><c:out value="${event.location.city}" /></td>
                <td><c:out value="${event.host.firstName}" /></td>
                <td class="d-flex flex-row">
                  <c:choose>
                    <c:when test="${myAccount.id.equals(event.host.id)}">
                      <a class="btn btn-primary m-2" href="/events/${ event.id }/edit">Edit</a>
                        <form id="delete-form" action="/events/${event.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input class="btn btn-danger m-2" type="submit" value="Delete">
                        </form>
                    </c:when>
                    <c:when test="${!event.joining.contains(myAccount)}">
                      <form action="/events/${event.id}/join" method="post">
                        <input hidden name="event_id" value="${event.id}" />
                        <input type="submit" value="Join" class="btn btn-primary mx-2" />
                      </form>                    
                    </c:when>
                    <c:when test="${event.joining.contains(myAccount)}">
                        <div class="btn btn-info mx-2 disabled" >Joining</div>
                        <form class="d-inline" action="/events/${event.id}/leave" method="post">
                          <input type="hidden" name="_method" value="delete">
                          <input type="submit" value="Cancel" class="btn btn-danger mx-2" />
                      </form>
                    </c:when>
                    <c:otherwise>
                      <p>Other numbers.</p>
                    </c:otherwise>
                  </c:choose>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="row">
        <p>Here are some of the events in other states:</p>
        <table class="table table-bordered table-striped mt-3">
          <thead>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>state</th>
            <th>Host</th>
            <th>Action/Status</th>
          </thead>
          <tbody>
            <c:forEach items="${otherStateEvents}" var="event">
              <tr>
                <td>
                  <a href="/events/${event.id}"><c:out value="${event.name}" /></a>
                </td>
                <td><c:out value="${event.getDateFormatted()}" /></td>
                <td><c:out value="${event.location.city}" /></td>
                <td><c:out value="${event.location.state.name}" /></td>
                <td><c:out value="${event.host.firstName}" /></td>
                <td class="d-flex flex-row">
                  <c:choose>
                    <c:when test="${!event.joining.contains(myAccount)}">
                      <form action="/events/${event.id}/join" method="post">
                        <input hidden name="event_id" value="${event.id}" />
                        <input type="submit" value="Join" class="btn btn-primary mx-2" />
                      </form>          
                    </c:when>
                    <c:when test="${event.joining.contains(myAccount)}">
                        <div class="btn btn-info mx-2 disabled" >Joining</div>
                        <form class="d-inline" action="/events/${event.id}/leave" method="post">
                          <input type="hidden" name="_method" value="delete">
                          <input type="submit" value="Cancel" class="btn btn-danger mx-2" />
                          </form>
                    </c:when>
                    <c:otherwise>
                      <p>Other numbers.</p>
                    </c:otherwise>
                  </c:choose>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>

      <div class="row d-block">
        <h2 class="col-12 my-3">Create an Event</h2>
        <div class="col-6">
          <form:form action="/events" method="post" modelAttribute="eventForm">
            <div class="form-group">
              <label>Name:</label>
              <form:input path="name" class="form-control" />
              <form:errors path="name" class="text-danger" />
            </div>
            <div class="form-group">
              <label>Date:</label>
              <form:input type="date" path="date" class="form-control" />
              <form:errors path="date" class="text-danger" />
            </div>
            <div class="form-group">
              <label>Location:</label>
              <div class="row">
                <div class="col">
                  <form:input path="city" class="form-control" />
                  <form:errors path="city" class="text-danger" />
                </div>
                <div class="col">
                  <form:select path="state" class="form-control">
                    <c:forEach items="${states}" var="s">
                      <form:option value="${s}" label="${s.name}" />
                    </c:forEach>
                  </form:select>
                  <form:errors path="state" class="text-danger" />
                </div>
              </div>
            </div>
            <input type="submit" value="Create" class="btn btn-primary" />
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
