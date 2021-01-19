<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
  <head>
    <link
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <meta charset="ISO-8859-1" />
    <title>Question Details</title>
  </head>
  <body>
    <div class="container mt-3">
      <a href="/questions">Back</a>
      <h1 class="my-4"><c:out value="${question.question}" /></h1>
      <p>
        <strong>Tags: </strong>
        <c:forEach items="${question.tags}" var="tag"
          ><span class="bg-light mx-2 p-2 rounded"><c:out value="${tag.subject}" /></span
        ></c:forEach>
      </p>
      <div class="row">
        <div class="col">
          <table class="table table-striped">
            <thead>
              <th>Answers</th>
            </thead>
            <tbody>
              <c:forEach items="${question.answers}" var="a">
                <tr>
                  <td><c:out value="${a.answer}" /></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="col">
          <h4>Add your answer:</h4>
          <form:form action="/questions/${question.id}" method="post" modelAttribute="newAnswer">
            <p>
              <form:label path="answer">Answer</form:label>
              <form:textarea class="form-control" path="answer"></form:textarea>
              <form:errors path="answer" class="text-danger" />
            </p>
            <form:hidden path="question" value="${ question.id }" />
            <input type="submit" value="Answer it!" class="btn btn-primary float-right" />
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
