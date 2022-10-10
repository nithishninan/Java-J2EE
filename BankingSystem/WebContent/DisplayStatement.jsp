<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@page import="connectdb.dbConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Statement</title>
</head>
<body bgcolor="#98FB98">
<center>
<h1>Display Statement</h1>
</center>
<!--  <form action="DisplayStatement" method="post"> Added as a Comment-->
<h5>Date Range<h5>
<table>
<tr>
<td>From</td>
<td><input type="Date" name="fromdate" required></td>
<td>To</td>
<td><input type="Date" name="todate" required></td>
<td><input type="submit" value="Display"><td>
</tr>
</table>

</form>
<br>
<br>
<br>
<table border=1 width=50% height=50%>
<tr><th>Sl. No.</th><th>DATE</th><th>Description</th><th>Cheque No</th><th>Withdraw</th><th>Deposit</th><th>Available Balance</th><tr>

<%
String sdate1 = request.getParameter("fromdate");
String sdate2 = request.getParameter("todate");
try{
Connection con =dbConnection.getConnection();
Statement st=con.createStatement();
String sql ="select * from amount_transaction where Date";
// between "+sdate1+" and "+sdate2+" :- added as a comment
ResultSet rs = st.executeQuery(sql);
while(rs.next())
{
%>

<tr>
<td><%=rs.getString("Sl. No.") %></td>
<td><%=rs.getString("Date") %></td>
<td><%=rs.getString("Description") %></td>
<td><%=rs.getString("Cheque No") %></td>
<td><%=rs.getString("Withdraw") %></td>
<td><%=rs.getString("Deposit") %></td>
<td><%=rs.getString("Available Balance") %></td>
</tr>

<%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>