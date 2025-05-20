package UserManagePackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GetAllServlet")
public class GetAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests to retrieve all users
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<UserModel> userList = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM users";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserModel user = new UserModel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("role"),
                    rs.getString("username"),
                    rs.getString("password")
                );
                userList.add(user);
            }

            // Set the user list in request scope
            request.setAttribute("allUsers", userList);
            // Forward to display.jsp
            request.getRequestDispatcher("display.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions by forwarding to an error page or displaying a message
            request.setAttribute("errorMessage", "An error occurred while retrieving users.");
            request.getRequestDispatcher("display.jsp").forward(request, response);
        }
    }
}
