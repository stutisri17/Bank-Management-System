<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%
   Calendar cal=new GregorianCalendar();

   int day=cal.get(Calendar.DATE);
	int month=cal.get(Calendar.MONTH)+1;
	int year=cal.get(Calendar.YEAR);

  String date=day+"-"+month+"-"+year;
  String loginid=request.getParameter("loginid");
%>

<html>
<body>
<table width="100%"><tr><td align="left">
  Welcome <%=loginid%>
</td>
<td align="right">Date <%=date%></td>
</tr></table>
<br><br>

<table border="1" align=" center" cellpadding="4" cellspacing="4">
<tr align="center" valign="top">

<td>Account No.</td>
<td>Name</td>
<td>PhotoId</td>
<td>Gender</td>
<td>D.O.B</td>

<td>Phone no.</td>
<td>Address</td>
<td>Qualification</td>
<td>Balance</td>
<td>Status</td>
</tr>

<%
try
   {
 Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","mysqladmin1");

Statement st=con.createStatement();
ResultSet rt=st.executeQuery("select accountno,name,img_reference,gender,dob,phoneno,address,qualifications,balance,active from account order by accountno");


	while(rt.next())
	{
	String temp_active="Active";
	if(rt.getInt("active")==0)
	temp_active="Deleted";

	//String image="";
	//image = "D:\Web-Apps\Tomcat\webapps\firstapp\img\"+img_reference;

%>

<tr>
<td> <%=rt.getString("accountno")%> </td>
<td> <%=rt.getString("name")%> </td>
<td><img src=<%=rt.getString("img_reference")%> style="witdth:100px;height:100px"></td>

<td> <%=rt.getString("gender")%> </td>
<td> <%=rt.getString("dob")%> </td>

<td> <%=rt.getString("phoneno")%> </td>
<td> <%=rt.getString("address")%> </td>
<td> <%=rt.getString("qualifications")%> </td>
<td> <%=rt.getInt("balance")%> </td>
<td> <%=temp_active%> </td>

</tr>
<%
	}//while loop closed
	rt.close();	
	st.close();
	con.close();
   }
	catch(Exception e)
			{
				System.out.println(e);
				
				}
%>
</table>
</body>
</html>
















