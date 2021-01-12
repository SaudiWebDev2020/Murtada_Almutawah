<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

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
    <div class="container">
      <div class="border mt-5 p-2">
        <form action="/result" method="post">
          <div class="form-group">
            <label>Your Name:</label>
            <input class="form-control" type="text" name="name" />
          </div>
          <div class="form-group">
            <label>Dojo Location:</label>
            <select name="dojoLocation" class="form-control">
              <option value="San Jose">San Jose</option>
              <option value="New York">New York</option>
            </select>
          </div>
          <div class="form-group">
            <label>Favorite Language:</label>
            <select name="favoriteLanguage" class="form-control">
              <option value="Python">Python</option>
              <option value="Java">Java</option>
            </select>
          </div>
          <div class="form-group">
            <label>Comment (optional):</label>
            <textarea class="form-control" name="comment" cols="40" rows="10" value="comment"></textarea>
          </div>
          <div class="d-flex justify-content-end">
            <input type="submit" value="Button" class="btn btn-primary" />
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
