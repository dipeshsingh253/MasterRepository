<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.String" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>


<h1>User List</h1>
<c:if test="${userRole == 'ROLE_MANAGER'}">
    <p>Hello Manager</p>
</c:if>
<c:if test="${userRole == 'ROLE_COMANAGER'}">
    <p>Hello Co-Manager</p>
</c:if>
<c:if test="${userRole == 'ROLE_WORKER'}">
    <p>Hello Worker</p>
</c:if>
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
                        <a href="/remove/${user.id}">Remove</a>
                      </c:if>
                  </td>
              </tr>
          </c:forEach>
      </tbody>
  </table>

</body>
</html>
