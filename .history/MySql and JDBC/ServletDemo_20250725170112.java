import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException; // Already imported, good.
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {

    // Handles POST requests (your existing code)
    @Override // Good practice to add @Override annotation
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response); // Delegate to a common method
    }

    // Handles GET requests
    @Override // Good practice to add @Override annotation
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response); // Delegate to the same common method
    }

    // Common logic for both GET and POST
    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = null; // Declare out here for finally block
        Connection con = null; // Declare con here for finally block

        try {
            // FIX 1: Change deprecated driver class name to the new one
            // (com.mysql.cj.jdbc.Driver)
            // Even though SPI auto-registers, explicitly loading it can help avoid issues
            // in some setups
            Class.forName("com.mysql.cj.jdbc.Driver");

            // FIX 2: Update connection URL for modern MySQL Connector/J
            // Adding useSSL=false and allowPublicKeyRetrieval=true for development/local
            // setup
            // This helps avoid SSL-related warnings/errors.
            // Using your provided root username and password
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/StudentDB?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Samarth2004@");

            // Statement stmt is created but not used for a query, which is fine for just
            // testing connection.
            Statement stmt = con.createStatement();

            out = response.getWriter(); // Initialize out after potential exception from getConnection
            out.print("You are successfully Connected to Database...");

        } catch (SQLException e) {
            // Log the exception to the server console for debugging
            e.printStackTrace();
            // Also print to the browser for immediate feedback during development (remove
            // in production)
            if (out != null) {
                out.print("<h1>Database Connection Error!</h1>");
                out.print("<p>Details: " + e.getMessage() + "</p>");
                out.print("<pre>");
                e.printStackTrace(out); // Print stack trace to browser for debugging
                out.print("</pre>");
            }
            throw new ServletException("Could not connect to the database or execute statement.", e);

        } catch (ClassNotFoundException e) {
            // Log the exception to the server console for debugging
            e.printStackTrace();
            // Also print to the browser for immediate feedback during development (remove
            // in production)
            if (out != null) {
                out.print("<h1>JDBC Driver Not Found!</h1>");
                out.print("<p>Details: " + e.getMessage() + "</p>");
                out.print(
                        "<p>Make sure 'mysql-connector-j-9.4.0.jar' (or your version) is in Tomcat's 'lib' folder.</p>");
                out.print("<pre>");
                e.printStackTrace(out); // Print stack trace to browser for debugging
                out.print("</pre>");
            }
            throw new ServletException(
                    "JDBC Driver not found. Make sure mysql-connector-j-x.x.x.jar is in Tomcat's lib folder.", e);

        } finally {
            // FIX 3: Close the Connection in a finally block to ensure it's closed even if
            // errors occur.
            // Closing Statement is also good practice if you were using it for results.
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException closeException) {
                // Log any error during closing the connection
                closeException.printStackTrace();
            }

            // Ensure PrintWriter is closed.
            if (out != null) {
                out.close();
            }
        }
    }
}