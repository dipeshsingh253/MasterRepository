<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.String" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
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
                <c:if test="${userRole == 'ROLE_MANAGER'}">
                    <li class="nav-item">
                        <a class="nav-link" href="/register">Register User</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="/users" >Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
	<div id="container">
    </div>
<script>

    const jwtToken = localStorage.getItem("jwtToken");

    fetch('/index', {
      method: 'GET',
      headers: {
        'Content-Type': 'text/html',
        'Authorization': 'Bearer '+jwtToken
      }
    })
    .then(response => {
      return response.text();
    })
    .then(data => {
      document.getElementById('container').innerHTML = data;
    })
    .catch(error => {
      console.error('Error:', error);
    });


   // Get the Users link element
   const usersLink = document.querySelector('a[href="/users"]');

   // Add a click event listener to the Users link
   usersLink.addEventListener('click', (event) => {
     event.preventDefault(); // Prevent the link from navigating to the URL

     // Fetch the HTML code from the server
     fetch('/users', {
       method: 'GET',
       headers: {
         'Content-Type': 'text/html',
         'Authorization': 'Bearer '+jwtToken
       }
     })
     .then(response => {
       return response.text();
     })
     .then(data => {
       // Set the fetched HTML code to the container div
       document.getElementById('container').innerHTML = data;
     })
     .catch(error => {
       console.error('Error:', error);
     });
   });


function handleView(e, ele) {
  e.preventDefault();
  console.log("View clicked for user with id", ele);
  // Make a fetch request to retrieve user details and display them in the modal
}


</script>


</body>
</html>
