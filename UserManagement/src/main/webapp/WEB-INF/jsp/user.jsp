<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.String" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body >
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="#">User Management System</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="/home">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/register">Register User</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/users">Users</a>
					</li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
				</ul>
			</div>
		</div>
	</nav>
    <div class="mt-5 d-flex align-items-center justify-content-center">
        <div class="card" style="width: 18rem;">
          <div class="card-body">
            <h5 class="card-title">${user.name}</h5>
            <p class="card-text">${user.designation}</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Email : ${user.email}</li>
            <li class="list-group-item">Phone :${user.phone}</li>
          </ul>
          <div class="card-body">
                <a href="/users" class="btn btn-primary">Back</a>
          </div>
        </div>
    </div>

</body>
</html>
