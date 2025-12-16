<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
<a onclick="history.back()" class="back-button">
    <img src="IMG/previous.png" alt="Back" style="width: 50px; height: 50px; cursor: pointer;">
</a>


    <%
        // Retrieving parameters from the request
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String roll = request.getParameter("role");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    %>
    
    <form action="UpdateServlet" method="post">
      <table>
        <tr>
            <td>ID:</td>
            <td><input type="text" id="id" name="id" value="<%=id%>" readonly></td>
        </tr>
        <tr>
          <td>Name:</td>
          <td><input type="text" id="name" name="name" value="<%=name%>" required /></td>
        </tr>
        <tr>
          <td>Email:</td>
          <td><input type="text" id="email" name="email" value="<%=email%>" required /></td>
        </tr>
        <tr>
          <td>Phone:</td>
          <td><input type="text" id="phone" name="phone" value="<%=phone%>" required /></td>
        </tr>
        <tr>
          <td>Role:</td>
          <td>
            <select id="role" name="role" required>
              <option value="" disabled selected>Select the Role</option>
              <option value="Manager" <%= "Manager".equals(roll) ? "selected" : "" %> >Manager</option>
              <option value="Content Provider" <%= "Content Provider".equals(roll) ? "selected" : "" %>>Content Provider</option>
              <option value="User" <%= "User".equals(roll) ? "selected" : "" %>>User</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>UserName:</td>
          <td><input type="text" id="username" name="username" value="<%=username%>" required /></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type="password" id="password" name="password" value="<%=password%>" required /></td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="Submit" />
          </td>
        </tr>
      </table>
    </form>

</body>
</html>
