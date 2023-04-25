<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
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
    <form action="/login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"/><br/>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"/><br/>
        <input type="submit" value="Login"/>
    </form>
--%>
    <section class="vh-100 gradient-custom">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card bg-dark text-white" style="border-radius: 1rem;">
              <div class="card-body p-5 text-center">

                <div class="mb-md-5 mt-md-4 pb-5">

                  <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                  <p class="text-white-50 mb-5">Please enter your email and password!</p>
                  <form action="/login" method="post">
                      <div class="form-outline form-white mb-4">
                        <input type="email" id="typeEmailX" class="form-control form-control-lg" name="username" />
                        <label class="form-label" for="typeEmailX">Email</label>
                      </div>

                      <div class="form-outline form-white mb-4">
                        <input type="password" id="typePasswordX" class="form-control form-control-lg" name="password"/>
                        <label class="form-label" for="typePasswordX">Password</label>
                      </div>

                      <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
                  </form>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
</body>
</html>
