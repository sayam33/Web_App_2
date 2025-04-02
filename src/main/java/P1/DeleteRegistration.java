package P1;

import java.io.IOException;

import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteReg")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public DeleteRegistration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		System.out.println("Get");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String email = request.getParameter("emailId");
		
		System.out.println(email);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/app_dec_db","root","sayam");
			
			Statement s = con.createStatement();
			s.executeUpdate
			("Delete from registration where email = '"+email+"'");
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}