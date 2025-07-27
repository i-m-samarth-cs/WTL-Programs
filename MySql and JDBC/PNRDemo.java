import java.io.*;
import jakarta.servlet.*; // Corrected import for Tomcat 10+
import jakarta.servlet.http.*; // Corrected import for Tomcat 10+
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // Using PreparedStatement for security
import java.sql.ResultSet;
import java.sql.SQLException;

public class PNRDemo extends HttpServlet {
    // Database credentials and URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pnr_db"; // Connect to pnr_db
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
        out.println("<title>PNR Status Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f4; color: #333; }");
        out.println(
                ".container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); max-width: 500px; margin: 0 auto; text-align: center; }");
        out.println("h1 { color: #0056b3; margin-bottom: 20px; }");
        out.println("p { font-size: 1.1em; line-height: 1.6; }");
        out.println(".status-confirmed { color: #28a745; font-weight: bold; }");
        out.println(".status-waiting { color: #ffc107; font-weight: bold; }");
        out.println(".status-cancelled { color: #dc3545; font-weight: bold; }");
        out.println(".status-notfound { color: #6c757d; font-weight: bold; }");
        out.println(".back-link { margin-top: 20px; }");
        out.println(
                ".back-link a { background-color: #007bff; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px; transition: background-color 0.3s ease; }");
        out.println(".back-link a:hover { background-color: #0056b3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h1>PNR Status Result</h1>");

        Connection con = null;
        PreparedStatement pstmt = null; // Use PreparedStatement
        ResultSet rs = null;

        String pnrNo = request.getParameter("pnrNo"); // Get PNR from the HTML form

        if (pnrNo == null || pnrNo.trim().isEmpty()) {
            out.println("<p>Please enter a PNR Number to check its status.</p>");
            out.println("<div class=\"back-link\"><a href=\"pnr_input.html\">Go Back</a></div>");
            out.println("</div></body></html>");
            out.close();
            return; // Stop execution if PNR is not provided
        }

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // SQL query to retrieve status for the given PNR
            String sql = "SELECT status FROM PNR_table WHERE PNR_No = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, pnrNo); // Set the PNR number as a parameter

            // Execute query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // PNR found, display status
                String status = rs.getString("status");
                String statusClass = "";
                switch (status.toLowerCase()) {
                    case "confirmed":
                        statusClass = "status-confirmed";
                        break;
                    case "waiting list":
                        statusClass = "status-waiting";
                        break;
                    case "cancelled":
                        statusClass = "status-cancelled";
                        break;
                    default:
                        statusClass = "status-notfound"; // Generic for other statuses
                        break;
                }
                out.println("<p>PNR Number: <strong>" + pnrNo + "</strong></p>");
                out.println("<p>Status: <span class=\"" + statusClass + "\">" + status + "</span></p>");
            } else {
                // PNR not found
                out.println("<p class=\"status-notfound\">PNR Number <strong>" + pnrNo + "</strong> not found.</p>");
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            out.println("<p>Database Error: " + se.getMessage() + "</p>");
            se.printStackTrace(out); // Print stack trace to browser for debugging
        } catch (Exception e) {
            // Handle other errors (e.g., ClassNotFoundException)
            out.println("<p>Application Error: " + e.getMessage() + "</p>");
            e.printStackTrace(out); // Print stack trace to browser for debugging
        } finally {
            // Clean-up environment
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException se2) {
                /* do nothing */ }
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException se2) {
                /* do nothing */ }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace(out); // Log error closing connection
            }
        }
        out.println("<div class=\"back-link\"><a href=\"pnr_input.html\">Check Another PNR</a></div>");
        out.println("</div></body></html>");
        out.close();
    }
}