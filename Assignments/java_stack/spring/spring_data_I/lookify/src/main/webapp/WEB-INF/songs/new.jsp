<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Create new song</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-5">
      <div class="row">
        <h1 class="col">New song</h1>
        <a href="/dashboard" class="col text-right p-4 mr-4">Dashboard</a>
      </div>

      <form:form action="/songs" method="post" modelAttribute="song">
        <p>
          <form:label path="title">Title</form:label>
          <form:input path="title" class="form-control" />
          <form:errors path="title" class="text-danger" />
        </p>
        <p>
          <form:label path="artist">Artist</form:label>
          <form:input path="artist" class="form-control" />
          <form:errors path="artist" class="text-danger" />
        </p>
        <p>
          <form:label path="rating">Rating</form:label>
          <form:select path="rating" class="form-control">
            <c:forEach var="i" begin="0" end="10">
              <form:option value="${i}" label="${i}" />
            </c:forEach>
          </form:select>
          <form:errors path="rating" class="text-danger" />
        </p>
        <a href="/dashboard" class="btn btn-danger">cancel</a>
        <input type="submit" value="Submit" class="btn btn-primary float-right" />
      </form:form>
    </div>
  </body>
</html>
