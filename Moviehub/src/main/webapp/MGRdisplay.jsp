<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
   
    String username = (String) session.getAttribute("username");
    if (username == null) {
     
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Management - Display Report</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
   
    <!-- JavaScript function to confirm deletion -->
    <script>
        function confirmDeletion() {
            return confirm('Are you sure you want to delete this Report?');
        }
    </script>
</head>
<body>

    <div class="top-right-buttons">
        <a href="MGRinsert.jsp"><button>Add New payment</button></a>
        <a href="LogOutServlet" onclick="return confirm('Are you sure you want to log out?');"><button>Logout</button></a>
    </div>

    <h2>Payment Table</h2>
    <div class="product-filter">
				<label for="filter">Filter Transactions:</label> <input type="text"
					id="searchInput" placeholder="serch.."></div><br>
    <table>
        <tr>
            <th>Transaction ID</th>
            <th>User ID</th>
            <th>Payment Date</th>
            <th>Payment Amount</th>
            <th>Payment Status</th>
            <th>Action</th>
        </tr>
        <c:forEach var="report" items="${allPayments}">
            <tr>
                <td>${report.transaction_id}</td>
                <td>${report.user_id}</td>
                <td>${report.payment_date}</td>
                <td>${report.payment_amount}</td>
                <td>${report.payment_status}</td>
                <td class="action-buttons">
                    <a href="MGRupdate.jsp?transaction_id=${report.transaction_id}&user_id=${report.user_id}&payment_date=${report.payment_date}&payment_amount=${report.payment_amount}&payment_status=${report.payment_status}">
                        <button>Update</button>
                    </a>
                   
                        <form action="MGRDeleteServlet" method="post" onsubmit="return confirmDeletion();">
                            <input type="hidden" name="transaction_id" value="${report.transaction_id}" />
                            <button type="submit">Delete</button>
                        </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!-- Product Search Section -->

	<script>
function filterTable() {
    var input, filter, table, tr, td, i, j, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase(); 
    table = document.querySelector("table"); 
    tr = table.getElementsByTagName("tr"); 
    
    for (i = 1; i < tr.length; i++) { 
        tr[i].style.display = "none"; 
        td = tr[i].getElementsByTagName("td");
        for (j = 0; j < td.length; j++) {
            if (td[j]) {
                txtValue = td[j].textContent || td[j].innerText; 
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = ""; 
                    break; 
                }
            }
        }
    }
}


document.getElementById("searchInput").addEventListener("input", filterTable);
</script>

</body>
</html>
