import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;


public class login extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
		try{
			String login_id = request.getParameter("loginid");
			String login_pwd = request.getParameter("loginpwd");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","mysqladmin1");
			Statement st = con.createStatement();
			
			int found=0;
			ResultSet rt = st.executeQuery("select loginid,loginpwd from login");
				while(rt.next())
				{
					String db_login_id = rt.getString("loginid");
					String db_login_pwd = rt.getString("loginpwd");
					
					if(db_login_id.equals(login_id))
					{
						if(db_login_pwd.equals(login_pwd))
						{
							found=1;
							break;
							}
						}
					
					}
					rt.close();
					st.close();
					con.close();
			
			if(found ==1)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/menus.jsp");
				rd.forward(request,response);
				return;
				}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/failure_login.jsp");
				rd.forward(request,response);
				return;
				}
			
					
			
		/*	PrintWriter out = response.getWriter();
			out.write("<html><body> Message From Tomcat Server:");
			out.write("<br> Your LoginId Is " + login_id);
			out.write("<br> Your Password Is " + login_pwd);
			
				if(found == 0)
				{
					out.write("<br> <br> Unauthorized User");
					}
				else
				{
					out.write("<br> <br> Authorized User");
				}
					out.write("</body></html>");
			*/
			}
			
			
			catch(Exception e)
			{
				System.out.println(e);
				}
		}
	}