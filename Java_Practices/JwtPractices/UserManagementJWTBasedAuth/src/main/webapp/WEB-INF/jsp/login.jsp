<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form id="login-form" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
        </div>
        <button type="submit">Login</button>
    </form>

    <script>
        const loginForm = document.querySelector('#login-form');

        console.log(document.querySelector('#username').value);
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();

            const email = document.querySelector('#username').value;
            const password = document.querySelector('#password').value;


            fetch('/api/auth/login', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
              body: JSON.stringify({
                email: email,
                password: password
              })
            })
            .then(response => {
              if (response.ok) {
                return response.json();
              } else {
                throw new Error('Login failed.');
              }
            })
            .then(data => {
              // store the JWT token in local storage
              console.log(data.jwtToken);
              localStorage.setItem('jwtToken', data.jwtToken);
              // redirect the user to the home page
             window.location.href = '/home';

             //window.open('/home');
            })
            .catch(error => {
              console.error(error);
              alert('Login failed.');
            });
        });
    </script>
</body>
</html>
