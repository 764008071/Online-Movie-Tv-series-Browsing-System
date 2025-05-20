package Moviehubpackage;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MGRDeleteServlet")
public class MGRDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String transaction_id = request.getParameter("transaction_id");
	    
	    if (transaction_id != null && !transaction_id.trim().isEmpty()) {
	        boolean isTrue;
	        isTrue = ReportDAO.deletedata(transaction_id);
	        
	        if(isTrue) {
	            String alertMessage = "Data Delete Successful";
	            response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='MGRGetAllServlet';</script>");
	        } else {
	            List<Report> paymentDetails = ReportDAO.getById(transaction_id);
	            request.setAttribute("paymentDetails", paymentDetails);
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
	            dispatcher.forward(request, response);
	        }
	    } else {
	        
	        String alertMessage = "Invalid ID provided!";
	        response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='MGRGetAllServlet';</script>");
	    }
	}
}
