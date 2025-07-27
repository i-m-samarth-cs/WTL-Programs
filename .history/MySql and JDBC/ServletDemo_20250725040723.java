import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;   // <--- THIS LINE IS CRUCIAL
import java.sql.SQLException; // <--- THIS LINE IS CRUCIAL
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServlet.HttpServletRequest; // Corrected import for HttpServletRequest
import jakarta.servlet.http.HttpServlet.HttpServletResponse; // Corrected import for HttpServletResponse

public class ServletDemo extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            // For newer MySQL Connector/J versions (8.x and above),
            // it's recommended to use "com.mysql.cj.jdbc.Driver"
            // However, "com.mysql.jdbc.Driver" might still work due to backward compatibility.
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root",
                                    "Samarth2004@");
            Statement stmt = con.createStatement();
            out.print("You are successfully Connected to Database...");
        } catch (SQLException e) {
            // It's better to log the exception for debugging purposes
            e.printStackTrace(); // This will print the stack trace to the server console
            throw new ServletException("Could not connect to the database or execute statement.", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Log the exception
            throw new ServletException("JDBC Driver not found. Make sure mysql-connector-j-x.x.x.jar is in WEB-INF/lib.", e);
        } finally {
            // Ensure the PrintWriter is closed even if an exception occurs
            if (out != null) {
                out.close();
            }
        }
    }
}
