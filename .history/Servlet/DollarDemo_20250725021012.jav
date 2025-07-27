import java.io.*; 
import java.net.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class DollarDemo extends HttpServlet { 
public void doPost(HttpServletRequest req,HttpServletResponse res)throws 
 ServletException,IOException,NullPointerException  
{ 
  res.setContentType("text/html"); 
  PrintWriter out=res.getWriter(); 
  String c=req.getParameter("currency"); 
  double RupeeValue,EuroValue,PoundValue; 
  double DollarValue=0; 
  String value=req.getParameter("currencyVal"); 
   
  if(c.equals("Rupees")) 
  { 
   RupeeValue=Double.parseDouble(value); 
   DollarValue=RupeeValue/61; 
  } 
  if(c.equals("Euro")) 
  { 
   EuroValue=Double.parseDouble(value); 
   DollarValue=EuroValue/0.77; 
  } 
  if(c.equals("Pound")) 
  {