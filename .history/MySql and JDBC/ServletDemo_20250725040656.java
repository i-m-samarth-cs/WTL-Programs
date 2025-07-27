import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;   // <--- ADD THIS LINE
import java.sql.SQLException; // <--- ADD THIS LINE
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {
      public void doPost(HttpServletRequest request, HttpServletResponse response)
                  throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            try {
                  // For newer MySQL Connector/J versions (8.x and above),
                  // it's recommended to use "com.mysql.cj.jdbc.Driver"
                  // However, "com.mysql.jdbc.Driver" might still work due to backward compatibility.
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root",
                              "Samarth2004@");
                  Statement stmt = con.createStatement();
                  out.print("You are successfully Connected to Database...");
            } catch (SQLException e) {
                  throw new ServletException("Could not display records.", e);
            } catch (ClassNotFoundException e) {
                  throw new ServletException("JDBC Driver not found.", e);
             out.close();
      }
}