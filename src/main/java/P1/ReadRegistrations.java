package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/readReg")

public class ReadRegistrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ReadRegistrations() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	
		response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
        out.println("<table border='1'>");
        out.println("<tr>");
    	out.println("<th>");
    	out.println("Name");
    	out.println("</th>");
    	
    	out.println("<th>");
    	out.println("Email");
    	out.println("</th>");
    	
    	out.println("<th>");
    	out.println("Mobile");
    	out.println("</th>");
    	out.println("</tr>");
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/app_dec_db","root","sayam");
			
			Statement s = con.createStatement();
			
			ResultSet result  = s.executeQuery("Select * from registration");
			while(result.next()) {
				out.println("<tr>");
				out.println("<td>");
		    	out.println(result.getString(1));
		    	out.println("</td>");
		    	
		    	out.println("<td>");
		    	out.println(result.getString(2));
		    	out.println("</td>");
		    	
		    	out.println("<td>");
		    	out.println(result.getString(3));
		    	out.println("</td>");
		    	out.println("</tr>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	out.println("</table>");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		
    	
		System.out.println("post");
	}

}
