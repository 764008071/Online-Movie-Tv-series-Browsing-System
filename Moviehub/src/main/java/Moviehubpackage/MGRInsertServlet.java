package Moviehubpackage;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MGRInsertServlet")
public class MGRInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		String payment_date = request.getParameter("payment_date");
		String payment_amount = request.getParameter("payment_amount");
		String payment_status = request.getParameter("payment_status");
		boolean isTrue;
		
		isTrue  = ReportDAO.insertdata(user_id, payment_date, payment_amount, payment_status);
		
		if(isTrue == true) {
			String alertMessage = "Data Insert Successful!!";
			response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='MGRGetAllServlet'</script>");
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
		}
		
	}

}
