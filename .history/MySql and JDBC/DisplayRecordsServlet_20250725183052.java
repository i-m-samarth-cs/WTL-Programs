import java.io.*;
import jakarta.servlet.*;         // CORRECTED IMPORT
import jakarta.servlet.http.*;    // CORRECTED IMPORT
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayRecordsServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Student Records</title>");
        out.println("<style>");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>All Student Records</h2>");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Samarth2004@");
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT * FROM students_table ORDER BY Roll_no");

            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Roll No</th>");
            out.println("<th>Name</th>");
            out.println("<th>Address</th>");
            out.println("<th>Phone</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            boolean recordsFound = false;
            while (rs.next()) {
                recordsFound = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("Roll_no") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("<td>" + rs.getString("phone") + "</td>");
                out.println("</tr>");
            }

            if (!recordsFound) {
                out.println("<tr><td colspan='4'>No records found in the database.</td></tr>");
            }

            out.println("</tbody>");
            out.println("</table>");

        } catch (SQLException e) {
            out.println("<h2>Database Error:</h2><p>" + e.getMessage() + "</p>");
            e.printStackTrace(out);
        } catch (ClassNotFoundException e) {
            out.println("<h2>JDBC Driver Error:</h2><p>" + e.getMessage() + "</p>");
            e.printStackTrace(out);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace(out);
            }
        }
        out.println("</body></html>");
        out.close();
    }
}