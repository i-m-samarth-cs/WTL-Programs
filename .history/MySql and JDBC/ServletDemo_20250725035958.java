import java.io.*; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
  
public class ServletDemo extends HttpServlet { 
   public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
      response.setContentType("text/html"); 
      PrintWriter out = response.getWriter(); 
      try { 
               Class.forName("com.mysql.jdbc.Driver"); 
              Connection con = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB","",""); 
             Statement stmt = con.createStatement(); 
             out.print("You are successfully Connected to Database..."); 
      } 
      catch (SQLException e) { 
            throw new ServletException("Could not display records.", e); 
      } 
      catch (ClassNotFoundException e) { 
              throw new ServletException("JDBC Driver not found.", e); 
       } 
      out.close(); 
    } 
} 