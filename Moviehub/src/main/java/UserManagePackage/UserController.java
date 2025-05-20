package UserManagePackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserController {
	
	//Connect DB
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//Insert Data Function
	public static boolean insertdata(String name, String email, String phone, String role, String username, String password) {
		
		boolean isSuccess = false;
		try {
			//DB Connection Call
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			//SQL Query
			String sql = "insert into users values(0, '"+name+"', '"+email+"', '"+phone+"', '"+role+"', '"+username+"', '"+password+"')";
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
	 public static List<UserModel> getById (String Id){
		 
		 int convertID = Integer.parseInt(Id);
		 
		 ArrayList <UserModel> user = new ArrayList<>();
		 
		 try {
			 //DBConnection
			 con = DBConnection.getConnection();
			 stmt = con.createStatement();
			 
			 //Query
			 String sql = "select * from users where id '"+convertID+"'";
			 
			 rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 int id = rs.getInt(1);
				 String name = rs.getString(2);
				 String email = rs.getString(3);
				 String phone = rs.getString(4);
				 String role = rs.getString(5);
				 String username = rs.getString(6);
				 String password = rs.getString(7);
				 
				 UserModel usr = new UserModel(id,name,email,phone,role,username,password);
				 user.add(usr);
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return user;
	 }
	 
	 //GetAll Data
	 public static List<UserModel> getAllUser(){
		 
		 ArrayList <UserModel> users = new ArrayList<>();
		 
		 try {
			 //DBConnection
			 con = DBConnection.getConnection();
			 stmt = con.createStatement();
			 
			 //Query
			 String sql = "select * from users";
			 
			 rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 int id = rs.getInt(1);
				 String name = rs.getString(2);
				 String email = rs.getString(3);
				 String phone = rs.getString(4);
				 String role = rs.getString(5);
				 String username = rs.getString(6);
				 String password = rs.getString(7);
				 
				 UserModel usr = new UserModel(id,name,email,phone,role,username,password);
				 users.add(usr);
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return users;
		 
	 }
	// Update Data
	 public static boolean updatedata(String id, String name, String email, String phone, String role, String username, String password) {
	     boolean isSuccess = false;  
	     try {
	         // DBConnection
	         con = DBConnection.getConnection();
	         stmt = con.createStatement();
	         
	         // Query
	         String sql = "update users set name='"+name+"', email='"+email+"', phone='"+phone+"', role='"+role+"', username='"+username+"', password='"+password+"'"
	                      + "where id='"+id+"'";
	         

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
	 public static boolean deletedata(String id) {
		 
		 int convID = Integer.parseInt(id);
		 try {
			 //DB Connect
			 con = DBConnection.getConnection();
	         stmt = con.createStatement();
	         
	         String sql = "delete from users where id=" + convID;
	         
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
