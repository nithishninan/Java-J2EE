package banking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import connectdb.dbConnection;

/**
 * Servlet implementation class AccountCreation
 */
@WebServlet("/AccountCreation")
public class AccountCreation extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException{
		System.out.println("After getting details");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String mailid = request.getParameter("mailid");
		String accounttype = request.getParameter("accounttype");
		
		System.out.println("accounttype.."+accounttype);
		
		try {
	
			Connection con = dbConnection.getConnection();
			System.out.println("got Connection"+con);
			
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO account(Name,DOB,Address,Emailid,AccountType) VALUES(?,?,?,?,?)");
		pst.setString(1,name);
		pst.setString(2,dob);
		pst.setString(3,address);
		pst.setString(4,mailid);
		pst.setString(5,accounttype);
		
		boolean result = pst.execute();
		if(result==false)
		{
			response.sendRedirect("AccountCreated.html");
		System.out.println("data inserted successfully");	
		}
		else {
			response.sendRedirect("AccountNotCreated.html");
			System.out.println("Data not getting inserted");	
		}
					
					con.close();
		}
	    catch(Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		}
	}
