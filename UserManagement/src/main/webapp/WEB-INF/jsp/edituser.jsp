<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>

    <h1>Edit User Form</h1>
    <form action="/edit/{id}" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value=${user.name} required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value=${user.email} required><br><br>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" value=${user.phone} required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value=${user.password} required><br><br>

        <label for="designation">Designation:</label>
        <select name="designation" required>
            <option value="">Select Designation</option>
            <option value="MANAGER">Manager</option>
            <option value="COMANAGER">Co-Manager</option>
            <option value="WORKER">Worker</option>
        </select><br><br>

        <button type="submit">Update</button>
    </form>

</body>
</html>
