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
    <div class="container h-100 mt-2">
      <div class="row my-2">
        <div class="col">
          <p>Songs by artist: <c:out value="${searchedArtist}" /></p>
        </div>
        <div class="col">
          <form action="/search/" class="form-inline">
            <input type="text" name="artist" value="${searchedArtist}" class="form-control mr-2" />
            <input type="submit" value="New Search" class="btn btn-outline-primary" />
          </form>
        </div>
        <div class="col">
          <a href="/dashboard" class="btn btn-outline-primary float-right">Dashboard</a>
        </div>
      </div>
      <div class="row">
        <table class="table">
          <thead class="bg-dark text-light">
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
          </thead>
          <tbody>
            <c:forEach items="${songs}" var="song">
              <tr>
                <td>
                  <a href="/songs/${song.id}"><c:out value="${song.title}" /></a>
                </td>
                <td><c:out value="${song.rating}" /></td>

                <td>
                  <form action="/songs/${song.id}" method="post">
                    <input type="hidden" name="_method" value="delete" />
                    <input type="submit" value="Delete" class="btn btn-danger" />
                  </form>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>
