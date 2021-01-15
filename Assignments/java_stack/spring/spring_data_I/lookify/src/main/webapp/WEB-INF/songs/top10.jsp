<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Top 10</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container h-100 mt-2">
      <div class="row my-2">
        <div class="col">
          <p>Top ten Songs:</p>
        </div>
        <div class="col">
          <a href="/dashboard" class="mx-3">Dashboard</a>
        </div>
      </div>
      <div class="row">
        <ul class="list-group">
          <c:forEach items="${songs}" var="song">
            <li class="list-group-item">
              <c:out value="${song.rating}" /> - <a href="/songs/${song.id}"><c:out value="${song.title}" /></a> - <c:out value="${song.artist}" />
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </body>
</html>
