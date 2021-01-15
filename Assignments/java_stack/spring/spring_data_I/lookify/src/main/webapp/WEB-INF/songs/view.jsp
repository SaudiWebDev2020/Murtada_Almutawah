<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>View <c:out value="${song.title}" /></title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-5">
      <div class="row">
        <a href="/dashboard" class="btn btn-primary my-2 ml-auto mr-3">Dashboard</a>
      </div>
      <div class="card mt-2 p-3">
        <table class="col-6 my-4">
          <tbody>
            <tr>
              <td>Title:</td>
              <td><c:out value="${song.title}" /></td>
            </tr>
            <tr>
              <td>Artist:</td>
              <td><c:out value="${song.artist}" /></td>
            </tr>
            <tr>
              <td>Rating (1-10):</td>
              <td><c:out value="${song.rating}" /></td>
            </tr>
          </tbody>
        </table>
        <form action="/songs/${song.id}" method="post">
          <input type="hidden" name="_method" value="delete" />
          <input type="submit" value="Delete" class="btn btn-danger" />
        </form>
      </div>
    </div>
  </body>
</html>
