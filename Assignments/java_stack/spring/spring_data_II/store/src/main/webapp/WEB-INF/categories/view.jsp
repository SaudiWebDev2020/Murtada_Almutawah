<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>View Category <c:out value="${category.name}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-3">
      <a href="/">Back</a>
      <h1 class="my-3"><c:out value="${category.name}" /></h1>
      <div class="row">
        <div class="col">
          <h3>Products:</h3>
          <ul>
            <c:forEach items="${category.products}" var="product">
              <li><c:out value="${product.name}" /></li>
            </c:forEach>
          </ul>
        </div>
        <div class="col">
          <form:form action="/categories/${category.id}" method="post" modelAttribute="category_product">
            <form:hidden path="category" value="${category.id}" />
            <p>
              <form:label path="product">Add Product: </form:label>
              <form:select path="product" class="form-control">
                <form:option value="" label="Select a product" />
                <c:forEach items="${products}" var="product">
                  <form:option value="${product.id}" label="${product.name}" />
                </c:forEach>
              </form:select>
              <form:errors path="product" class="text-danger" />
            </p>
            <input type="submit" value="Submit" class="btn btn-primary float-right" />
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
