import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;


public class menu extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
		try{
			if(request.getParameter("createaccount")!=null)
			{
			  RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/createaccount.jsp");
			  rd.forward(request,response);
			  return;
			}
		

			if(request.getParameter("depositamount")!=null)
			{
			  RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/depositamount.jsp");
			  rd.forward(request,response);
			  return;
			}
			if(request.getParameter("withdrawlamount")!=null)
			{
			  RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/withdrawlamount.jsp");
			  rd.forward(request,response);
			  return;
			}
			if(request.getParameter("ministatement")!=null)
			{
			  RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/ministatement.jsp");
			  rd.forward(request,response);
			  return;
			}
			
			if(request.getParameter("memberlist")!=null)
			{
			  RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/memberlist.jsp");
			  rd.forward(request,response);
			  return;
			}
		}
		catch(Exception e)
			{
				System.out.println(e);
				}
	}
}
		