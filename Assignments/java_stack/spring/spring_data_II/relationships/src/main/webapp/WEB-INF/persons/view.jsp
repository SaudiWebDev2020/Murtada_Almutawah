<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>Person Details</title>
  </head>
  <body>
    <div class="container">
      <h1>${ person.firstName } ${ person.lastName }</h1>
      <p><strong>License Number</strong> ${ person.license.number }</p>
      <p><strong>Expiration Date</strong> ${ person.license.getExpirationDateFormatted() }</p>
    </div>
  </body>
</html>
