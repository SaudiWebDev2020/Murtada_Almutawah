<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Create new license</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-5">
      <h1>New license</h1>
      <form:form action="/licenses/new" method="post" modelAttribute="license">
        <p>
          <form:label path="person">Person</form:label>
          <form:select path="person" class="form-control">
            <form:option value="" label="Select a Person" />
            <c:forEach items="${persons}" var="person">
              <form:option value="${person}" label="${person.getFullName()}" />
            </c:forEach>
          </form:select>
          <form:errors path="person" class="text-danger" />
        </p>
        <p>
          <form:label path="state">State</form:label>
          <form:input path="state" class="form-control" />
          <form:errors path="state" class="text-danger" />
        </p>
        <p>
          <form:label path="expirationDate">Expiration Date</form:label>
          <form:input type="date" path="expirationDate" class="form-control" />
          <form:errors path="expirationDate" class="text-danger" />
        </p>
        <input type="submit" value="Submit" class="btn btn-primary float-right" />
      </form:form>
    </div>
  </body>
</html>
