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
        String transaction_id = request.getParameter("transaction_id");
        String user_id = request.getParameter("user_id");
		String payment_date = request.getParameter("payment_date");
		String payment_amount = request.getParameter("payment_amount");
		String payment_status = request.getParameter("payment_status");

    %>
    
    <form action="MGRUpdateServlet" method="post">
      <table>
        <tr>
            <td>Transaction ID:</td>
            <td><input type="text" id="transaction_id" name="transaction_id" value="<%=transaction_id%>" readonly></td>
        </tr>
        <tr>
          <td>User ID:</td>
          <td><input type="text" id="user_id" name="user_id" value="<%=user_id%>" required /></td>
        </tr>
        <tr>
          <td>Payment Date:</td>
          <td><input type="text" id="payment_date" name="payment_date" value="<%=payment_date%>" required /></td>
        </tr>
        <tr>
          <td>Payment Amount:</td>
          <td><input type="text" id="payment_amount" name="payment_amount" value="<%=payment_amount%>" required /></td>
        </tr>
        <tr>
          <td>Payment Status:</td>
          <td><input type="text" id="payment_status" name="payment_status" value="<%=payment_status%>" required /></td>
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
