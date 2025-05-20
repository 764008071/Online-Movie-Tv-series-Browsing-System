package Moviehubpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/MGRGetAllServlet")
public class MGRGetAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Report> paymentList = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM report";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Report payment = new Report(
                    rs.getInt("transaction_id"),
                    rs.getString("user_id"),
                    rs.getString("payment_date"),
                    rs.getString("payment_amount"),
                    rs.getString("payment_status")
                );
                paymentList.add(payment);
            }

            
            request.setAttribute("allPayments", paymentList);
           
            request.getRequestDispatcher("MGRdisplay.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions by forwarding to an error page or displaying a message
            request.setAttribute("errorMessage", "An error occurred while retrieving users.");
            request.getRequestDispatcher("MGRdisplay.jsp").forward(request, response);
        }
    }
}

