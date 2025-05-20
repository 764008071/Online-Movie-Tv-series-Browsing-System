package UserManagePackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // Retrieve id from request
	    String id = request.getParameter("id");
	    
	    // Check if the id is not null and not empty
	    if (id != null && !id.trim().isEmpty()) {
	        boolean isTrue;
	        isTrue = UserController.deletedata(id);
	        
	        if(isTrue) {
	            String alertMessage = "Data Delete Successful";
	            response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='GetAllServlet';</script>");
	        } else {
	            List<UserModel> userDetails = UserController.getById(id);
	            request.setAttribute("userDetails", userDetails);
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
	            dispatcher.forward(request, response);
	        }
	    } else {
	        // Handle case where ID is invalid (null or empty)
	        String alertMessage = "Invalid ID provided!";
	        response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='GetAllServlet';</script>");
	    }
	}
}