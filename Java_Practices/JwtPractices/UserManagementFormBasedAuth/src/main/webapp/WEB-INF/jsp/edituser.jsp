<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .gradient-custom {
            background: #6a11cb;

            background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));

            background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))
        }
    </style>
</head>
<body>
   <%--
    <h1>Edit User Form</h1>
    <form action="${user.id}" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required><br><br>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" value="${user.phone}" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${user.password}" required><br><br>

        <label for="designation">Designation:</label>
        <select name="designation" required>
            <option value="${user.designation}">Select Designation</option>
            <option value="MANAGER">Manager</option>
            <option value="COMANAGER">Co-Manager</option>
            <option value="WORKER">Worker</option>
        </select><br><br>

        <button type="submit">Update</button>
    </form>
    --%>
 <section class="vh-100 gradient-custom">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card bg-dark text-white" style="border-radius: 1rem;">
              <div class="card-body p-5 text-center">

                <div class="mb-md-5 mt-md-4 pb-5">

                  <h2 class="fw-bold mb-2 text-uppercase">Edit User Form</h2>
                  <p class="text-white-50 mb-5">Update User Details</p>

                  <%--
                  <form action="${user.id}" method="post">
                      <div class="form-outline form-white mb-4">
                        <label class="form-label" for="name" class="text-left">Name</label>
                        <input type="text" id="name" class="form-control form-control-lg" name="name" value="${user.name}"/>
                      </div>
                      <div class="form-outline form-white mb-4">
                        <label class="form-label" for="email">Email</label>
                        <input type="email" id="email" class="form-control form-control-lg" name="email" value="${user.email}" />
                      </div>
                      <div class="form-outline form-white mb-4">
                        <label class="form-label" for="phone">Phone</label>
                        <input type="tel" id="phone" class="form-control form-control-lg" name="phone" value="${user.phone}"/>

                      </div>

                      <select class="form-select mb-4" aria-label="Designation" name="designation">
                        <option value="${user.designation}">Select Designation</option>
                        <option value="MANAGER">Manager</option>
                        <option value="COMANAGER">COMANAGER</option>
                        <option value="WORKER">WORKER</option>
                     </select>

                     <button class="btn btn-outline-light btn-lg px-5" type="submit">Update</button>
                  </form>
                  --%>

                  <form:form method="post" modelAttribute="user">
                      <div class="form-outline form-white mb-4">
                          <label class="form-label" for="name" class="text-left">Name</label>
                          <form:input type="text" id="name" class="form-control form-control-lg" path="name" />
                          <form:errors path="name" cssClass="text-danger" />
                      </div>
                      <div class="form-outline form-white mb-4">
                          <label class="form-label" for="email">Email</label>
                          <form:input type="email" id="email" class="form-control form-control-lg" path="email" />
                          <form:errors path="email" cssClass="text-danger" />
                      </div>
                      <div class="form-outline form-white mb-4">
                          <label class="form-label" for="phone">Phone</label>
                          <form:input type="tel" id="phone" class="form-control form-control-lg" path="phone" />
                          <form:errors path="phone" cssClass="text-danger" />
                      </div>

                      <form:select path="designation" class="form-select mb-4">
                          <form:option value="" label="Select Designation" />
                          <form:options items="${designations}" itemLabel="designation" itemValue="name" />
                      </form:select>

                      <button class="btn btn-outline-light btn-lg px-5" type="submit">Update</button>
                  </form:form>

                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

</body>
</html>
