package banking;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import connectdb.dbConnection;

/**
 * Servlet implementation class AuthorizeCC
 */
@WebServlet("/AuthorizeCC")
public class AuthorizeCC extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("After adding all details");
		String name = request.getParameter("name");
		String card = request.getParameter("cardno");
		String cvvno = request.getParameter("cvv");
		String amount = request.getParameter("amount1");
		System.out.println("name " +name+ "card" +card+ "cvv" +cvvno+ "amount" +amount);
		try {
			
			Connection con = dbConnection.getConnection();
			System.out.println("got Connection"+con);
			
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO creditauthority(Name,CardNo,CVV,Amount) VALUES(?,?,?,?)");
		pst.setString(1,name);
		pst.setString(2,card);
		pst.setString(3,cvvno);
		pst.setString(4,amount);
		
		boolean result = pst.execute();
		if(result==false)
		{
			response.sendRedirect("Authorized.html");
		System.out.println("data inserted successfully");	
		}
		else {
			response.sendRedirect("Unauthorized.html");
			System.out.println("Data not got inserted");	
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