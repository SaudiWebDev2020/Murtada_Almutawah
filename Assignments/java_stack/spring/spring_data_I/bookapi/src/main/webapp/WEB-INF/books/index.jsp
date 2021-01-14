<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
      <h1>All Books</h1>
      <a href="/books/new" class="btn btn-primary float-right my-2">New Book</a>
      <table class="table text-center">
        <thead class="bg-dark text-light">
          <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Language</th>
            <th>Number of Pages</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${books}" var="book">
            <tr>
              <td><c:out value="${book.title}" /></td>
              <td><c:out value="${book.description}" /></td>
              <td><c:out value="${book.language}" /></td>
              <td><c:out value="${book.numberOfPages}" /></td>
              <td>
                <a href="/books/${book.id}/">View</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
