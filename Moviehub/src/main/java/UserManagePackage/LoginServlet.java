package UserManagePackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get username, password, and role from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Initialize DB connection
        Connection con = DBConnection.getConnection();

        try {
            // Prepare SQL query to validate username, password, and role
            String query = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);

            // Execute query
            ResultSet rs = ps.executeQuery();

            // Check if user exists with correct role
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role); // Store role in session

                // Redirect based on the user's role
                switch (role) {
                    case "Admin":
                        response.sendRedirect("GetAllServlet");
                        break;
                    case "User":
                        response.sendRedirect("User.java");
                        break;
                    case "Content Provider":
                        response.sendRedirect("CPT.java");
                        break;
                    case "Manager":
                        response.sendRedirect("MGRGetAllServlet");
                        break;
                    default:
                        request.setAttribute("errorMessage", "Invalid role.");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        break;
                }
            } else {
                // If credentials are wrong, redirect to login page with error
                request.setAttribute("errorMessage", "Invalid username, password, or role.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
