<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Create new question</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-5">
      <h1>What is your question?</h1>
      <form:form action="/questions/new" method="post" modelAttribute="newQuestion">
        <p>
          <form:label path="question">Question</form:label>
          <form:textarea path="question" class="form-control" />
          <form:errors path="question" class="text-danger" />
        </p>
        <p>
          <form:label path="tags">Tags</form:label>
          <form:input path="tags" class="form-control" />
          <form:errors path="tags" class="text-danger" />
        </p>
        <input type="submit" value="Submit" class="btn btn-primary float-right" />
      </form:form>
    </div>
  </body>
</html>
