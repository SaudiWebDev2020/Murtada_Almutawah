<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Create new ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-5">
      <h1>New ninja</h1>
      <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
        <p>
          <form:label path="dojo">Dojo</form:label>
          <form:select path="dojo" class="form-control">
            <form:option value="" label="Select a Dojo" />
            <c:forEach items="${dojos}" var="dojo">
              <form:option value="${dojo}" label="${dojo.name}" />
            </c:forEach>
          </form:select>
          <form:errors path="dojo" class="text-danger" />
        </p>
        <p>
          <form:label path="firstName">First Name</form:label>
          <form:input path="firstName" class="form-control" />
          <form:errors path="firstName" class="text-danger" />
        </p>
        <p>
          <form:label path="lastName">Last Name</form:label>
          <form:input path="lastName" class="form-control" />
          <form:errors path="lastName" class="text-danger" />
        </p>
        <p>
          <form:label path="age">Age</form:label>
          <form:input type="number" path="age" class="form-control" />
          <form:errors path="age" class="text-danger" />
        </p>
        <input type="submit" value="Submit" class="btn btn-primary float-right" />
      </form:form>
    </div>
  </body>
</html>
