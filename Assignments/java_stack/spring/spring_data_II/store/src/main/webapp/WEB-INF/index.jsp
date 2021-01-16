<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Store</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-2">
      <div>
        <h1>Product</h1>
        <div class="row">
          <a class="m-2" href="/products/new">Create a Product</a>
        </div>
        <table class="table">
          <thead>
            <th>Name</th>
            <th>description</th>
            <th>price</th>
            <th>Category Count</th>
          </thead>
          <tbody>
            <c:forEach items="${products}" var="product">
              <tr>
                <td>
                  <a href="/products/${product.id}"><c:out value="${product.name}" /></a>
                </td>
                <td><c:out value="${product.description}" /></td>
                <td><c:out value="${product.price}" /></td>
                <td><c:out value="${product.categories.size()}" /> categories</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div>
        <h1>Category</h1>
        <div class="row">
          <a class="m-2" href="/categories/new">Create a Category</a>
        </div>
        <table class="table">
          <thead>
            <th>Name</th>
            <th>Product Count</th>
          </thead>
          <tbody>
            <c:forEach items="${categories}" var="category">
              <tr>
                <td>
                  <a href="/categories/${category.id}"><c:out value="${category.name}" /></a>
                </td>
                <td><c:out value="${category.products.size()}" /> products</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>
