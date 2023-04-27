<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.String" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<%--
    A simple jsp table form without validation

  <table>
      <thead>
          <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Designation</th>
              <th>Action</th>
          </tr>
      </thead>
      <tbody>
          <c:forEach items="${users}" var="user">
              <tr>
                  <td>${user.id}</td>
                  <td>${user.name}</td>
                  <td>${user.email}</td>
                  <td>${user.phone}</td>
                  <td>${user.designation}</td>
                  <td>
                      <c:if test="${userRole == 'ROLE_MANAGER' || userRole == 'ROLE_COMANAGER'}">
                        <a href="/edit/${user.id}">Edit</a>
                      </c:if>
                        <a href="/view/${user.id}">View</a>
                      <c:if test="${userRole == 'ROLE_MANAGER'}">
                        <a href="/remove/${user.id}" >Remove</a>
                      </c:if>
                  </td>
              </tr>
          </c:forEach>
      </tbody>
  </table>

  --%>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Phone</th>
      <th scope="col">Designation</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>

            <c:forEach items="${users}" var="user">
                <tr>
                    <th scope="row">${user.id}</th>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.designation}</td>
                    <td >
                       <c:if test="${userRole == 'ROLE_MANAGER' || (userRole == 'ROLE_COMANAGER' && user.designation != 'MANAGER')}">
                           <a href="/edit/${user.id}" class="btn btn-primary">Edit</a>
                       </c:if>
                          <a onClick="handleView(event, user.id)" href="#" class="btn btn-info">View</a>
                        <c:if test="${userRole == 'ROLE_MANAGER'}">
                          <a href="/remove/${user.id}" class="btn btn-danger">Remove</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
  </tbody>
</table>


</body>
</html>
