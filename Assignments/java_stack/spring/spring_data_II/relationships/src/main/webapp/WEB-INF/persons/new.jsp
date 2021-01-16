<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Create new Person</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-5">
      <h1>New Person</h1>
      <form:form action="/persons/new" method="post" modelAttribute="person">
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
        <input type="submit" value="Submit" class="btn btn-primary float-right" />
      </form:form>
    </div>
  </body>
</html>
