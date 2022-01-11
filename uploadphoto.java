import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.io.File;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

public class uploadphoto extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
		String accountno="100";
		
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = null;
			
			Iterator itr = null;
			
			try
			{
				items = upload.parseRequest(request);
				
				itr = items.iterator();
				
				while (itr.hasNext())
				{
					FileItem item = (FileItem) itr.next();
					
					if(item.isFormField())  //html form elements
					{
						String name = item.getFieldName();
						String value = item.getString();
						
								if(name.equals("accountno"))
								{
									accountno=value;
									}						
						
						}
						
						
					else{
						   
						  String itemName = item.getName();
						  
						  	String filename="d:\\ServerStorage\\"+accountno+".jpg";
						  	
						  	File savedFile = new File(filename);
						  	item.write(savedFile);
						}						
					}
				
				response.getWriter().print("Succesfully Saved");
				}
				
		catch(Exception e)
		{
			System.out.println(e);
			}
		
		}
	
	
	}