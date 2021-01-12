<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
	
	    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
	    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	</head>
<body>
	<div class="container mt-5">
	
		<form method="POST" action="/code">
			<p class="text-danger"><c:out value="${error}"/></p>
			<div class="form-group">
				<label>What is the code ?</label>		
				<input class="form-control" type="text" name="code" />
			</div>
			
			<div>
				<input class="btn btn-primary" type="submit" value="Try Code" />
			</div>
		</form>
	
	</div>

</body>
</html>