<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

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
    <div class="container mt-4">
      <h1>Hello Here =>.</h1>
      <div class="row">
        <div class="col-sm-7 border rounded p-3 mx-2">
          <h2>Register</h2>
          <hr />
          <form:form action="/register" method="post" modelAttribute="createUser">
            <div class="form-group">
              <label>First Name:</label>
              <form:input path="firstName" class="form-control" />
              <form:errors path="firstName" class="text-danger" />
            </div>
            <div class="form-group">
              <label>last Name:</label>
              <form:input path="lastName" class="form-control" />
              <form:errors path="lastName" class="text-danger" />
            </div>
            <div class="form-group">
              <label>Email:</label>
              <form:input path="email" class="form-control" />
              <form:errors path="email" class="text-danger" />
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
            <div class="form-group">
              <label>Password:</label>
              <form:password path="password" class="form-control" />
              <form:errors path="password" class="text-danger" />
            </div>
            <div class="form-group">
              <label>Password Confirmation:</label>
              <form:password path="passwordConfirmation" class="form-control" />
              <form:errors path="passwordConfirmation" class="text-danger" />
            </div>

            <input type="submit" value="Register" class="btn btn-primary" />
          </form:form>
        </div>
        <div class="col-sm-4 border rounded p-3 mx-2">
          <h2>login</h2>
          <hr />
          <form:form action="/login" method="post" modelAttribute="loginUser">
            <div class="form-group">
              <label>Email:</label>
              <form:input path="email" class="form-control" />
              <form:errors path="email" class="text-danger" />
            </div>
            <div class="form-group">
              <label>Password:</label>
              <form:password path="password" class="form-control" />
              <form:errors path="password" class="text-danger" />
            </div>
            <input type="submit" value="Login" class="btn btn-primary" />
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
