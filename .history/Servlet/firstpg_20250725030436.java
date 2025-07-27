import java.io.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
public class firstpg extends HttpServlet { 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter(); 
        String uname = request.getParameter("user"); 
        String pass = request.getParameter("pwd"); 
        if(pass.equals("password")) 
        { 
            response.sendRedirect("secondpg?user_name="+uname+""); 
        } 
        else 
          out.println("<i> You have entered wrong password!!!</i>"); 
      }    
} 