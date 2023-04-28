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

    <div class="jumbotron justify-center pt-4">
        <div class="container">
            <h1 class="display-4">Welcome to User Management System</h1>
    <%--
            <sec:authorize access="isAuthenticated()">
            <p class="lead"> You are <sec:authentication property="name" />! You have the role <sec:authentication property="authorities" />.</p>
            </sec:authorize>
    --%>
            <sec:authorize access="hasRole('ROLE_MANAGER')">
              <p>Welcome, Manager! I hope this will be another productive day.</p>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_COMANAGER')">
              <p>Welcome, Co-Manager! I hope this will be another productive day.</p>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_WORKER')">
              <p>Welcome, Worker! I hope this will be another productive day.</p>
            </sec:authorize>
        </div>
    </div>

    <div>
<%--
 <img src="${pageContext.request.contextPath}/images/image-1.jpg" class="rounded mx-auto d-block" alt="Image 1">
--%>
    </div>

</body>

</html>
