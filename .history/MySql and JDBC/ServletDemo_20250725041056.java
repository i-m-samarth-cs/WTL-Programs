import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {

    // Handles POST requests (your existing code)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response); // Delegate to a common method
    }

    // Handles GET requests
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response); // Delegate to the same common method
    }

    // Common logic for both GET and POST
    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root",
                                    "Samarth2004@");
            Statement stmt = con.createStatement(); // Note: stmt is created but not used for a query
            out.print("You are successfully Connected to Database...");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Could not connect to the database or execute statement.", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("JDBC Driver not found. Make sure mysql-connector-j-x.x.x.jar is in WEB-INF/lib.", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}