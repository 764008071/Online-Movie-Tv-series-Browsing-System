package Moviehubpackage;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MGRUpdateServlet")
public class MGRUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String transaction_id = request.getParameter("transaction_id");
		String user_id = request.getParameter("user_id");
		String payment_date = request.getParameter("payment_date");
		String payment_amount = request.getParameter("payment_amount");
		String payment_status = request.getParameter("payment_status");
		
		System.out.println("Payment Amount: " + payment_amount);
		
		boolean isTrue;
		isTrue = ReportDAO.updatedata(transaction_id, user_id, payment_date, payment_amount, payment_status);
		
		if(isTrue == true) {
			List<Report> paymentdetails = ReportDAO.getById(transaction_id);
			request.setAttribute("paymentdetails", paymentdetails);
			
			String alertMessage = "Data Update Successful!!";
			response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='MGRGetAllServlet'</script>");
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
		}
		
	}

}
