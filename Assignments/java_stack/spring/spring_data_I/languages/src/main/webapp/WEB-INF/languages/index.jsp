<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-5">
      <div class="row">
        <table class="table text-center">
          <thead class="bg-dark text-light">
            <tr>
              <th>Name</th>
              <th>Creator</th>
              <th>Version</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${languages}" var="language">
              <tr>
                <td><a href="/languages/${language.id}"><c:out value="${language.name}" /></a></</td>
                <td><c:out value="${language.creator}" /></td>
                <td><c:out value="${language.currentVersion}" /></td>
                <td>
                  <div class="d-flex justify-content-center">
                  <form action="/languages/${language.id}" method="post">
                    <input type="hidden" name="_method" value="delete" />
                    <input type="submit" value="Delete" class="btn btn-danger mx-2" />
                  </form>
                  <a href="/languages/${language.id}/edit" class="btn btn-success">edit</a>
                  </div>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <form:form action="/languages" method="post" modelAttribute="language">
        <p>
          <form:label path="name">Name</form:label>
          <form:input path="name" class="form-control" />
          <form:errors path="name" class="text-danger" />
        </p>
        <p>
          <form:label path="creator">Creator</form:label>
          <form:input path="creator" class="form-control" />
          <form:errors path="creator" class="text-danger" />
        </p>
        <p>
          <form:label path="currentVersion">Version</form:label>
          <form:input path="currentVersion" class="form-control" />
          <form:errors path="currentVersion" class="text-danger" />
        </p>
        <input type="submit" value="Submit" class="btn btn-primary float-right" />
      </form:form>
    </div>
  </body>
</html>
