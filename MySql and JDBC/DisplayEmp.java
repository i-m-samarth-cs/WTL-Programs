import java.io.*;
import jakarta.servlet.*; // Corrected import for Tomcat 10+
import jakarta.servlet.http.*; // Corrected import for Tomcat 10+
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayEmp extends HttpServlet {
    // Database credentials and URL for MySQL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/company_db"; // Connect to company_db
    private static final String USER = "root";
    private static final String PASS = "Samarth2004@"; // Your MySQL password

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Start HTML output
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Employee Records</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f4; color: #333; }");
        out.println(
                ".container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); max-width: 800px; margin: 0 auto; }");
        out.println("h1 { color: #0056b3; text-align: center; margin-bottom: 20px; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; color: #555; font-weight: bold; }");
        out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
        out.println(".back-link { text-align: center; margin-top: 30px; }");
        out.println(
                ".back-link a { background-color: #007bff; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px; transition: background-color 0.3s ease; }");
        out.println(".back-link a:hover { background-color: #0056b3; }");
        out.println(".error-message { color: #dc3545; font-weight: bold; text-align: center; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h1>Employee Details</h1>");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = con.createStatement();

            // Execute query
            rs = stmt.executeQuery("SELECT EmployeeID, Name FROM Employee ORDER BY EmployeeID");

            // Display records in a table
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr><th>Employee ID</th><th>Name</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");

            boolean recordsFound = false;
            while (rs.next()) {
                recordsFound = true;
                // Retrieve by column name
                int id = rs.getInt("EmployeeID");
                String name = rs.getString("Name");

                // Print row
                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("</tr>");
            }

            if (!recordsFound) {
                out.println("<tr><td colspan='2'>No employee records found.</td></tr>");
            }

            out.println("</tbody>");
            out.println("</table>");

        } catch (SQLException se) {
            // Handle errors for JDBC
            out.println("<p class=\"error-message\">Database Error: " + se.getMessage() + "</p>");
            se.printStackTrace(out); // Print stack trace to browser for debugging
        } catch (ClassNotFoundException e) {
            // Handle errors for Class.forName
            out.println("<p class=\"error-message\">JDBC Driver not found: " + e.getMessage() + "</p>");
            e.printStackTrace(out); // Print stack trace to browser for debugging
        } catch (Exception e) {
            // Handle other errors
            out.println("<p class=\"error-message\">An unexpected error occurred: " + e.getMessage() + "</p>");
            e.printStackTrace(out); // Print stack trace to browser for debugging
        } finally {
            // Clean-up environment
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException se2) {
                /* ignore */ }
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                /* ignore */ }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace(out); // Log error closing connection
            }
        }
        out.println("<div class=\"back-link\"><a href=\"index.html\">Go Back to Home</a></div>");
        out.println("</div></body></html>");
        out.close();
    }
}