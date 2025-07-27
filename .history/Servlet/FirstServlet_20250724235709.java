// Add this line

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response)
 throws IOException,ServletException
 {
   response.setContentType("text/html");
   PrintWriter out=response.getWriter();
   out.println("<!DOCTYPE html>");
   out.println("<html>");
   out.println("<head>");
   out.println("<title>Servlet Output</title>");
   out.println("</head>");
   out.println("<body>");
   out.println("<h1>Hello How are U?</h1>");
   out.println("<h2>I am enjoying this Servlet Application</h2>");
   out.println("<h3>See You later!</h3>");
   out.println("</body>");
   out.println("</html>");
}
}