
import java.io.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
 
public class Authentication extends HttpServlet 
{ 
 public void doGet(HttpServletRequest req,HttpServletResponse res)  
 throws ServletException,IOException 
 { 
  PrintWriter out=res.getWriter(); 
  res.setContentType("text/html"); 
 
  String username=req.getParameter("uname"); 
  String password=req.getParameter("pwd"); 
  if ((username=="Ankita")&&(password=="1234")) 
    out.print("Welcome "+username);    
  else 
   out.println("Invalid username"); 
 } 
} 
