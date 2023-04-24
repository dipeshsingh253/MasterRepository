<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>

    <h1>Registration Form</h1>
    <form action="/register" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="designation">Designation:</label>
        <select name="designation" required>
            <option value="">Select Designation</option>
            <option value="MANAGER">Manager</option>
            <option value="COMANAGER">Co-Manager</option>
            <option value="WORKER">Worker</option>
        </select><br><br>

        <button type="submit">Register</button>
    </form>

</body>
</html>
