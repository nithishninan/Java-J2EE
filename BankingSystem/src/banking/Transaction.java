package banking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import connectdb.dbConnection;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("After getting details");
		 res.setContentType( "text/html" ) ;
		    ServletOutputStream sos = res.getOutputStream();
		String accountno = req.getParameter("accno");
		String amount1 = req.getParameter("amount");
		int ac = Integer.parseInt(accountno);
		int am = Integer.parseInt(amount1);
		String str1 = req.getParameter("withdraw");
	    String str2 = req.getParameter("deposit");
	    int bal=2500000;
	    try {
			
			Connection con = dbConnection.getConnection();
			System.out.println("got Connection"+con);
			
		PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO amount_transaction(Sl. No.,Date,Description,Cheque No,Withdraw,Deposit,Available Balance) VALUES(?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	    ResultSet rs = pst.getGeneratedKeys();
	    
        int idValue = 1;
        if (rs.next()) {
            idValue = rs.getInt("id");
        }
                
	  //  sos.println("<h3>");
	    
	    if(str1 != null)
	    {    
	     sos.println("You clicked " + str1 + " submit button<br>");
	      bal=bal-am;
			pst.setInt(1,idValue);
			pst.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
			sos.println("Time and date" +new java.sql.Timestamp(new java.util.Date().getTime()));
			pst.setString(3,"Withdrawn from ATM");
			pst.setInt(4,0);
			pst.setInt(5,am);
			pst.setInt(6,0);
			pst.setInt(7,bal);
	    }			                         
	    else if(str2 != null)
	    { 
	      sos.println("You clicked " + str2 + " submit button<br>");	
	      bal=bal+am;
	      pst.setInt(1,idValue);
	      pst.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
	      sos.println("Time and date" +new java.sql.Timestamp(new java.util.Date().getTime()));
	      pst.setString(3,"Deposit");
	      pst.setInt(4,0);
	      pst.setInt(5,0);
	      pst.setInt(6,am);
		  pst.setInt(7,bal);
	    }
		   // sos.println("</h3>");
		    sos.close( );
	
boolean result = pst.execute();
if(result==false)
{
	res.sendRedirect("Transaction Success.html");
	System.out.println("data inserted successfully");	
}
else {
		res.sendRedirect("Transaction Failure.html");
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