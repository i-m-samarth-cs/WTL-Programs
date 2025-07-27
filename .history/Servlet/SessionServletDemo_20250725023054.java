import java.io.*; 
import java.util.*; 
import jakarta.servlet.*; 
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
cnt=new Integer(cnt.intValue()+1); 
  } 
 
session.setAttribute("cnt",cnt); 
  PrintWriter out=res.getWriter(); 
  out.println("<html>"); 
  out.println("<head>"); 
  out.println("</head>"); 
  out.println("<body>"); 
  out.println("<center>"); 
  out.println("<h1>"+heading); 
  out.println("<h2> The number of previous access= "+cnt); 
  out.println("</center>"); 
  out.println("</body>"); 
  out.println("</html>"); 
  } 
  }