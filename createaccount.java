import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
public class createaccount extends HttpServlet
{
		public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
		{  
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List items=null;

		Iterator itr=null; 
		try{  int accountno=0;  
				String qualification="";
       			String name="";      
       			String img_reference="";     
       			String gender=""; 
       			String phoneno=""; 
       			String emailid=""; 
       			String address=""; 
       			String ssno=""; 
       			String panno=""; 
       			String account_type=""; 
       			String dob=""; 
       			String intermediate="";
       			String postgraduation="";
       			String graduation=""; 

   
   		items=upload.parseRequest(request);
    	itr=items.iterator();
    	Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","mysqladmin1"); 
		Statement st=con.createStatement(); 
		PreparedStatement ps;
		ResultSet rt=null;

			rt=st.executeQuery("select max(accountno) as col from account");
			while(rt.next())
			{
				accountno=rt.getInt("col");
			}
			rt.close();


			accountno++;
			String absolutePathToIndexJSP = request.getServletContext().getRealPath("/");
				
		
		
		
		img_reference=absolutePathToIndexJSP+"\\img\\"+accountno+".jpg";
			String db_image_path="img\\"+accountno+".jpg";

    while(itr.hasNext())
    {
        FileItem item=(FileItem) itr.next();
        if(item.isFormField())
        {  
            
            String namen=item.getFieldName();    
             if(namen.equals("name"))
             name=item.getString();

             String gendern=item.getFieldName();    
             if(gendern.equals("gender"))
             gender=item.getString();

            String phonenon=item.getFieldName();    
            if(phonenon.equals("phoneno"))
             phoneno=item.getString();

            String emailidn=item.getFieldName();    
            if(emailidn.equals("emailid"))
             emailid=item.getString();  

            String addressn=item.getFieldName();   
            if(addressn.equals("address"))
             address=item.getString();

            String ssnon=item.getFieldName();   
            if(ssnon.equals("ssno"))
             ssno=item.getString();

            String pannon=item.getFieldName();    
            if(pannon.equals("panno"))
             panno=item.getString();

            String dobn=item.getFieldName();    
            if(dobn.equals("dob"))
             dob=item.getString();

            String intermediaten=item.getFieldName();    
            if(intermediaten.equals("intermediate"))
             intermediate=item.getString();

            String graduationn=item.getFieldName();   
            if(graduationn.equals("graduation"))
             graduation=item.getString();

            String postgraduationn=item.getFieldName();    
            if(postgraduationn.equals("postgraduation"))
             postgraduation=item.getString();

            String account_typen=item.getFieldName();    
            if(account_typen.equals("account_type"))
             account_type=item.getString();


             


            
            

        } 
        else{
            
            if(intermediate!=null)
            qualification=intermediate;
            
            if(graduation!=null)
            qualification=qualification+" " + graduation;
            
            if(postgraduation!=null)
            qualification=qualification+ " " + postgraduation;


 


            String itemName=item.getName();
             
              
            File savedFile=new File(img_reference);
            item.write(savedFile);

        }

    }
    ps=con.prepareStatement("insert into account(name,gender,phoneno,emailid,address,ssno,panno,dob,qualifications,account_type,accountno,img_reference) values(?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,name);
ps.setString(2,gender);
ps.setString(3,phoneno);
ps.setString(4,emailid);
ps.setString(5,address);
ps.setString(6,ssno);
ps.setString(7,panno);
ps.setString(8,dob);
ps.setString(9,qualification);
ps.setString(10,account_type);
ps.setInt(11,accountno);
ps.setString(12,db_image_path);


			ps.executeUpdate();


			ps.close();




		st.close();
		con.close();



						//################# send emailid#############
				final String sourceEmail="Valienteleon13@gmail.com";      
				final String password="GOOdGirl@13Valiente";   

				String msg="Your bank account has been successfully created. Your account number is:"+accountno+"\n your name is:"+name;
				String subject="account created successfully";

			Properties props=new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");  
			props.put("mail.smtp.port", "587");  
			props.put("mail.smtp.auth", "true"); 
			props.put("mail.smtp.starttls.enable", "true");
	
			Authenticator authentication=new Authenticator()
			{
    		protected PasswordAuthentication getPasswordAuthentication()
    		{
        		return new PasswordAuthentication(sourceEmail,password);
    		}
		};
				
				
				
				Session session=Session.getInstance(props,authentication);

				Message message=new MimeMessage(session);
				message.setFrom(new InternetAddress(sourceEmail));
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailid));
				message.setSubject(subject);
				message.setContent(msg,"text/html;charset=utf-8");
				Transport.send(message);





				//#################send sms#################//
		StringBuffer response_http=new StringBuffer();

       String sms="Dear parent, today your ward is absent.WEB ERP";
       StringBuffer url=new StringBuffer(256);
       
       
       
       url.append("http://bulksms.arsalsoftware.com/bulksms/bulksms?username=arsa-teaching&password=teaching&source=ERPWEB&tempid=1207161511599933506");
       url.append("&entityid=1601772161468146020");
       url.append("&destination=").append(phoneno).append("&dlr=1&type=0&message=").append(URLEncoder.encode(sms.toString(),"UTF-8"));
       System.out.println(url.toString());
       URL obj=new URL(url.toString());
       HttpURLConnection  connect=(HttpURLConnection)obj.openConnection();
       connect.setRequestMethod("GET");
       
       
       
       
       response_http.append("<br><br>SMS Gateway Code:");
       BufferedReader in=new BufferedReader(new InputStreamReader(connect.getInputStream()));
       String inputLine="";
       while((inputLine=in.readLine())!=null)
       {
           response_http.append(inputLine);
       }
       in.close();
       obj=null;
       connect=null;






			////print on webpage///////////////
			PrintWriter out=response.getWriter();

			out.write("<html><body>Message From Tomcat Server: Account created Successfully<br>");
			out.write("your account no. is"+accountno+"<br>");
			out.write("your name is "+name+"</body></html>");
			out.print("<br>Mail Successfully sent");


			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
}