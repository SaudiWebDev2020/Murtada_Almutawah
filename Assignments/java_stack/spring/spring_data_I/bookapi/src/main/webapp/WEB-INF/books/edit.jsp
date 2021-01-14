<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    
<div class="container mt-5">
    <h1>Edit Book</h1>
    <form:form action="/books/${book.id}/edit" method="post" modelAttribute="book">
        <p>
            <form:label path="title">Title</form:label>
            <form:input path="title" class="form-control"/>
            <form:errors path="title" class="text-danger"/>
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:textarea path="description" class="form-control"/>
            <form:errors path="description" class="text-danger"/>
        </p>
        <p>
            <form:label path="language">Language</form:label>
            <form:input path="language" class="form-control"/>
            <form:errors path="language" class="text-danger"/>
        </p>
        <p>
            <form:label path="numberOfPages">Pages</form:label>
            <form:input type="number" path="numberOfPages" class="form-control"/>
            <form:errors path="numberOfPages" class="text-danger"/>     
        </p>    
        <input type="submit" value="Submit" class="btn btn-primary"/>
        <a href="/books/${book.id}" class="btn btn-danger float-right">cancel</a>
    </form:form>
</div>

</body>
</html>
