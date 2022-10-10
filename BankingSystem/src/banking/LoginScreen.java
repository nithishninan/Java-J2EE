package banking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectdb.dbConnection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginScreen")
public class LoginScreen extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("inside get method");	
		
		String uname=request.getParameter("username");
		String upass=request.getParameter("password");	
		
		
		System.out.println("uname ....."+uname);
		System.out.println("upass ....."+upass);
		
		try {
			
		
		
		Connection  con = dbConnection.getConnection();
		System.out.println("got connection "+con);
		
		 String query = "SELECT * FROM user_pass";
       
	      // create the java statement
	      Statement st = con.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        
	        String uName = rs.getString("user id");
	        String password = rs.getString("password");
	        
	        System.out.println("name is "+uName);
	        System.out.println("password is"+password);
	        // print the results
	   //     System.out.format("%s, %s, %s, %s, %s, %s\n", id,passwod);
	        
	        if (uname.equalsIgnoreCase(uName)&&upass.equalsIgnoreCase(password))
	        {
				response.sendRedirect("MainMenuDisplay.html");
			}
	        else
	        {
	        	response.sendRedirect("Invalid Login.html");
	        }
	        
	        
	        
	      }
	      st.close();
	    }
	    catch(Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  
		
		
	}
     
}
