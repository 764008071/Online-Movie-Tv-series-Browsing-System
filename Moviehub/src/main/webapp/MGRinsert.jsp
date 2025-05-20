<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Registration</title> 
    <link rel="stylesheet" type="text/css" href="styles.css">   

</head>
<body>
    <div class="container">
        <h2>Enter Payment Details</h2>
        <button onclick="history.back()" class="back-button">Back to Payment Table</button>
        <form action="MGRInsertServlet" method="post">
            <div class="form-group">
                <label for="user_id">User ID:</label>
                <input type="text" id="user_id" name="user_id" required />
            </div>
            <div class="form-group">
                <label for="payment_date">Payment Date:</label>
                <input type="text" id="payment_date" name="payment_date" required />
            </div>
            <div class="form-group">
                <label for="payment_amount">Payment Amount:</label>
                <input type="text" id="payment_amount" name="payment_amount" required />
            </div>
            <div class="form-group">
                <label for="payment_status">Payment Status:</label>
                <input type="text" id="payment_status" name="payment_status" required />
            </div>
            <input type="submit" value="Submit" />
        </form>
    </div>
</body>
</html>