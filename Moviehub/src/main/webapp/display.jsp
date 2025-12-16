<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
    // Check if the user is logged in
    String username = (String) session.getAttribute("username");
    if (username == null) {
        // If not logged in, redirect to login page
        response.sendRedirect("login.jsp");
        return;
    }
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management - Display Users</title>
    <link rel="stylesheet" type="text/css" href="styles.css">

    <!-- JavaScript function to confirm deletion -->
    <script>
        function confirmDeletion() {
            return confirm('Are you sure you want to delete this user?');
        }
    </script>
</head>
<body>

    <!-- Add New User and Logout buttons positioned in the top-right -->
    <div class="top-right-buttons">
        <a href="insert.jsp"><button>Add New User</button></a>
        <a href="LogOutServlet" onclick="return confirm('Are you sure you want to log out?');"><button>Logout</button></a>
    </div>

    <h2>User Table</h2>
    <div class="product-filter">
				<label for="filter">Filter Product:</label> <input type="text"
					id="searchInput" placeholder="search.."></div><br>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Role</th>
            <th>User Name</th>
            <th>Password</th>
            <th>Action</th>
        </tr>
        <c:forEach var="users" items="${allUsers}">
            <tr>
                <td>${users.id}</td>
                <td>${users.name}</td>
                <td>${users.email}</td>
                <td>${users.phone}</td>
                <td>${users.role}</td>
                <td>${users.username}</td>
                <td>${users.password}</td>
                <td class="action-buttons">
                    <a href="update.jsp?id=${users.id}&name=${users.name}&email=${users.email}&phone=${users.phone}&role=${users.role}&username=${users.username}&password=${users.password}">
                        <button>Update</button>
                    </a>
                    
                    <c:if test="${users.role != 'Admin'}">
                        <form action="DeleteServlet" method="post" onsubmit="return confirmDeletion();">
                            <input type="hidden" name="id" value="${users.id}" />
                            <button type="submit">Delete</button>
                        </form>
                    </c:if>

                </td>
            </tr>
        </c:forEach>
    </table>
    <!-- Product Search Section -->

	<script>
function filterTable() {
    var input, filter, table, tr, td, i, j, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase(); // Uppercase -> toUpperCase
    table = document.querySelector("table"); // Slector -> Selector
    tr = table.getElementsByTagName("tr"); // TagName -> ElementsByTagName
    
    for (i = 1; i < tr.length; i++) { 
        tr[i].style.display = "none"; // Default to hidden
        td = tr[i].getElementsByTagName("td");
        for (j = 0; j < td.length; j++) {
            if (td[j]) {
                txtValue = td[j].textContent || td[j].innerText; // textContenct -> textContent
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = ""; // Show row if match found
                    break; // Stop checking other cells
                }
            }
        }
    }
}


document.getElementById("searchInput").addEventListener("input", filterTable);
</script>

</body>
</html>
