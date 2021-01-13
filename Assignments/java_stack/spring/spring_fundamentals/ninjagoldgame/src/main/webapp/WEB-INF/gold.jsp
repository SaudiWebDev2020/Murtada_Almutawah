<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Gold</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <style>
      .window {
        display: block;
        background-color: rgba(255, 255, 255, 0.5);
      }
      .box {
        overflow-y: scroll;
        height: 400px;
        display: block;
      }
      .box p {
        margin: 0;
      }
      .win {
        color: green;
      }
      .lose {
        color: red;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="row my-3">
        <h3>Your Gold:</h3>
        <div class="col-2 border p-2 ml-2"><c:out value="${balance}" /></div>
        <a href="/reset" class="btn btn-danger mx-3">Reset</a>
      </div>

      <div class="row d-flex justify-content-between my-2">
        <c:forEach items="${places}" var="place">
          <div class="card text-center m-2" style="width: 15rem">
            <div class="card-body">
              <form action="/process_find" method="post">
                <input type="hidden" name="place_id" value="${place.getId()}" />
                <h5 class="card-title"><c:out value="${place.getName()}" /></h5>
                <p class="card-text">
                  (<c:choose>
                    <c:when test="${place.isNegative() && place.isPositive() }">Earns / Takes</c:when>
                    <c:when test="${place.isNegative() && !place.isPositive()}">Takes</c:when>
                    <c:when test="${!place.isNegative() && place.isPositive()}">Earns</c:when>
                  </c:choose>
                  <c:out value="${place.getMin()}" /> - <c:out value="${place.getMax()}" /> golds)
                </p>

                <button class="btn btn-primary">Find Gold</button>
              </form>
            </div>
          </div>
        </c:forEach>
      </div>

      <div class="row my-2">
        <h2>Activities:</h2>
        <div class="col-12 box mt-2 p-2 border">
          <c:forEach items="${activities}" var="activity">
            <!-- {%for value,className in massages reversed%} -->
            <p class="${activity.getStatus()}"><c:out value="${activity.getDescription()}" /></p>
          </c:forEach>
        </div>
      </div>
    </div>
  </body>
</html>
