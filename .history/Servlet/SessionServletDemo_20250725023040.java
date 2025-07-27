import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class SessionServletDemo extends HttpServlet 
{ 
 public void doGet(HttpServletRequest req,HttpServletResponse res) 
 throws ServletException,IOException 
 { 
   res.setContentType("text/html"); 
   HttpSession session=req.getSession(); 
   String heading; 
   Integer cnt=(Integer)session.getAttribute("cnt"); 
   if(cnt==null) 
   { 
    cnt=new Integer(0); 
     heading="Welcome You are accessing the page for the First Time"; 
   } 
  else 
  { 
   heading="Welcome once again!"; 
