import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;


public class depositamount extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
		try{
			StringBuffer datatosend=new StringBuffer(1024);
			datatosend.append("<?xml version=\"1.0\"?>");
			datatosend.append("<data>");
			
			String accountno_to_search=request.getParameter("accountno_to_search");
			System.out.println(accountno_to_search);
			
				Connection con=null;
				Statement st=null;
				ResultSet rt=null;
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","mysqladmin1");
			st=con.createStatement();
			
		rt=st.executeQuery("select name,balance from account where accountno="+accountno_to_search);
						while(rt.next())
						{
							datatosend.append("<member>");
							datatosend.append("<name>").append(rt.getString("name")).append("</name>");
							datatosend.append("<balance>").append(rt.getInt("balance")).append("</balance>");
							datatosend.append("<accno>").append(accountno_to_search).append("</accno>");
							datatosend.append("</member>");
							}
							
							rt.close();
							st.close();
							con.close();
							
							datatosend.append("</data>");
							
							response.setContentType("text/xml");
							response.setHeader("Cache-Control","no-cache");
							response.setHeader("Pragma","no-cache");
							response.setDateHeader("Expires",0);
							
							
							response.getWriter().write(datatosend.toString());
							
					datatosend=null;
				}
				
			catch(Exception e)
			{
				System.out.println(e);
				
				}
		}
							
public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
		try{	
			 String html_accno=request.getParameter("accno");
			 String html_remark=request.getParameter("remark");
			 String html_deposit_amount=request.getParameter("new_deposit_amount");
			 
			 Connection con=null;
			 Statement st=null;
			 ResultSet rt=null;
			 
			 Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","mysqladmin1");
			st=con.createStatement();
			 
		     StringBuffer query=new StringBuffer();
		     query.append("update account set balance=balance+").append(html_deposit_amount);
		     query.append(" where accountno=").append(html_accno);
		     
		     st.executeUpdate(query.toString());
		     
		     query.delete(0,query.length());
		     query.append("insert into transaction(accno,date,time,deposit,withdraw,remark)");
		     query.append(" values(").append(html_accno).append(",curdate(),curtime(),");
		     query.append(html_deposit_amount).append(",0,'").append(html_remark).append("')");
		     
		     st.executeUpdate(query.toString());
		     	
		     				response.setContentType("text/html");
							response.setHeader("Cache-Control","no-cache");
							response.setHeader("Pragma","no-cache");
							response.setDateHeader("Expires",0);
							
							
							response.getWriter().write("Successfully Executed");
							
							//response.getWriter().flush();
			}
			
				catch(Exception e)
			{
				System.out.println(e);
				
				}
	}
	
	}		