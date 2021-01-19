<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Questions Dashboard</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-3">
      <h2>Questions Dashboard</h2>
      <a href="/questions/new">New Question</a>
      <table class="table">
        <thead>
          <th>Question</th>
          <th>Tags</th>
        </thead>
        <tbody>
          <c:forEach items="${questions}" var="question">
            <tr>
              <td>
                <a href="/questions/${question.id}"> <c:out value="${question.question}" /></a>
              </td>
              <td>
                <c:forEach items="${question.tags}" var="tag"
                  ><span class="bg-light mx-2 p-2 rounded"><c:out value="${tag.subject}" /></span
                ></c:forEach>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
