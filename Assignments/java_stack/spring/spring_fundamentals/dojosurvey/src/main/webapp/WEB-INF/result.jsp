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
        <h3>Submitted info</h3>
        <div class="row">
          <div class="col-sm-4 offset-2">Name:</div>
          <div class="col-sm-6"><c:out value="${result.getName()}" /></div>
        </div>
        <div class="row">
          <div class="col-sm-4 offset-2">Dojo Location:</div>
          <div class="col-sm-6"><c:out value="${result.getLocation()}" /></div>
        </div>
        <div class="row">
          <div class="col-sm-4 offset-2">Favorite Language:</div>
          <div class="col-sm-6"><c:out value="${result.getLanguage()}" /></div>
        </div>
        <div class="row">
          <div class="col-sm-4 offset-2">Comment:</div>
          <div class="col-sm-6"><c:out value="${result.getComment()}" /></div>
        </div>
        <div class="d-flex justify-content-end">
          <a href="/" class="btn btn-primary">Go Back</a>
        </div>
      </div>
    </div>
  </body>
</html>
