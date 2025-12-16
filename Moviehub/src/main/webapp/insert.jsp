<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    

</head>
<body>
    <div class="container">
        <h2>Enter User Details</h2>
        <button onclick="history.back()" class="back-button">Back to User Table</button>
        <form action="InsertServlet" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required />
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required />
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" required />
            </div>
            <div class="form-group">
                <label for="role">Role:</label>
                <select id="role" name="role" required>
                    <option value="" selected disabled>Select the Role</option>
                    <option value="Manager">Manager</option>
                    <option value="Content Provider">Content Provider</option>
                    <option value="User">User</option>
                </select>
            </div>
            <div class="form-group">
                <label for="username">User Name:</label>
                <input type="text" id="username" name="username" required />
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required />
            </div>
            <input type="submit" value="Submit" />
        </form>
    </div>
</body>
</html>