package Moviehubpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
	
	//Connect DB
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//Insert Data Function
	public static boolean insertdata(String user_id, String payment_date, String payment_amount, String payment_status) {
		
		boolean isSuccess = false;
		try {
			//DB Connection Call
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			//SQL Query
			String sql = "insert into report values(0, '"+user_id+"', '"+payment_date+"', '"+payment_amount+"', '"+payment_status+"')";
			int rs = stmt.executeUpdate(sql);
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
		
	}
	
	//GetById
	 public static List<Report> getById (String Id){
		 
		 int convertID = Integer.parseInt(Id);
		 
		 ArrayList <Report> payment = new ArrayList<>();
		 
		 try {
			 //DBConnection
			 con = DBConnection.getConnection();
			 stmt = con.createStatement();
			 
			 //Query
			 String sql = "select * from report where transaction_id '"+convertID+"'";
			 
			 rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 int transaction_id = rs.getInt(1);
				 String user_id = rs.getString(2);
				 String payment_date = rs.getString(3);
				 String payment_amount = rs.getString(4);
				 String payment_status = rs.getString(5);
				 
				 
				 Report pay = new Report(transaction_id,user_id,payment_date,payment_amount,payment_status);
				 payment.add(pay);
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return payment;
	 }
	 
	 //GetAll Data
	 public static List<Report> getAllpayment(){
		 
		 ArrayList <Report> report = new ArrayList<>();
		 
		 try {
			 //DBConnection
			 con = DBConnection.getConnection();
			 stmt = con.createStatement();
			 
			 //Query
			 String sql = "select * from report";
			 
			 rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 int transaction_id = rs.getInt(1);
				 String user_id = rs.getString(2);
				 String payment_date = rs.getString(3);
				 String payment_amount = rs.getString(4);
				 String payment_status = rs.getString(5);
				 
				 Report pay = new Report(transaction_id,user_id,payment_date,payment_amount,payment_status);
				 report.add(pay);
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return report;
		 
	 }
	// Update Data
	 public static boolean updatedata(String transaction_id, String user_id, String payment_date, String payment_amount, String payment_status) {
	     boolean isSuccess = false;  
	     try {
	         // DBConnection
	         con = DBConnection.getConnection();
	         stmt = con.createStatement();
	         
	         // Query
	         String sql = "update report set user_id='"+user_id+"', payment_date='"+payment_date+"', payment_amount='"+payment_amount+"', payment_status='"+payment_status+"'"
	                      + "where transaction_id='"+transaction_id+"'";
	         

	         int rs = stmt.executeUpdate(sql);
	         
	         
	         if(rs > 0) { 
	             isSuccess = true;
	         } else {
	             isSuccess = false;
	         }
	     }
	     catch(Exception e) {
	         e.printStackTrace();
	     }
	     return isSuccess;
	 }
	 
	 //Delete Data
	 public static boolean deletedata(String transaction_id) {
		 
		 int conID = Integer.parseInt(transaction_id);
		 try {
			 //DB Connect
			 con = DBConnection.getConnection();
	         stmt = con.createStatement();
	         
	         String sql = "delete from report where transaction_id=" + conID;
	         
	         int rs = stmt.executeUpdate(sql);
	         
	         
	         if(rs > 0) { 
	             isSuccess = true;
	         } else {
	             isSuccess = false;
	         }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return isSuccess;
	 }
}
